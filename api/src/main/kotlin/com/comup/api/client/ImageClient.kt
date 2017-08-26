package com.comup.api.client

import com.comup.common.model.Result
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletRequest

@FeignClient("image-service")
interface ImageClient {
    @PostMapping("/image/upload")
    fun uploadImage(request: HttpServletRequest, @RequestParam("file") file: MultipartFile): Result
}