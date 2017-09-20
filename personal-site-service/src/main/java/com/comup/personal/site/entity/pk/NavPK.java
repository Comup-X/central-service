package com.comup.personal.site.entity.pk;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class NavPK implements Serializable {

    private static final long serialVersionUID = -502275912356688412L;

    private String protocol;
    private String hostname;
    private Integer port;

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
}
