package com.comup.api.controller

import com.comup.api.client.ImageClient
import com.comup.common.model.Result
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
class ImageController {

    @Autowired
    private lateinit var imageClient: ImageClient

    @CrossOrigin("*")
    @PostMapping(value = "/imageUpload")
    fun uploadImage(@RequestParam("file") file: MultipartFile): Result {
        return imageClient.uploadImage(file)
    }

    @GetMapping("/imageTest")
    fun test(name: String): String {
        return imageClient.test(name)
    }
}