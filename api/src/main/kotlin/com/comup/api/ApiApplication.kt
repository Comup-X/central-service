package com.comup.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.feign.EnableFeignClients

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
class ApiApplication

fun main(args: Array<String>) {
    SpringApplication.run(ApiApplication::class.java, *args)
}