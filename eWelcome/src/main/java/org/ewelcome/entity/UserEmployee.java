/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author refin
 */
@Entity
@Table(name = "userEmployee")
public class UserEmployee implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) 
   private Long id;
   
   
   //ajouter relation personne
   @NotNull
   @OneToOne(cascade = CascadeType.ALL)
   private Person person;
   
   @NotNull
   private String hashPassword;
   
   @NotNull
   private String SaltHashPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getSaltHashPassword() {
        return SaltHashPassword;
    }

    public void setSaltHashPassword(String SaltHashPassword) {
        this.SaltHashPassword = SaltHashPassword;
    }
   

    public UserEmployee() {
    }

    public UserEmployee(Long idPerson, String hashPassword, String SaltHashPassword) {
        this.hashPassword = hashPassword;
        this.SaltHashPassword = SaltHashPassword;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    
   
}
