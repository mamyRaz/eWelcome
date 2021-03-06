/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.repository;

import java.util.List;
import org.ewelcome.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
    @author refin
    L'interface JpaRepository possède déjà un certain nombres de méthodes pour faire des requêtes dans la table, 
    comme par exemple findAll(), deleteById(ID id), save(S entity)
 */

public interface MeetingRepository extends JpaRepository<Meeting, Long>{
    List<Meeting> findAllByOrderByDateMeeting();
    Meeting findByIdMeeting(Long id);
}
