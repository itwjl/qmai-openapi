package com.qmai.openapi;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 类描述: 开放平台接口启动类
 *
 * @author Wang Jinglei
 * @date 2023/6/7 11:04
 * @modifier Wang Jinglei
 * @date 2023/6/7 11:04
 * @Version V1.0
 */
@Slf4j
@SpringBootApplication
public class OpenapiApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(OpenapiApplication.class, args);
        String ip = InetAddress.getLocalHost().getHostAddress();
        Environment env = application.getEnvironment();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");

        log.info("\n ----------------------------------------------\n\t" +
                "Application Jeecg-Boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "------------------------------------------------");
    }

}
