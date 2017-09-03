package com.comup.file.service.service

import com.comup.file.service.entity.FileInfo
import com.comup.file.service.entity.pk.FileInfoPK
import org.springframework.data.domain.Page
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletResponse

interface FileService {
    fun saveFile(file: MultipartFile, parentIdentifier: String?): FileInfo

    fun listFile(currentPage: Int, pageSize: Int, fileTypes: List<String>?): Page<FileInfo>

    fun flushFile(response: HttpServletResponse, fileInfoPK: FileInfoPK)
}