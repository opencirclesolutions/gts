package com.ocs.gts.ui;

import jakarta.servlet.annotation.WebServlet;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Spring boot web application initializer
 * @author Bas Rutten
 *
 */
@WebServlet(loadOnStartup = 10)
public class GtsApplicationInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GtsApplication.class);
    }
}
