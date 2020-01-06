/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author refin
 * Abstraction de l'objet UserEmployee de la bd comme objet métier
 */
@Entity
@Table(name = "userEmployee")
public class UserEmployee implements Serializable{
   
   //Pour définir l'identifiant de la table.
   @Id
   //Pour laisser à Spring le soin de générer un identifiant unique.
   @GeneratedValue(strategy = GenerationType.AUTO) 
   private Long idEmployee;
   
   
   //pour préciser que ce champ ne doit pas rester nul
   @NotNull
   //Un seul indentifiant employee peut appartenir à une et une personne et vice versa
   @OneToOne(cascade = CascadeType.ALL)
   private Person person;
   
   @NotNull
   private String hashPassword="mot de passe";
   
   //@NotNull
   private String SaltHashPassword;
   
   // one employee est responsable de un ou de plusieurs rdv
   @OneToMany(mappedBy = "meetingHost") 
    private List<Meeting> listOfMeetingsAsResponsable;
   /*
        Un identifiant employee est une entité donc un bean. Un bean doit 
        posséder un contructeur par défaut, afin que Spring puisse l'instancier
    */

    public UserEmployee() {
    }

    public UserEmployee(Long idPerson, String hashPassword, String SaltHashPassword) {
        this.hashPassword = hashPassword;
        this.SaltHashPassword = SaltHashPassword;
    }
    
   
   //setters et getters
    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
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
   
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Meeting> getListOfMeetingsAsResponsable() {
        return listOfMeetingsAsResponsable;
    }

    public void setListOfMeetingsAsResponsable(List<Meeting> listOfMeetingsAsResponsable) {
        this.listOfMeetingsAsResponsable = listOfMeetingsAsResponsable;
    }

    
   
}
