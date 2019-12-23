/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.repository;

import org.ewelcome.entity.UserEmployee;
import org.ewelcome.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author refin
 */

public interface UserRoleRepository extends JpaRepository<UserEmployee, Long>{
    public UserRole save(UserRole entity);
    
}
