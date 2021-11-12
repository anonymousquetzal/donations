/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donations.telus;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Used to encrypt password
 * @author 
 */
public class EncrytPassword {
    
    public static void main(String[] args) {
        var password = "123";
        System.out.println("password; " + password);
        System.out.println("password " );
    }
    
    public static String ecriptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
     return encoder.encode(password);
    }
    
}
