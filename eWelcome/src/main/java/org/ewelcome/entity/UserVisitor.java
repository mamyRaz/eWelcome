/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 *
 * @author refin
 * Abstraction de l'objet UserVisitor de la bd comme objet métier
 * @Entity pour indiquer que c'est une entité JPA qui sera traduit en table
 */
@Entity
@Table(name = "userVisitor")
public class UserVisitor implements Serializable {
   //Pour définir l'identifiant de la table.
   @Id
   //Pour laisser à Spring le soin de générer un identifiant unique.
   @GeneratedValue(strategy = GenerationType.AUTO) 
   private Long idVisitor;
   
   //pour préciser que ce champ ne doit pas rester nul
   @NotNull
   //Un identifiant visiteur appartient à une et une seule personne @ManyToOne
   @ManyToOne
   private Person person;
   
   @NotNull
   private int nbDaysAvailable;
   
   @NotNull
   private int theOTP;
   
   @NotNull
   private Date initialDate;
   
     
    //Un visiteur peut avoir plusieurs codes wifi @OneToMany
    @OneToMany(mappedBy = "visitorAuthorized") 
    private List<WifiCode> listOfWifiCodesUsed;
    

    public UserVisitor(Person person, int nbDaysAvailable, int code, Date initialDate) {
        this.person = person;
        this.nbDaysAvailable = nbDaysAvailable;
        this.theOTP = code;
        this.initialDate = initialDate;
    }
    
    /*
        Un identifiant visiteur est une entité donc un bean. Un bean doit 
        posséder un contructeur par défaut, afin que Spring puisse l'instancier
    */

    public UserVisitor() {
    }

    //setters et getters
    
    public Long getIdVisitor() {
        return idVisitor;
    }

    public void setIdVisitor(Long idVisitor) {
        this.idVisitor = idVisitor;
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

    public List<WifiCode> getListOfWifiCodesUsed() {
        return listOfWifiCodesUsed;
    }

    public void setListOfWifiCodesUsed(List<WifiCode> listOfWifiCodesUsed) {
        this.listOfWifiCodesUsed = listOfWifiCodesUsed;
    }
    
    
}
