package com.comup.image.service.controller

import com.comup.common.model.Result
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/image")
class ImageController {
    companion object {
        private var logger = LoggerFactory.getLogger(ImageController::class.java)
    }

    @GetMapping("/upload")
    fun upload(): String {
        return "hello world"
    }
}