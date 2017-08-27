package com.comup.image.service.controller

import com.comup.common.model.Result
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Paths
import java.util.*
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/image")
class ImageController {

    @Value("\${image.upload.location}")
    private lateinit var uploadLocation: String

    companion object {
        private var logger = LoggerFactory.getLogger(ImageController::class.java)
    }

    @PostMapping("/upload")
    fun upload( @RequestParam("file") file: MultipartFile): Result {
        if (!file.isEmpty) {
            val split = file.originalFilename.split(".")
            val fileName = UUID.randomUUID().toString() + "." + split[split.lastIndex]
            val willSaveFile = File(Paths.get(uploadLocation, fileName).toUri())
            if (!willSaveFile.exists()) {
                willSaveFile.createNewFile()
            }
            val out = BufferedOutputStream(FileOutputStream(willSaveFile))
            out.write(file.bytes)
            out.flush()
            out.close()
            return Result.ok(fileName)
        }
        return Result.error("File is empty")
    }

    @GetMapping("/test")
    fun test(name:String):String{
        return  "hello $name"
    }
}