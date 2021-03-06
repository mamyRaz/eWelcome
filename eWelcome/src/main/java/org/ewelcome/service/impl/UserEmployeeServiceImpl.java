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
import org.springframework.stereotype.Service;

/**
 *
 * @author refin
 */
//@Service est une annotation qui spécialise @Component. Elle indique une classe métier.
@Service 
public class UserEmployeeServiceImpl implements UserEmployeeService{
    //@Autowired permet d'injecter automatiquement la bonne dépendance.
    @Autowired
    UserEmployeeRepository userEmployeeRepository;

    @Override
    public UserEmployee save(UserEmployee entity) {
        return userEmployeeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        userEmployeeRepository.deleteById(id);
    }

    @Override
    public List<UserEmployee> findAll() {
        return (List<UserEmployee>)userEmployeeRepository.findAll();
    }

    @Override
    public UserEmployee getOne(Long id) {
        return userEmployeeRepository.getOne(id);
    }

    @Override
    public UserEmployee findByIdEmployee(Long id) {
        return userEmployeeRepository.findByIdEmployee(id);
    }
}
