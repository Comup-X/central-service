package com.comup.image.service.controller

import com.comup.common.model.Result
import com.comup.image.service.service.FileService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@RequestMapping("/image")
class ImageController {

    @Autowired
    private lateinit var fileService: FileService

    companion object {
        private var logger = LoggerFactory.getLogger(ImageController::class.java)
    }

    @PostMapping("/upload")
    fun upload(@RequestParam("file") file: MultipartFile): Result {
        return fileService.saveFile(file).
    }

    @GetMapping("/test")
    fun test(name: String): String {
        return "hello $name"
    }
}