package com.comup.file.service

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class FileServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(FileServiceApplication::class.java, *args)
}

fun String.print() {
    print(this)
}

fun String.println() {
    println(this)
}