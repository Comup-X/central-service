package com.comup.file.service.controller

import com.comup.common.model.Result
import com.comup.file.service.entity.pk.FileInfoPK
import com.comup.file.service.service.FileService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@RestController
@RequestMapping("/file")
class FileController {

    @Autowired
    private lateinit var fileService: FileService

    companion object {
        private var logger = LoggerFactory.getLogger(FileController::class.java)
    }

    @CrossOrigin
    @PostMapping("/upload")
    fun upload(request: HttpServletRequest,
               @RequestParam(name = "file", required = true) file: MultipartFile,
               @RequestParam(name = "parentIdentifier", required = false) parentIdentifier: String?): Result {
        return Result.ok(fileService.saveFile(file, parentIdentifier))
    }

    @CrossOrigin
    @GetMapping("/listFile")
    fun listFile(request: HttpServletRequest,
                 @RequestParam(name = "currentPage", required = true) currentPage: Int,
                 @RequestParam(name = "pageSize", required = true) pageSize: Int,
                 @RequestParam(name = "types", required = false) types: List<String>?): Result {
        return Result.ok(fileService.listFile(currentPage, pageSize, types))
    }

    @GetMapping("/downLoad")
    fun downLoad(request: HttpServletRequest,
                 response: HttpServletResponse,
                 @ModelAttribute("fileInfoPK") fileInfoPK: FileInfoPK) {
        fileService.flushFile(response, fileInfoPK)
    }
}