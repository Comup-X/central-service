package com.comup.api._config

import feign.codec.Encoder
import feign.form.spring.SpringFormEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Scope


/**
 * 提供Feign文件上传支持
 */
@Configuration
class MultipartSupportConfiguration {
    @Bean
    @Primary
    @Scope("prototype")
    fun feignFormEncoder(): Encoder {
        return SpringFormEncoder()
    }
}