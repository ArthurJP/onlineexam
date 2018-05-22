package com.jp.onlineexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.jp.onlineexam")
@EnableJpaRepositories(basePackages = "com.jp.onlineexam.entity")
@EnableTransactionManagement(proxyTargetClass = true)
public class OnlineExamApplication {

    public static void main(String[] args) {
        SpringApplication.run( OnlineExamApplication.class, args );
    }

}
