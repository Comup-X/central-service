package com.comup.api.controller

import com.comup.api.client.ImageClient
import com.comup.common.model.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletRequest

@RestController
class ImageController {

    @Autowired
    private lateinit var imageClient: ImageClient

    @CrossOrigin
    @PostMapping("/imageUpload")
    fun uploadImage(request: HttpServletRequest, @RequestParam("file") file: MultipartFile): Result {
        return imageClient.uploadImage(request, file)
    }
}