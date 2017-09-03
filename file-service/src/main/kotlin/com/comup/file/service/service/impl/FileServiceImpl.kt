package com.comup.file.service.service.impl

import com.comup.file.service.entity.FileInfo
import com.comup.file.service.entity.pk.FileInfoPK
import com.comup.file.service.repository.FileInfoRepository
import com.comup.file.service.service.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.nio.file.Paths
import java.time.LocalDateTime
import java.util.*

@Service
class FileServiceImpl : FileService {

    @Value("\${image.upload.location}")
    private lateinit var uploadLocation: String

    @Autowired
    private lateinit var fileInfoRepository: FileInfoRepository

    override fun saveFile(file: MultipartFile, parentIdentifier: String?): FileInfo {
        return saveFileInfoToDB(saveToFileSystem(file), parentIdentifier)
    }

    private fun saveToFileSystem(file: MultipartFile): FileInfo {
        if (!file.isEmpty) {
            val path = Paths.get(uploadLocation).toFile()
            var mkSuccess = if (!path.exists()) path.mkdirs() else true
            if (!mkSuccess) throw IllegalAccessException("Create file directory error")

            val split = file.originalFilename.split(".")
            val fileInfoPK = FileInfoPK()
            val fileInfo = FileInfo(fileInfoPK = fileInfoPK, originalFilename = file.originalFilename)
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
        fileInfo.uploadDate = LocalDateTime.now()
        fileInfo.parentIdentifier = parentIdentifier
        fileInfoRepository.save(fileInfo)
        return fileInfo
    }
}