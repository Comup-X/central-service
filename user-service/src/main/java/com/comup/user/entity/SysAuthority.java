package com.comup.user.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Comup
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public  class SysAuthority extends BaseEntity{
    private static final long serialVersionUID = -5065484582296143459L;
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String value;
}