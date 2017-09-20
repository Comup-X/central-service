package com.comup.personal.site.controller;

import com.comup.common.model.Result;
import com.comup.personal.site.entity.Nav;
import com.comup.personal.site.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {

    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @CrossOrigin
    @GetMapping("/nav")
    public Result<List<Nav>> getNav() {
        return Result.ok(indexService.getNavs());
    }
}