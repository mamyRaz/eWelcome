/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 *
 * @author refin
 * Abstraction de l'objet Meeting de la bd comme objet métier 
 */
@Entity
@Table(name = "meeting")
public class Meeting implements Serializable{
   
    //Pour définir l'identifiant de la table.
    @Id
    //Pour laisser à Spring le soin de générer un identifiant unique.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //pour préciser que ce champ ne doit pas rester nul
    @NotNull
    //Un rdv appartient à une et une seule type rdv @ManyToOne
    @ManyToOne 
    private TypeMeeting typeMeeting;
    
    @NotNull
    private Date dateMeeting;
    
    @NotNull
    private String reason;
    
    //@NotNull
    //Plusieurs rdv ont à une ou plusieurs personnes et vice versa @ManyToMany
    @ManyToMany(mappedBy = "meetingList")
    private Set<Person> peopleList = new HashSet<>();

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Meeting(TypeMeeting typeMeeting, Date dateMeeting, String reason, List<Person> peopleList) {
        this.typeMeeting = typeMeeting;
        this.dateMeeting = dateMeeting;
        this.reason = reason;
        this.peopleList = (Set<Person>) peopleList;
    }
    
    /*
        Un rdv est une entité donc un bean. Un bean doit 
        posséder un contructeur par défaut, afin que Spring puisse l'instancier
    */

    
    public Meeting(){
        
    }
    
    //setters et getters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeMeeting getTypeMeeting() {
        return typeMeeting;
    }

    public void setTypeMeeting(TypeMeeting typeMeeting) {
        this.typeMeeting = typeMeeting;
    }

    public Date getDateMeeting() {
        return dateMeeting;
    }

    public void setDateMeeting(Date dateMeeting) {
        this.dateMeeting = dateMeeting;
    }

    public List<Person> getPeopleList() {
        return (List<Person>) peopleList;
    }

    public void setPeopleList(List<Person> peopleList) {
        this.peopleList = (Set<Person>) peopleList;
    }
    
}
