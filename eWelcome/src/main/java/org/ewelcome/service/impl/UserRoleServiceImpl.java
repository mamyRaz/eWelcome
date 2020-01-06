/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service.impl;

import java.util.List;
import org.ewelcome.entity.UserRole;
import org.ewelcome.repository.UserRoleRepository;
import org.ewelcome.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author refin
 */
//@Service est une annotation qui spécialise @Component. Elle indique une classe métier.
@Service
public class UserRoleServiceImpl implements UserRoleService{
    //@Autowired permet d'injecter automatiquement la bonne dépendance.
    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public UserRole save(UserRole entity) {
        return userRoleRepository.save(entity);
        
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole getOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserRole findByRole(String label) {
        return userRoleRepository.findByLabel(label);
    }
    
    
}
