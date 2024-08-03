package org.zender.comic.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "org.zender")
public class ComicServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ComicServiceApplication.class, args);
    }
}
