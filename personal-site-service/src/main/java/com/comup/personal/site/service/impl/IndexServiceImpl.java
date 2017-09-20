package com.comup.personal.site.service.impl;

import com.comup.personal.site.entity.Nav;
import com.comup.personal.site.repository.NavRepository;
import com.comup.personal.site.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    private final NavRepository navRepository;

    @Autowired
    public IndexServiceImpl(NavRepository navRepository) {
        this.navRepository = navRepository;
    }

    @Override
    public List<Nav> getNavs() {
        return (List<Nav>) navRepository.findAll();
    }
}
