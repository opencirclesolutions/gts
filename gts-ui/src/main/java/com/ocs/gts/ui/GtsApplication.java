package com.ocs.gts.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Spring boot application class
 * @author Bas Rutten
 *
 */
@SpringBootApplication
@Import(ApplicationConfig.class)
public class GtsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GtsApplication.class, args);
    }

}
