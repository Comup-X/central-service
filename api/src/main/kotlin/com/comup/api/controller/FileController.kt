package com.comup.api.controller

import com.comup.api.client.FileClient
import com.comup.common.model.Result
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletRequest

@RestController
class FileController {

    companion object {
        private val logger = LoggerFactory.getLogger(FileController::class.java)
    }

    @Autowired
    private lateinit var fileClient: FileClient

    @CrossOrigin("*")
    @PostMapping(value = "/fileUpload")
    fun uploadImage(
            request: HttpServletRequest,
            @RequestParam(required = true) file: MultipartFile, @RequestParam(required = false) parentIdentifier: String?): Result {
        logger.info(parentIdentifier)
        logger.info(request.getHeader("content-type"))
        //val uploadImage = fileClient.uploadImage(file)
        val uploadImage = fileClient.uploadImage(file,parentIdentifier)
        return uploadImage
    }
}