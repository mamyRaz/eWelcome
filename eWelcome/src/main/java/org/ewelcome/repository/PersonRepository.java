/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.repository;

import org.ewelcome.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author refin
 * L'interface JpaRepository possède déjà un certain nombres de méthodes pour faire des requêtes dans la table, 
    comme par exemple findAll(), deleteById(ID id), save(S entity)
 */
public interface PersonRepository extends JpaRepository<Person, Long>{
    Person findByLastNameAndFirstName(String lastName, String firstName);
    Person findByEmail(String email);
    int deleteByEmail(String email);
    
    /*@Modifying
    @Query("UPDATE person p SET p.address = :address WHERE p.id = :id")
    int updatePerson(@Param("id") int companyId, @Param("address") String address);*/
    
}
