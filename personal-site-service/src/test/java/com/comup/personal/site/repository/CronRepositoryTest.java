package com.comup.personal.site.repository;

import com.comup.personal.site.entity.Cron;
import com.comup.personal.site.entity.property.Repeat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CronRepositoryTest {
    @Autowired
    private CronRepository cronRepository;

    @Test
    @Rollback
    @Transactional
    public void insertTest() {
        Cron cron = new Cron();
        cron.setContent("备注");
        cron.setRepeat(Repeat.EVERY_DAY);
        cron.setStartTime(new Date());
        cron.setTitle("标题");
        cronRepository.save(cron);
    }

    @Test
    @Rollback
    @Transactional
    public void updateTest() {
        Cron cron = new Cron();
        cron.setContent("备注");
        cron.setRepeat(Repeat.EVERY_DAY);
        cron.setStartTime(new Date());
        cron.setTitle("标题");
        cronRepository.save(cron);
        Cron one = ((List<Cron>)cronRepository.findAll()).get(0);
        one.setTitle("标题1");
        cronRepository.save(one);
    }

    @Test
    @Rollback
    @Transactional
    public void findTest() {
        System.out.println(cronRepository.findOne(1L));
    }
}