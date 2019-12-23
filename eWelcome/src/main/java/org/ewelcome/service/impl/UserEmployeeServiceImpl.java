/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service.impl;

import java.util.List;
import org.ewelcome.entity.UserEmployee;
import org.ewelcome.repository.UserEmployeeRepository;
import org.ewelcome.service.UserEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author refin
 */
public class UserEmployeeServiceImpl implements UserEmployeeService{
    @Autowired
    UserEmployeeRepository userEmployeeRepository;

    @Override
    public UserEmployee save(UserEmployee entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserEmployee> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserEmployee getOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
