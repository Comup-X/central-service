package com.comup.image.service.service.impl

import com.comup.image.service.entity.FileInfo
import com.comup.image.service.service.FileService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.nio.file.Paths
import java.util.*

@Service
class FileServiceImpl : FileService {

    @Value("\${image.upload.location}")
    private lateinit var uploadLocation: String

    override fun saveFile(file: MultipartFile): FileInfo {
        saveToFileSysterm(file)
        saveFileInfoToDB()
    }

    private fun saveToFileSysterm(file: MultipartFile) {
        if (!file.isEmpty) {
            val path = Paths.get(uploadLocation).toFile()
            var mkSuccess = if (!path.exists()) path.mkdirs() else true
            if (!mkSuccess) throw IllegalAccessException("文件目录创建失败")

            val split = file.originalFilename.split(".")
            val fileName = UUID.randomUUID().toString() + "." + split[split.lastIndex]
            val willSaveFile = Paths.get(uploadLocation, fileName).toFile()
            mkSuccess = if (!willSaveFile.exists()) willSaveFile.createNewFile() else true
            if (!mkSuccess) throw IllegalAccessException("文件创建失败")

            val outputStream = FileOutputStream(willSaveFile)
            val out = BufferedOutputStream(outputStream)
            out.write(file.bytes)
            out.flush()
            out.close()
            outputStream.close()
        } else {
            throw IllegalArgumentException("文件不能为空")
        }
    }

    private fun saveFileInfoToDB(fileInfo: FileInfo) {}
}