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

/**
 *
 * @author refin
 */
public class UserRoleServiceImpl implements UserRoleService{
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserRole getOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
