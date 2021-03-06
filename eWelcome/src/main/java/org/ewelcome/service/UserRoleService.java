/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service;

import java.util.List;
import org.ewelcome.entity.UserRole;

/**
 *
 * @author refin
 * * Couche service, couche intermédiaire
 * On y définit les méthodes dont on a besoin.
 */
public interface UserRoleService {
    UserRole save(UserRole entity);
    void delete(Long id);
    List<UserRole> findAll();
    UserRole getOne(Long id);
    UserRole findByRole(String label);
}
