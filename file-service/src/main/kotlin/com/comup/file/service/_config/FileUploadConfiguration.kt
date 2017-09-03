package com.comup.file.service._config

import org.springframework.boot.web.servlet.MultipartConfigFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.servlet.MultipartConfigElement


@Configuration
class FileUploadConfiguration {

    @Bean
    fun multipartConfigElement(): MultipartConfigElement {
        val factory = MultipartConfigFactory()
        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
        // 这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize("64MB") // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("128MB")
        // Sets the directory location where files will be stored.
        //factory.setLocation("/root/image/upload")
        return factory.createMultipartConfig()
    }
}