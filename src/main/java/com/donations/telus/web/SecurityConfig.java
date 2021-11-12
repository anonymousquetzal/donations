package com.donations.telus.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class will set up the login page
 *
 * @see WebSecurityConfigurerAdapter will create other users
 *
 * @author Julio Coco
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * This code will set each role for each user * Create user to store in
     * database This is an for authentication
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN", "USER")
                .and()
                .withUser("user")
                .password("{noop}123")
                .roles("USER");
    }

    /**
     * Using this method will restrict certain paths / URLs This is for
     * authorization
     *
     * @see formLogin will be used to choose path for login page
     * @param http will be use methods to restrict paths
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/edit/**", "/save/**", "/delete")
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin().loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errors/403");
    }

}
