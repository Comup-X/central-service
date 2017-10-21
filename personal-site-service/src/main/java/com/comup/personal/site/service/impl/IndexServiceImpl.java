package com.comup.personal.site.service.impl;

import com.comup.personal.site.entity.Nav;
import com.comup.personal.site.repository.NavRepository;
import com.comup.personal.site.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IndexServiceImpl implements IndexService {

    private final NavRepository navRepository;

    @Autowired
    public IndexServiceImpl(NavRepository navRepository) {
        this.navRepository = navRepository;
    }

    @Override
    public Map<String, List<Nav>> getNav() {
        List<Nav> navs = new ArrayList<>();
        navRepository.findAll().forEach(navs::add);
        return navs.stream().collect(Collectors.groupingBy(nav -> nav.getGroup().trim()));
    }
}