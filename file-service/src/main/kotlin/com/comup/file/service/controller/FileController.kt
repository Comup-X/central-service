package com.comup.file.service.controller

import com.comup.common.model.Result
import com.comup.file.service.service.FileService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletRequest


@RestController
@RequestMapping("/file")
class FileController {

    @Autowired
    private lateinit var fileService: FileService

    companion object {
        private var logger = LoggerFactory.getLogger(FileController::class.java)
    }

    @PostMapping("/upload")
    fun upload(request: HttpServletRequest,
               @RequestParam(name = "file", required = true) file: MultipartFile,
               @RequestParam(name = "parentIdentifier", required = false) parentIdentifier: String?): Result {
        logger.info(parentIdentifier)
        logger.info(request.getHeader("content-type"))
        return Result.ok(fileService.saveFile(file, parentIdentifier))
    }
}