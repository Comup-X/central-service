package com.comup.file.service.service.impl;

import com.comup.file.service.entity.FileInfo;
import com.comup.file.service.repository.FileInfoRepository;
import com.comup.file.service.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.Predicate;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;

@Service
public class FileServiceImpl implements FileService {

    @Value("${image.upload.location}")
    private String uploadLocation;

    private final FileInfoRepository fileInfoRepository;

    @Autowired
    public FileServiceImpl(FileInfoRepository fileInfoRepository) {
        this.fileInfoRepository = fileInfoRepository;
    }

    @Override
    public FileInfo saveFile(MultipartFile file, String parentIdentifier) throws IllegalAccessException, IOException {
        return saveFileInfoToDB(saveToFileSystem(file), parentIdentifier);
    }

    @Override
    public Page<FileInfo> listFile(Integer currentPage, Integer pageSize, List<String> fileTypes) {
        PageRequest pageRequest = new PageRequest(currentPage, pageSize, Sort.Direction.DESC, "uploadDate");

        Specification<FileInfo> specification = (root, query, cb) -> {
            if (fileTypes != null && !fileTypes.isEmpty()) {
                List<Predicate> predicates = new ArrayList<>();
                for (String fileType : fileTypes) {
                    predicates.add(cb.like(root.get("fileType"), fileType + "%"));
                }
                query.where(cb.or(predicates.toArray(new Predicate[]{})));
            }
            return null;
        };
        return fileInfoRepository.findAll(specification, pageRequest);
    }

    @Override
    public void flushFile(HttpServletResponse response, Long id) throws IOException, URISyntaxException {
        FileInfo fileInfo = fileInfoRepository.findOne(id);
        if (fileInfo == null) {
            throw new FileNotFoundException();
        }
        //为了解决中文名称乱码问题
        String filename = new String(fileInfo.getOriginalFilename().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        response.setContentType("application/octet-stream; charset=utf-8");
        File file;
        if (Objects.equals(fileInfo.getScheme(), "file")) {
            file = new File(Paths.get(fileInfo.getPath(), fileInfo.getFileName()).toUri());
        } else {
            URI uri = new URI(fileInfo.getScheme(), null, fileInfo.getHost(), fileInfo.getPort(), fileInfo.getPath(), null, null);
            file = new File(uri);
        }
        InputStream inputStream = new FileInputStream(file);
        int b = inputStream.read();
        while (b != -1) {
            response.getOutputStream().write(b);
            b = inputStream.read();
        }
        inputStream.close();
    }

    private FileInfo saveToFileSystem(MultipartFile file) throws IllegalAccessException, IOException {
        if (!file.isEmpty()) {
            File path = Paths.get(uploadLocation).toFile();
            boolean mkSuccess = path.exists() || path.mkdirs();
            if (!mkSuccess) {
                throw new IllegalAccessException("Create file directory error");
            }

            String[] split = file.getOriginalFilename().split("\\.");
            FileInfo fileInfo = new FileInfo();
            fileInfo.setOriginalFilename(file.getOriginalFilename());
            fileInfo.setFileType(file.getContentType());
            fileInfo.setScheme("file");
            fileInfo.setHost("");
            fileInfo.setPort(0);
            fileInfo.setPath(uploadLocation);
            fileInfo.setFileName(UUID.randomUUID().toString() + "." + split[split.length - 1 < 0 ? 0 : split.length - 1]);

            File willSaveFile = Paths.get(uploadLocation, fileInfo.getFileName()).toFile();
            mkSuccess = willSaveFile.exists() || willSaveFile.createNewFile();
            if (!mkSuccess) throw new IllegalAccessException("文件创建失败");

            OutputStream outputStream = new FileOutputStream(willSaveFile);
            BufferedOutputStream out = new BufferedOutputStream(outputStream);
            out.write(file.getBytes());
            out.flush();
            out.close();
            outputStream.close();
            return fileInfo;
        } else {
            throw new IllegalArgumentException("文件不能为空");
        }
    }

    private FileInfo saveFileInfoToDB(FileInfo fileInfo, String parentIdentifier) {
        fileInfo.setUploadDate(new Date());
        fileInfo.setParentIdentifier(parentIdentifier);
        fileInfoRepository.save(fileInfo);
        return fileInfo;
    }
}
