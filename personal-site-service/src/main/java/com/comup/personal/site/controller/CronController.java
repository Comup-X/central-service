package com.comup.personal.site.controller;

import com.comup.common.model.Result;
import com.comup.personal.site.entity.Cron;
import com.comup.personal.site.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CronController {

    private final CronService cronService;

    @Autowired
    public CronController(CronService cronService) {
        this.cronService = cronService;
    }

    @GetMapping("/cron")
    public Result<List<Cron>> getAllCron() {
        return Result.ok(cronService.getCorns());
    }

}