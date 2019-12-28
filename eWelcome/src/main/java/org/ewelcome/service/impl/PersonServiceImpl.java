/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service.impl;

import java.util.List;
import java.util.Optional;
import org.ewelcome.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.ewelcome.repository.PersonRepository;
import org.ewelcome.service.PersonService;

/**
 *
 * @author refin
 */
@Component
//@Service est une annotation qui spécialise @Component. Elle indique une classe métier.
@Service
public class PersonServiceImpl implements PersonService{
    //@Autowired permet d'injecter automatiquement la bonne dépendance.
    @Autowired
    PersonRepository personneRepository;

    @Override
    public Person save(Person entity) {
        //tester si le format d'email es ok ou pas
        return personneRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        personneRepository.deleteById(id);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personneRepository.findAll();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personneRepository.findById(id);
    }

    @Override
    public Person findByEmail(String courriel) {
        return personneRepository.findByEmail(courriel);
    }

    @Override
    public Person getOne(Long id) {
        return personneRepository.getOne(id);
    }

    @Override
    public int deleteByEmail(String email) {
        return personneRepository.deleteByEmail(email);
    }

    @Override
    public void deleteById(Long id) {
        personneRepository.deleteById(id);
    }
    
}
