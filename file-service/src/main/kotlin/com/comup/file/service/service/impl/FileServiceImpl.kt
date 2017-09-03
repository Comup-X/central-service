package com.comup.file.service.service.impl

import com.comup.file.service.entity.FileInfo
import com.comup.file.service.entity.pk.FileInfoPK
import com.comup.file.service.repository.FileInfoRepository
import com.comup.file.service.service.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.*
import java.net.URI
import java.nio.charset.StandardCharsets
import java.nio.file.Paths
import java.util.*
import javax.persistence.criteria.Predicate
import javax.servlet.http.HttpServletResponse
import kotlin.collections.ArrayList

@Service
class FileServiceImpl : FileService {

    @Value("\${image.upload.location}")
    private lateinit var uploadLocation: String

    @Autowired
    private lateinit var fileInfoRepository: FileInfoRepository

    override fun saveFile(file: MultipartFile, parentIdentifier: String?): FileInfo {
        return saveFileInfoToDB(saveToFileSystem(file), parentIdentifier)
    }

    override fun listFile(currentPage: Int, pageSize: Int, fileTypes: List<String>?): Page<FileInfo> {
        val pageRequest = PageRequest(currentPage, pageSize, Sort.Direction.DESC, "uploadDate")

        val specification = Specification<FileInfo> { root, query, cb ->
            if (fileTypes != null && fileTypes.isNotEmpty()) {
                val predicates = ArrayList<Predicate>()
                fileTypes.mapTo(predicates) { cb.like(root.get<String>("fileType"), it + "%") }
                query.where(cb.or(*predicates.toTypedArray()))
            }
            null
        }
        return fileInfoRepository.findAll(specification, pageRequest)
    }

    override fun flushFile(response: HttpServletResponse, fileInfoPK: FileInfoPK) {
        val fileInfo = fileInfoRepository.findOne(fileInfoPK) ?: throw FileNotFoundException()
        //为了解决中文名称乱码问题
        val filename = fileInfo.originalFilename!!.toByteArray(StandardCharsets.UTF_8).toString(StandardCharsets.ISO_8859_1)
        response.setHeader("Content-Disposition", "attachment; filename=" + filename)
        response.contentType = "application/octet-stream; charset=utf-8"
        val file = if (fileInfo.fileInfoPK!!.scheme == "file") {
            File(Paths.get(fileInfo!!.fileInfoPK!!.path, fileInfo.fileInfoPK!!.fileName).toUri())
        } else {
            val uri = URI(fileInfoPK.scheme, null, fileInfoPK.host, fileInfoPK.port, fileInfoPK.path, null, null)
            File(uri)
        }
        val inputStream = FileInputStream(file)
        var b = inputStream.read()
        while (b != -1) {
            response.outputStream.write(b)
            b = inputStream.read()
        }
        inputStream.close()
    }

    private fun saveToFileSystem(file: MultipartFile): FileInfo {
        if (!file.isEmpty) {
            val path = Paths.get(uploadLocation).toFile()
            var mkSuccess = if (!path.exists()) path.mkdirs() else true
            if (!mkSuccess) throw IllegalAccessException("Create file directory error")

            val split = file.originalFilename.split(".")
            val fileInfoPK = FileInfoPK()
            val fileInfo = FileInfo(fileInfoPK = fileInfoPK, originalFilename = file.originalFilename, fileType = file.contentType)
            fileInfoPK.scheme = "file"
            fileInfoPK.host = ""
            fileInfoPK.port = 0
            fileInfoPK.path = uploadLocation
            fileInfoPK.fileName = UUID.randomUUID().toString() + "." + split[split.lastIndex]


            val willSaveFile = Paths.get(uploadLocation, fileInfoPK.fileName).toFile()
            mkSuccess = if (!willSaveFile.exists()) willSaveFile.createNewFile() else true
            if (!mkSuccess) throw IllegalAccessException("文件创建失败")

            val outputStream = FileOutputStream(willSaveFile)
            val out = BufferedOutputStream(outputStream)
            out.write(file.bytes)
            out.flush()
            out.close()
            outputStream.close()
            return fileInfo
        } else {
            throw IllegalArgumentException("文件不能为空")
        }
    }

    private fun saveFileInfoToDB(fileInfo: FileInfo, parentIdentifier: String?): FileInfo {
        fileInfo.uploadDate = Date()
        fileInfo.parentIdentifier = parentIdentifier
        fileInfoRepository.save(fileInfo)
        return fileInfo
    }
}