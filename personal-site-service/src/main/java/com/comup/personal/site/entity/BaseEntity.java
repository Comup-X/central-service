package com.comup.personal.site.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
class BaseEntity implements Serializable {
    private static final long serialVersionUID = -1302574161371981419L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedBy
    @JsonIgnore
    @Column(nullable = false, updatable = false)
    private Long createdBy;

    @JsonIgnore
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdDate = new Date();

    @JsonIgnore
    @LastModifiedBy
    private Long lastModifiedBy;

    @JsonIgnore
    @LastModifiedDate
    private Date lastModifiedDate = new Date();
}
