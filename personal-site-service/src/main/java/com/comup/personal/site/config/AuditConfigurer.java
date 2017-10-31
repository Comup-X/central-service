package com.comup.personal.site.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Random;

@Configuration
@EnableJpaAuditing
public class AuditConfigurer implements AuditorAware<Long> {

    @Override
    public Long getCurrentAuditor() {
        // TODO: 2017/10/19 返回登录用户的ID
        Random random = new Random();
        return random.nextLong();
    }
}