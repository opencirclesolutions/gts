package com.ocs.gts.ui;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Spring Boot application class
 * @author Bas Rutten
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.ocs.gts"})
@ComponentScan(basePackages = { "com.ocs.gts" })
@EntityScan(basePackages = { "com.ocs.gts.domain", "com.ocs.dynamo.functional.domain" })
@Theme(themeClass = Lumo.class)
@CssImport("./styles/shared-styles.css")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@CssImport("./styles/vaadin-custom-field.html")
@CssImport("./styles/vaadin-menu-bar.html")
@CssImport("./styles/vaadin-dialog.html")
@CssImport("./styles/vaadin-button.html")
@PreserveOnRefresh
@Import(ApplicationConfig.class)
public class GtsApplication extends SpringBootServletInitializer implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(GtsApplication.class, args);
    }

}
