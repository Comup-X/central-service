package com.comup.api.controller

import com.comup.api.client.ImageClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ImageController {

    @Autowired
    private lateinit var imageClient:ImageClient

    @GetMapping("/uploadImage")
    fun uploadImage():String{
        return imageClient.uploadImage()
    }
}