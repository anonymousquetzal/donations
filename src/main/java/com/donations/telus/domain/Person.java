/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donations.telus.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *This class will be used to define user
 * 
 * @author Julio Coco
 */
@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    
    private String code;
    
    @NotEmpty(message = "cannot be empty") 
    private String surName;
    
    @NotEmpty(message = "cannot be empty") 
    private String name;
    
    @NotEmpty(message = "cannot be empty") 
    private String userName;
    
    @NotEmpty(message = "cannot be empty") 
    private String password;
    
    @NotEmpty(message = "cannot be empty") 
    @Email
    private String email;
    
    private String idDocument;
    
    @Size(max = 16,min = 15)
    private String creditCard;
    
    //javax.validation.constraints.
    private LocalDateTime createdOn;
    
    private LocalDateTime modifiedOn;
    
    private Long counter;
    
    @PrePersist
    public void executeBeforePersist(){
        this.createdOn = LocalDateTime.now();    
    }
    
    @PreUpdate
    public void executeBeforeUpdate(){
        this.modifiedOn = LocalDateTime.now();    
    }
    
}
