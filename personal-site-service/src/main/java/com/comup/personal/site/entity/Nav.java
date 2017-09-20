package com.comup.personal.site.entity;

import com.comup.personal.site.entity.pk.NavPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Nav {
    @EmbeddedId
    private NavPK navPK;

    private String name;

    public NavPK getNavPK() {
        return navPK;
    }

    public void setNavPK(NavPK navPK) {
        this.navPK = navPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
