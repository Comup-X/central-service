package com.comup.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class SysUser extends AbstractAuditingEntity {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String username;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(length = 60)
    private String password;

    @Size(max = 50)
    @Column(length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(length = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 100)
    @Column(length = 100, unique = true)
    private String email;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;

    @JsonIgnore
    @ManyToMany(targetEntity = SysRole.class, fetch = FetchType.EAGER)
    @BatchSize(size = 20)
    private Set<SysRole> roles = new HashSet<>();

    @Transient
    private Set<GrantedAuthority> authorities = new HashSet<>();


    public Set<GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> userAuthotities = new HashSet<>();
        for (SysRole role : this.roles) {
            for (SysAuthority authority : role.getAuthorities()) {
                userAuthotities.add(new SimpleGrantedAuthority(authority.getValue()));
            }
        }

        return userAuthotities;
    }

    public SysUser() {
    }

    public SysUser(String username, String password, String firstName, String lastName, String email, String imageUrl, Set<SysRole> roles, Set<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.imageUrl = imageUrl;
        this.roles = roles;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SysRole> roles) {
        this.roles = roles;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(id, sysUser.id) &&
                Objects.equals(username, sysUser.username) &&
                Objects.equals(password, sysUser.password) &&
                Objects.equals(firstName, sysUser.firstName) &&
                Objects.equals(lastName, sysUser.lastName) &&
                Objects.equals(email, sysUser.email) &&
                Objects.equals(imageUrl, sysUser.imageUrl) &&
                Objects.equals(roles, sysUser.roles) &&
                Objects.equals(authorities, sysUser.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, email, imageUrl, roles, authorities);
    }
}
