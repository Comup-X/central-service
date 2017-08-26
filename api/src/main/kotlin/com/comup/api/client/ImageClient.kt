package com.comup.api.client

import com.comup.common.model.Result
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient("image-service")
interface ImageClient {
    @GetMapping("/image/upload")
    fun uploadImage(): String
}