package com.comup.personal.site.service;

import com.comup.personal.site.entity.Cron;

import java.util.List;

public interface CronService {
    /**
     * @return 所有的计划任务
     */
    List<Cron> getCorns();
}
