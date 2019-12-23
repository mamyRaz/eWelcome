/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service;

import java.util.List;
import org.ewelcome.entity.UserEmployee;

/**
 *
 * @author refin
 */
public interface UserEmployeeService {
    UserEmployee save(UserEmployee entity);
    void delete(Long id);
    List<UserEmployee> findAll();
    UserEmployee getOne(Long id);
}
