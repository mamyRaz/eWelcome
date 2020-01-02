/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author refin
 */
@Entity
@Table
public class WifiCode implements Serializable{
    @Id
    //Pour laisser à Spring le soin de générer un identifiant unique.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idWifiCode;
    
    @NotNull
    private Date initialDate;
    
    private String code="";
    private String state;
    
    @NotNull
    private int numberOfDays;
    
    
    @ManyToOne 
    private UserVisitor visitorAuthorized;

    public WifiCode() {
    }

    public WifiCode(Date initialDate, int numberOfDays) {
        this.initialDate = initialDate;
        this.numberOfDays = numberOfDays;
    }

    

    

    public Long getIdWifiCode() {
        return idWifiCode;
    }

    public void setIdWifiCode(Long idWifiCode) {
        this.idWifiCode = idWifiCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public UserVisitor getVisitorAuthorized() {
        return visitorAuthorized;
    }

    public void setVisitorAuthorized(UserVisitor visitorAuthorized) {
        this.visitorAuthorized = visitorAuthorized;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    
    
    
}
