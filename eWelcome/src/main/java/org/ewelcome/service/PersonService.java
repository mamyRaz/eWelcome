/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service;

import java.util.List;
import java.util.Optional;
import org.ewelcome.entity.Person;

/**
 *
 * @author refin
 * * Couche service, couche intermédiaire
 * On y définit les méthodes dont on a besoin.
 */
public interface PersonService {
    Person save(Person entity);
    void delete(Long id);
    List<Person> findAll();
    Optional<Person> findById(Long id);
    Person findByEmail(String courriel);
    Person getOne(Long id);
    int deleteByEmail(String email);
    void deleteById(Long id);
}
