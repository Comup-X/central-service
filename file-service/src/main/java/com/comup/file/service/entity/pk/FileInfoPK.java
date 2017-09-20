package com.comup.file.service.entity.pk;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FileInfoPK implements Serializable {
    private static final long serialVersionUID = -8246906426037035118L;

    private String scheme;
    private String host;
    private Integer port;
    private String path;
    private String fileName;

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
