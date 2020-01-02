/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.repository;

import java.util.List;
import org.ewelcome.entity.UserVisitor;
import org.ewelcome.entity.WifiCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author refin
 */
public interface WifiCodeRepository extends JpaRepository<WifiCode, Long>{
    List<WifiCode> findByVisitorAuthorized(UserVisitor userVisitor);
    @Query(value = "SELECT * FROM wifi_code wc WHERE wc.state = 'En attente'", 
            nativeQuery = true)
    List<WifiCode> findAllActiveRequest();
    WifiCode findByIdWifiCode(Long id);
}
