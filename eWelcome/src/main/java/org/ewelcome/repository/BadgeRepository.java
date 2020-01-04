/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.repository;

import org.ewelcome.entity.Badge;
import org.ewelcome.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author angele
 */
public interface BadgeRepository extends JpaRepository<Badge, Long>{

    
}
