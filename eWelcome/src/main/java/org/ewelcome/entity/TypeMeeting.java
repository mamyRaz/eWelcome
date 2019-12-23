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
 */
@Entity
@Table(name = "typeMeeting")
public class TypeMeeting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Size(min = 5, max = 10)
    private String label;
    
    @OneToMany(mappedBy = "typeMeeting") // one type of meeting to many meeting
    private List<Meeting> meetingsList;
    
    
    public TypeMeeting(String label) {
        this.label = label;
    }
    
    public TypeMeeting(){
        
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
