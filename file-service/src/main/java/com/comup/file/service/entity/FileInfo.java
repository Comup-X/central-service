package com.comup.file.service.entity;

import com.comup.file.service.entity.pk.FileInfoPK;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class FileInfo {
    @EmbeddedId
    private FileInfoPK fileInfoPK;
    private Date uploadDate;
    private String parentIdentifier;
    private String originalFilename;
    private String fileType;

    public FileInfoPK getFileInfoPK() {
        return fileInfoPK;
    }

    public void setFileInfoPK(FileInfoPK fileInfoPK) {
        this.fileInfoPK = fileInfoPK;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getParentIdentifier() {
        return parentIdentifier;
    }

    public void setParentIdentifier(String parentIdentifier) {
        this.parentIdentifier = parentIdentifier;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
