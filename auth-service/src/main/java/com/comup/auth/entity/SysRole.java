package com.comup.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class SysRole extends AbstractAuditingEntity {

    private static final long serialVersionUID = -448656858030746621L;

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String value;

    @JsonIgnore
    @ManyToMany(targetEntity = SysAuthority.class, fetch = FetchType.EAGER)
    @BatchSize(size = 20)
    private Set<SysAuthority> authorities = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Set<SysAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<SysAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRole sysRole = (SysRole) o;
        return Objects.equals(id, sysRole.id) &&
                Objects.equals(name, sysRole.name) &&
                Objects.equals(value, sysRole.value) &&
                Objects.equals(authorities, sysRole.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, value, authorities);
    }
}
