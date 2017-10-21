package com.comup.personal.site.service;

import com.comup.personal.site.entity.Nav;

import java.util.List;
import java.util.Map;

public interface IndexService {
    /**
     * @return 所有导航地址
     */
    Map<String,List<Nav>> getNav();
}
