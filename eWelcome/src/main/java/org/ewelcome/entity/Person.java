/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author refin
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"})}, name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;
    @NotNull
    @Size(min = 2, max = 20)
    private String firstName;
    @NotNull
    @Size(min = 2, max = 50)
    private String email;
    @NotNull
    @Size(min = 8, max = 20)
    
    //private String mdp;ajouter relation table user
    @Size(min = 8, max = 70)
    private String address;
    
    //gérer la longueur en fonction du pay
    @Size(min = 11, max = 11)
    private int telephoneNumber;
    
    //ajouter relation role
    @NotNull
    @ManyToOne //many person to one role
    private UserRole role;
    
    @NotNull
    @OneToOne(mappedBy = "person")
    private UserEmployee userEmployee;
    
    //@NotNull
    @ManyToMany(cascade = { CascadeType.PERSIST
                            ,CascadeType.MERGE})
    @JoinTable(
        name = "match_person_meeting", 
        joinColumns = { @JoinColumn(name = "idPerson") }, 
        inverseJoinColumns = { @JoinColumn(name = "idMeeting") }
    )
    private Set<Meeting> meetingList  = new HashSet<>();

    public Person(String lastName, String firstName, String email, String address, int telephoneNumber, UserRole role, UserEmployee userEmployee, List<Meeting> meetingList) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.role = role;
        this.userEmployee = userEmployee;
//        this.meeting = meeting;
        this.meetingList = (Set<Meeting>) meetingList;
    }
    
       
     public Person(){
         
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
     
     

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return lastName+ " "+firstName+" "+email;
    }

    public UserEmployee getUserEmployee() {
        return userEmployee;
    }

    public void setUserEmployee(UserEmployee userEmployee) {
        this.userEmployee = userEmployee;
    }
/*
    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }
*/
    public List<Meeting> getMeetingList() {
        return (List<Meeting>) meetingList;
    }

    public void setMeetingList(List<Meeting> meetingList) {
        this.meetingList = (Set<Meeting>) meetingList;
    }
    
    
    
}
