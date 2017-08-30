package com.comup.image.service.service

import com.comup.image.service.entity.FileInfo
import org.springframework.web.multipart.MultipartFile

interface FileService {
    fun saveFile(file:MultipartFile):FileInfo
}