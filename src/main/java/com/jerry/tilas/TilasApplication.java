package com.jerry.tilas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ServletComponentScan
@SpringBootApplication
public class TilasApplication {

    public static void main(String[] args) {
        SpringApplication.run(TilasApplication.class, args);
    }

}
