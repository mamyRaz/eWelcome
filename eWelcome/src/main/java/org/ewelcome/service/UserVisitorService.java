/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service;

import java.util.List;
import org.ewelcome.entity.UserVisitor;

/**
 *
 * @author refin
 * * Couche service, couche intermédiaire
 * On y définit les méthodes dont on a besoin.
 */
public interface UserVisitorService {
     UserVisitor save(UserVisitor entity);
    void delete(Long id);
    List<UserVisitor> findAll();
    UserVisitor getOne(Long id);
}