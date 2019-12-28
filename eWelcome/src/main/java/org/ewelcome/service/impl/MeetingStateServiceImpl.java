/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service.impl;

import java.util.List;
import org.ewelcome.entity.MeetingState;
import org.ewelcome.repository.MeetingStateRepository;
import org.ewelcome.service.MeetingStateService;
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
public class MeetingStateServiceImpl implements MeetingStateService{
    
    @Autowired
    MeetingStateRepository meetingStateRepository;

    @Override
    public MeetingState save(MeetingState entity) {
        return meetingStateRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        meetingStateRepository.deleteById(id);
    }

    @Override
    public List<MeetingState> findAll() {
        return (List<MeetingState>)meetingStateRepository.findAll();
    }

    @Override
    public MeetingState getOne(Long id) {
        return meetingStateRepository.getOne(id);
    }

    @Override
    public MeetingState findByState(String type) {
        return meetingStateRepository.findByLabel(type);
    }
    
}
