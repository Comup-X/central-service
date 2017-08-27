package com.comup.api._config

import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.GsonHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.context.annotation.Bean


//@Configuration
class WebConfiguration : WebMvcConfigurerAdapter() {

    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>>?) {
        converters!!.removeIf { httpMessageConverter -> httpMessageConverter is MappingJackson2HttpMessageConverter } // 删除MappingJackson2HttpMessageConverter
        converters.add(GsonHttpMessageConverter()) // 添加GsonHttpMessageConverter
    }

    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
    }
}