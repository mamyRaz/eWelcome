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
 */
public interface TypeMeetingService {
    TypeMeeting save(TypeMeeting entity);
    void delete(Long id);
    List<TypeMeeting> findAll();
    TypeMeeting getOne(Long id);
}
