package com.comup.file.service.controller;

import com.comup.common.model.Result;
import com.comup.file.service.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private final FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @CrossOrigin
    @PostMapping("/upload")
    public Result upload(HttpServletRequest request,
                         @RequestParam(name = "file") MultipartFile file,
                         @RequestParam(name = "parentIdentifier", required = false) String parentIdentifier) throws IOException, IllegalAccessException {
        return Result.ok(fileService.saveFile(file, parentIdentifier));
    }

    @CrossOrigin
    @GetMapping("/listFile")
    public Result listFile(HttpServletRequest request,
                           @RequestParam(name = "currentPage") Integer currentPage,
                           @RequestParam(name = "pageSize") Integer pageSize,
                           @RequestParam(name = "types", required = false) List<String> types) {
        return Result.ok(fileService.listFile(currentPage, pageSize, types));
    }

    @CrossOrigin
    @GetMapping("/downLoad")
    public void downLoad(HttpServletRequest request,
                         HttpServletResponse response,
                         Long id) throws IOException, URISyntaxException {
        fileService.flushFile(response, id);
    }
}
