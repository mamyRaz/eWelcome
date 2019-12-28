/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service;

import java.util.List;
import org.ewelcome.entity.TypeMeeting;

/**
 *
 * @author refin
 * * Couche service, couche intermédiaire
 * On y définit les méthodes dont on a besoin.
 */
public interface TypeMeetingService {
    public TypeMeeting save(TypeMeeting entity);
    public void delete(Long id);
    public List<TypeMeeting> findAll();
    public TypeMeeting getOne(Long id);
    public TypeMeeting findByTypeMeeting(String type);
}
