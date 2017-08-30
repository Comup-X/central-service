package com.comup.image.service

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class ImageServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(ImageServiceApplication::class.java, *args)
}

fun String.print() {
    print(this)
}

fun String.println() {
    println(this)
}