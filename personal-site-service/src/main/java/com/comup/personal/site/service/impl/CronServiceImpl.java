package com.comup.personal.site.service.impl;

import com.comup.personal.site.entity.Cron;
import com.comup.personal.site.repository.CronRepository;
import com.comup.personal.site.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CronServiceImpl implements CronService {

    private final CronRepository cronRepository;

    @Autowired
    public CronServiceImpl(CronRepository cronRepository) {
        this.cronRepository = cronRepository;
    }

    @Override
    public List<Cron> getCorns() {
        return (List<Cron>) cronRepository.findAll();
    }
}