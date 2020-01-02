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
        return userVisitorRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        userVisitorRepository.deleteById(id);
    }

    @Override
    public List<UserVisitor> findAll() {
        return (List<UserVisitor>)userVisitorRepository.findAll();
    }

    @Override
    public UserVisitor getOne(Long id) {
        return userVisitorRepository.getOne(id);
    }

    @Override
    public UserVisitor findByIdVisitor(Long id) {
        return userVisitorRepository.findByIdVisitor(id);
    }
}
