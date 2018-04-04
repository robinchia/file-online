package com.venustech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.util.Properties;

@SpringBootApplication
@EnableScheduling
@ComponentScan(value = "com.venustech.*")
public class FilePreviewApplication {
    static Logger logger= LoggerFactory.getLogger(FilePreviewApplication.class);
	public static void main(String[] args) {
        Properties properties = System.getProperties();
        logger.info(properties.get("user.dir").toString());
        SpringApplication.run(FilePreviewApplication.class, args);
	}
}
