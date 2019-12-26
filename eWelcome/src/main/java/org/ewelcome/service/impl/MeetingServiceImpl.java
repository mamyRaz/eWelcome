/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.ewelcome.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.ewelcome.repository.MeetingRepository;
import org.ewelcome.service.MeetingService;

/**
 *
 * @author refin
 */

//@Service est une annotation qui spécialise @Component. Elle indique une classe métier.
@Service
public class MeetingServiceImpl implements MeetingService {
    
    //@Autowired permet d'injecter automatiquement la bonne dépendance.
    @Autowired
    MeetingRepository meetingRepository;
    
    @Override
    public Meeting save(Meeting entity) {
        return meetingRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        meetingRepository.deleteById(id);
    }

    @Override
    public List<Meeting> findAll() {
        return (List<Meeting>) meetingRepository.findAll();
    }

    @Override
    public Optional<Meeting> findById(Long id) {
        return meetingRepository.findById(id);
    }

  
    @Override
    public Meeting getOne(Long id) {
        return meetingRepository.getOne(id);
    }
/*
    @Override
    public Meeting findByIdPerson(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

   
    
}
