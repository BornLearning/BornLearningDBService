package com.cmpe272.gr15.mysql;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.cmpe272.gr15.mysql"})
@EnableJpaRepositories("com.cmpe272.gr15.mysql.repository")
@EnableAsync
public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class);

    public static void main(String args[]) {

        LOGGER.info("Hello World!");
        SpringApplication.run(Application.class, args);
    }

}