package com.comup.personal.site.repository;

import com.comup.personal.site.entity.Nav;
import com.comup.personal.site.entity.pk.NavPK;
import org.springframework.data.repository.CrudRepository;

public interface NavRepository extends CrudRepository<Nav,NavPK>{
}
