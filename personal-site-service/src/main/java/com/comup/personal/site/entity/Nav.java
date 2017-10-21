package com.comup.personal.site.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"protocol", "hostname", "port"}))
public class Nav extends BaseEntity {

    private static final long serialVersionUID = 4327747000357892004L;

    /**
     * 协议：https，http等
     */
    @Column(nullable = false)
    private String protocol;
    /**
     * 网址或IP
     */
    @Column(nullable = false)
    private String hostname;
    /**
     * 端口
     */
    private Integer port;
    /**
     * 导航菜单名字
     */
    @Column(nullable = false)
    private String name;

    /**
     * 此连接所属组
     */
    @Column(name = "`group`",nullable = false)
    private String group;
}