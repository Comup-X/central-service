package com.comup.file.service

import com.comup.file.service.service.FileService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class FileServiceApplicationTests {

    @Autowired
    private lateinit var fileService: FileService

    @Test
    fun contextLoads() {
    }

    @Test
    fun listFileTest() {
        fileService.listFile(1, 1, listOf("jepg"))
    }
}
