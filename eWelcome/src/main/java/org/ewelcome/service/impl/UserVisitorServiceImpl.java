/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service.impl;

import java.util.List;
import org.ewelcome.entity.UserVisitor;
import org.ewelcome.repository.UserVisitorRepository;
import org.ewelcome.service.UserVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author refin
 */
//@Service est une annotation qui spécialise @Component. Elle indique une classe métier.
@Service
public class UserVisitorServiceImpl implements UserVisitorService{
    //@Autowired permet d'injecter automatiquement la bonne dépendance.
    @Autowired
    UserVisitorRepository userVisitorRepository;

    @Override
    public UserVisitor save(UserVisitor entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserVisitor> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserVisitor getOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
