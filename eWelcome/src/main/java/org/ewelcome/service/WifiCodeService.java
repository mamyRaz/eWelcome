/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service;

import java.util.List;
import org.ewelcome.entity.UserVisitor;
import org.ewelcome.entity.WifiCode;

/**
 *
 * @author refin
 */
public interface WifiCodeService {
    WifiCode save(WifiCode entity);
    void delete(Long id);
    List<WifiCode> findAll();
    WifiCode getOne(Long id);
    List<WifiCode> findByVisitorAuthorized(UserVisitor userVisitor);
    List<WifiCode> findAllActiveRequest();
    WifiCode findByIdWifiCode(Long id);
}
