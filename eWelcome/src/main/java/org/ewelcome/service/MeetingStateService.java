/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service;

import java.util.List;
import org.ewelcome.entity.MeetingState;

/**
 *
 * @author refin
 */
public interface MeetingStateService {
    public MeetingState save(MeetingState entity);
    public void delete(Long id);
    public List<MeetingState> findAll();
    public MeetingState getOne(Long id);
    public MeetingState findByState(String type);
}
