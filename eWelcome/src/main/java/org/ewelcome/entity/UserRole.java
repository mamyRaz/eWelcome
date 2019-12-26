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
 * Abstraction de l'objet UserRole de la bd comme objet métier
 */
@Entity
@Table(name = "userRole")
public class UserRole implements Serializable {
    
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
       Un role peut catégoriser plusieurs personnes, c'est une relation bidirectionnelle. 
       Le paramètre (mappedBy = "role") indique que role/UserRole est la table esclave. 
       C'est-à-dire que c'est la table Person est qui contient une clé étrangère "role"
    */
    
    @OneToMany(mappedBy = "role") // one role to many person
    private List<Person> persons;
    
    public UserRole(String label) {
        this.label = label;
    }
    
    
    /*
        Un role est une entité donc un bean. Un bean doit 
        posséder un contructeur par défaut, afin que Spring puisse l'instancier
    */

    public UserRole(){
        
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

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
    
}
