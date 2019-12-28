/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
 */
@Entity
@Table
public class MeetingState implements Serializable{
    
    @Id
    //Pour laisser à Spring le soin de générer un identifiant unique.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    //Pour préciser que la taille de la chaine
    @Size(min = 5, max = 10)
    private String label;
    
    /*
       Un état de rdv peut catégoriser plusieurs rdv, c'est une relation bidirectionnelle. 
       Le paramètre (mappedBy = "meetingState") indique que MeetingState est la table esclave. 
       C'est-à-dire que c'est la table rdv/meeting qui contient une clé étrangère "meetingState"
    */
    @OneToMany(mappedBy = "meetingState") 
    private List<Meeting> meetingsList = new ArrayList<>();

    public MeetingState() {
    }

    public MeetingState(String label) {
        this.label = label;
    }

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
    
    
    
}
