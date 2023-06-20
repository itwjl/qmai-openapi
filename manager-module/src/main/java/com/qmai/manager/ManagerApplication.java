package com.qmai.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 类描述:
 *
 * @author Wang Jinglei
 * @date 2023/6/7 17:40
 * @modifier Wang Jinglei
 * @date 2023/6/7 17:40
 * @Version V1.0
 */
@SpringBootApplication
public class ManagerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ManagerApplication.class, args);

    }
}
