/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.ewelcome.entity.Meeting;

/**
 *
 * @author refin
 * Couche service, couche intermédiaire
 * On y définit les méthodes dont on a besoin.
 */
public interface MeetingService {
    Meeting save(Meeting entity);
    void delete(Long id);
    List<Meeting> findAll();
    Meeting getOne(Long id);
    Optional<Meeting> findById(Long id);
   // List<Meeting> findAllByDate(Date date);
}
