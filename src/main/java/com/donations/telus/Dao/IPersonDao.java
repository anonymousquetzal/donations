/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donations.telus.Dao;

import com.donations.telus.domain.Person;
import org.springframework.data.repository.CrudRepository;

/**
 *@code This method uses Spring Boot class administer CRUD, create, read
 * update and delete. 
 * 
 * @param Using the Person class and the personId
 * @see Person
 * 
 *@version 1.0
 *   
 * @author Julio Coco
 */
public interface IPersonDao extends CrudRepository<Person, Long>{
    
    
    
}
