package com.comup.auth;

import com.comup.auth._base.SecurityUtils;
import com.comup.auth.repository.support.WiselyRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(repositoryBaseClass = WiselyRepositoryImpl.class)
public class AuthServiceApplication {

    @Bean(name = "auditorAware")
    public AuditorAware<String> auditorAware() {
        return SecurityUtils::getCurrentUserUsername;
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}