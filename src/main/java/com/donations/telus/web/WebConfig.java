/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donations.telus.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * This class to configure web layouts
 *
 * @author Julio Coco
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * This is to make sure index will be visible to users
     * Used to mapp paths that are no used by controller
     * @param register 
     */
    @Override
    public void addViewControllers(ViewControllerRegistry register) {
        register.addViewController("/").setViewName("index");
        register.addViewController("/login");
        register.addViewController("/errors/403").setViewName("/errors/403");
    }
}
