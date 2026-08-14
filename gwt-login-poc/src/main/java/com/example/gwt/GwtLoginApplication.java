package com.example.gwt;

import com.example.gwt.server.LoginServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Main Spring Boot application entry point.
 * Registers the GWT-RPC servlet (LoginServiceImpl) at /app/Login so it lines up
 * with the module rename-to="app" and @RemoteServiceRelativePath("Login") on
 * the client-side LoginService interface.
 */
@SpringBootApplication
public class GwtLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(GwtLoginApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<LoginServiceImpl> loginServiceServletRegistrationBean() {
        LoginServiceImpl loginService = new LoginServiceImpl();
        ServletRegistrationBean<LoginServiceImpl> registrationBean =
                new ServletRegistrationBean<>(loginService, "/app/Login");
        registrationBean.setName("loginService");
        return registrationBean;
    }
}
