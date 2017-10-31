package com.comup.personal.site.controller;

import com.comup.common.model.Result;
import com.comup.personal.site.entity.Nav;
import com.comup.personal.site.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nav")
public class NavController {

    private final IndexService indexService;

    @Autowired
    public NavController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("")
    public Result getNav() {
        return Result.ok(indexService.getNav());
    }

}