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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/**
 *
 * @author angele
 *//**/
@Entity
@Table(name = "badge")
public class Badge implements Serializable{
    
    //Pour définir l'identifiant de la table.
    @Id
    //Pour laisser à Spring le soin de générer un identifiant unique.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //pour préciser à qui appartient le badge
    @NotNull
    boolean imprime = false;
    
    //Un badge peut appartenir à une et une personne
    @ManyToOne
    private Person person;/*
    
    //date de début de la validité du badge
    @NotNull
    Date startDateOfValidity;
    
    //durée de validité du badge en jour
    @NotNull
    int nbOfValidityDays;*/

    public Badge() {
    }

    public Badge(Long id, Person person) {
        this.id = id;
        this.person = person;
    }
    
    public Badge(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/**/
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

//    public Date getStartDateOfValidity() {
//        return startDateOfValidity;
//    }
//
//    public void setStartDateOfValidity(Date startDateOfValidity) {
//        this.startDateOfValidity = startDateOfValidity;
//    }
//
//    public int getNbOfValidityDays() {
//        return nbOfValidityDays;
//    }
//
//    public void setNbOfValidityDays(int nbOfValidityDays) {
//        this.nbOfValidityDays = nbOfValidityDays;
//    }
    
}
