/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 *
 * @author refin
 */
@Entity
@Table(name = "userVisitor")
public class UserVisitor implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO) 
   private Long id;
   //ajouter relation personne

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
  
   @NotNull
   @ManyToOne
   private Person person;
   
   @NotNull
   private int nbDaysAvailable;
   
   @NotNull
   private int theOTP;
   
   @NotNull
   private Date initialDate;
    

    public UserVisitor(Person person, int nbDaysAvailable, int code, Date initialDate) {
        this.person = person;
        this.nbDaysAvailable = nbDaysAvailable;
        this.theOTP = code;
        this.initialDate = initialDate;
    }

    public UserVisitor() {
    }

    public int getNbDaysAvailable() {
        return nbDaysAvailable;
    }

    public void setNbDaysAvailable(int nbDaysAvailable) {
        this.nbDaysAvailable = nbDaysAvailable;
    }

    public int getTheOTP() {
        return theOTP;
    }

    public void setTheOTP(int theOTP) {
        this.theOTP = theOTP;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    
}
