package com.comup.registry

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard

@EnableEurekaServer
@SpringBootApplication
@EnableHystrixDashboard
class RegistryApplication

fun main(args: Array<String>) {
    SpringApplication.run(RegistryApplication::class.java, *args)
}
