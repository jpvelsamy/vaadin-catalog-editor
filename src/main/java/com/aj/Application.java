package com.aj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.aj.reusuables.LeadDataService;
import com.aj.security.SecurityConfig;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */

@PWA(name = "Project Base for Vaadin with Spring", shortName = "Project Base")
@SpringBootApplication(scanBasePackageClasses = { LeadDataService.class, SecurityConfig.class, GreetService.class})

public class Application extends SpringBootServletInitializer implements AppShellConfigurator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3023573200826555096L;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
