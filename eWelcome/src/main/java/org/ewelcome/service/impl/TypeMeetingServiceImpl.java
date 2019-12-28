/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service.impl;

import java.util.List;
import org.ewelcome.entity.TypeMeeting;
import org.ewelcome.repository.TypeMeetingRepository;
import org.ewelcome.service.TypeMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author refin
 */
@Component
//@Service est une annotation qui spécialise @Component. Elle indique une classe métier.
@Service
public class TypeMeetingServiceImpl implements TypeMeetingService{
    //@Autowired permet d'injecter automatiquement la bonne dépendance.
    @Autowired
    TypeMeetingRepository typeMeetingRepository;

    @Override
    public TypeMeeting save(TypeMeeting entity) {
        return typeMeetingRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        typeMeetingRepository.deleteById(id);
    }

    @Override
    public List<TypeMeeting> findAll() {
        return (List<TypeMeeting>)typeMeetingRepository.findAll();
    }

    @Override
    public TypeMeeting getOne(Long id) {
        return typeMeetingRepository.getOne(id);
    }

    @Override
    public TypeMeeting findByTypeMeeting(String type) {
        return typeMeetingRepository.findByLabel(type);
    }
}
