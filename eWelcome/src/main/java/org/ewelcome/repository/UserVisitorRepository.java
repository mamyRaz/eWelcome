/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.repository;

import org.ewelcome.entity.UserVisitor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author refin
 */
public interface UserVisitorRepository extends JpaRepository<UserVisitor, Long>{
    
}
