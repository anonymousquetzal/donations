
package com.donations.telus.service;

import com.donations.telus.Dao.IPersonDao;
import com.donations.telus.domain.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 
 */
@Service
public class PersonServiceImp implements IPersonService{

    @Autowired
    private IPersonDao iPersonDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Person> personList() {
        return (List<Person>) iPersonDao.findAll();
    }

    @Override
    @Transactional
    public void save(Person person) {
        iPersonDao.save(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        iPersonDao.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findPerson(Person person) {
        return iPersonDao.findById(person.getPersonId()).orElse(null);
    }
    
}
