package com.comup.api.client

import com.comup.api._config.MultipartSupportConfiguration
import com.comup.common.model.Result
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile


@FeignClient(name = "file-service", configuration = arrayOf(MultipartSupportConfiguration::class))
interface FileClient {

    @PostMapping(value = "/file/upload")
    fun uploadImage(file: MultipartFile, @RequestParam("parentIdentifier") parentIdentifier: String?): Result
}