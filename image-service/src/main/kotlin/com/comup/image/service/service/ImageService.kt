package com.comup.image.service.service

import com.comup.common.model.Result
import org.springframework.web.multipart.MultipartFile

interface ImageService {
    fun saveFile(file: MultipartFile):Result
}