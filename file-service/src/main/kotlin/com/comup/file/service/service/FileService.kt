package com.comup.file.service.service

import com.comup.file.service.entity.FileInfo
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun saveFile(file: MultipartFile, parentIdentifier: String?): FileInfo
}