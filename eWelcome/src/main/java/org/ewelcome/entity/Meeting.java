/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
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
    private Long idMeeting;
    
    @NotNull
    @ManyToOne 
    private UserEmployee meetingHost;
    @NotNull
    private String hour;
    //pour préciser que ce champ ne doit pas rester nul
    @NotNull
    //Un rdv appartient à une et une seule type rdv @ManyToOne
    @ManyToOne 
    private TypeMeeting typeMeeting;
    
    @ManyToOne 
    private MeetingState meetingState;
    
    @NotNull
    private Date dateMeeting;
    
    @NotNull
    private String comments;
    
     
    
    //Plusieurs rdv ont à une ou plusieurs personnes et vice versa @ManyToMany
    @ManyToMany(mappedBy = "meetingList")
    private List<Person> guestList = new ArrayList<>();

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Meeting(UserEmployee meetingHost, TypeMeeting typeMeeting, Date dateMeeting, String hour, String comments) {
        this.meetingHost = meetingHost;
        this.typeMeeting = typeMeeting;
        this.dateMeeting = dateMeeting;
        this.hour = hour;
        this.comments = comments;
        
    }

   
    
    /*
        Un rdv est une entité donc un bean. Un bean doit 
        posséder un contructeur par défaut, afin que Spring puisse l'instancier
    */

    
    public Meeting(){
        
    }
    
    //setters et getters

    public Long getIdMeeting() {
        return idMeeting;
    }

    public void setIdMeeting(Long idMeeting) {
        this.idMeeting = idMeeting;
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

    public List<Person> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Person> guestList) {
        this.guestList = guestList;
    }

    public UserEmployee getMeetingHost() {
        return meetingHost;
    }

    public void setMeetingHost(UserEmployee meetingHost) {
        this.meetingHost = meetingHost;
    }


    public MeetingState getMeetingState() {
        return meetingState;
    }

    public void setMeetingState(MeetingState meetingState) {
        this.meetingState = meetingState;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
    
    
}
