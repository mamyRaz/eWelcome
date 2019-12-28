/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author refin
 * Abstraction de l'objet TypeMeeting de la bd comme objet métier
 */
@Entity
@Table(name = "typeMeeting")
public class TypeMeeting implements Serializable {
    //Pour définir l'identifiant de la table.
    @Id
    //Pour laisser à Spring le soin de générer un identifiant unique.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //pour préciser que ce champ ne doit pas rester nul
    @NotNull
    //Pour préciser que la taille de la chaine
    @Size(min = 5, max = 10)
    private String label;
    
    /*
       Un type rdv peut catégoriser plusieurs rdv, c'est une relation bidirectionnelle. 
       Le paramètre (mappedBy = "typeMeeting") indique que type rdv est la table esclave. 
       C'est-à-dire que c'est la table rdv/meeting qui contient une clé étrangère "typeMeeting"
    */
    @OneToMany(mappedBy = "typeMeeting") 
    private List<Meeting> meetingsList;
    
    
    public TypeMeeting(String label) {
        this.label = label;
    }
    
    /*
        Un type rdv est une entité donc un bean. Un bean doit 
        posséder un contructeur par défaut, afin que Spring puisse l'instancier
    */

    public TypeMeeting(){
        
    }
    
    //setters et getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Meeting> getMeetingsList() {
        return meetingsList;
    }

    public void setMeetingsList(List<Meeting> meetingsList) {
        this.meetingsList = meetingsList;
    }
    
    @Override
    public String toString() {
        return label;
    }
}
