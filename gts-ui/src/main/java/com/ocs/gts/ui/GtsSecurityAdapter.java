package com.ocs.gts.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;

/**
 * Security adapter
 * 
 * @author Bas Rutten
 *
 */
@EnableWebSecurity
@EnableOAuth2Sso
@Configuration
public class GtsSecurityAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyBasicAuthenticationEntryPoint entryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //
                .authorizeRequests() //
                .requestMatchers(SecurityUtils::isFrameworkInternalRequest).permitAll() //
                .anyRequest().authenticated() //
                .and(). //
                logout().logoutUrl("/logout").invalidateHttpSession(true).clearAuthentication(true).deleteCookies("JSESSIONID");

    }

    /**
     * Overwritten to remove the default "ROLE_" prefix
     * 
     * @return
     */
    @Bean
    GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/VAADIN/**", "/favicon.ico", "/robots.txt", "/manifest.webmanifest", "/sw.js", "/offline-page.html",
                "/frontend/**", "/webjars/**", "/frontend-es5/**", "/frontend-es6/**");
    }

}
