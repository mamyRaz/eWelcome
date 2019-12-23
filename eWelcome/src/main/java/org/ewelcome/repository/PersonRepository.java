/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.repository;

import org.ewelcome.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author refin
 */
public interface PersonRepository extends JpaRepository<Person, Long>{
    Person findByLastNameAndFirstName(String lastName, String firstName);
    Person findByEmail(String email);

    
}
