package com.ocs.gts.ui;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
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
 *
 * @author Bas Rutten
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.ocs.gts" })
@EntityScan(basePackages = { "com.ocs.gts.domain", "com.ocs.dynamo.functional.domain",
		"om.ocs.dynamo.envers.listener" })
@Theme(value = "my-theme", variant = Lumo.LIGHT)
@Viewport("width=device-width, minimum-scale=1.0, initial-scale=1.0, user-scalable=yes")
@PreserveOnRefresh
@Import(ApplicationConfig.class)
public class GtsApplication extends SpringBootServletInitializer implements AppShellConfigurator {

	private static final long serialVersionUID = -2461957363779869974L;

	public static void main(String[] args) {
		SpringApplication.run(GtsApplication.class, args);
	}

}
