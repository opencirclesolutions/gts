package com.ocs.gts.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

/**
 * Spring Boot application class
 * @author Bas Rutten
 *
 */
@SpringBootApplication
@Import(ApplicationConfig.class)
@Theme(themeClass = Lumo.class)
@CssImport("./styles/shared-styles.css")
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@CssImport("./styles/vaadin-custom-field.html")
@CssImport("./styles/vaadin-menu-bar.html")
@CssImport("./styles/vaadin-dialog.html")
@CssImport("./styles/vaadin-button.html")
public class GtsApplication  implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(GtsApplication.class, args);
    }

}
