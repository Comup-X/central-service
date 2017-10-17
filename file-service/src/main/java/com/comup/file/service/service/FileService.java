package com.comup.file.service.service;

import com.comup.file.service.entity.FileInfo;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface FileService {
    FileInfo saveFile(MultipartFile file, String parentIdentifier) throws IllegalAccessException, IOException;

    Page<FileInfo> listFile(Integer currentPage, Integer pageSize, List<String> fileTypes);

    void flushFile(HttpServletResponse response, Long id) throws IOException, URISyntaxException;
}
