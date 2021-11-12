/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donations.telus.service;

import com.donations.telus.domain.Person;
import java.util.List;

/**
 *@code This code is an inteface that will use default meathods which will be 
 * used thie the PersonService class which also used IpersonDao
 * @see 
 * @author Leticia Boch
 */
public interface IPersonService {
    
    public List<Person> personList();
    
    public void save(Person person);
    
    public void delete(Person person);
    
    public Person findPerson(Person person);
    
}
