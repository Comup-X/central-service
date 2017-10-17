package com.comup.personal.site.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"protocol", "hostname", "port"}))
public class Nav implements Serializable {

    private static final long serialVersionUID = 4327747000357892004L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String protocol;
    private String hostname;
    private Integer port;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
