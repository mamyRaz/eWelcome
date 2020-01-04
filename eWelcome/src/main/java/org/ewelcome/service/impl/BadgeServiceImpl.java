/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service.impl;

import java.util.List;
import java.util.Optional;
import org.ewelcome.entity.Badge;
import org.ewelcome.entity.Meeting;
import org.ewelcome.entity.Person;
import org.ewelcome.repository.BadgeRepository;
import org.ewelcome.repository.MeetingRepository;
import org.ewelcome.service.BadgeService;
import org.ewelcome.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angele
 */
@Service
public class BadgeServiceImpl implements BadgeService {
    
    //@Autowired permet d'injecter automatiquement la bonne dépendance.
    @Autowired
    BadgeRepository badgeRepository;
    
    @Override
    public Badge save(Badge entity) {
        return badgeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        badgeRepository.deleteById(id);
    }

    @Override
    public List<Badge> findAll() {
        return (List<Badge>) badgeRepository.findAll();
    }

    @Override
    public Optional<Badge> findById(Long id) {
        return badgeRepository.findById(id);
    }

  
    @Override
    public Badge getOne(Long id) {
        return badgeRepository.getOne(id);
    }
    
    
/*badge
    @Override
    public Meeting findByIdPerson(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

    

   
    
}
