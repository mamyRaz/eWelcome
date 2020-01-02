/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service.impl;

import org.ewelcome.repository.WifiCodeRepository;
import java.util.List;
import org.ewelcome.entity.UserVisitor;
import org.ewelcome.entity.WifiCode;
import org.ewelcome.service.WifiCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author refin
 */
//@Service est une annotation qui spécialise @Component. Elle indique une classe métier.
@Service
public class WifiCodeServiceIpl implements WifiCodeService {
    
    @Autowired
    WifiCodeRepository wifiCodeRepository;
    
    @Override
    public WifiCode save(WifiCode entity) {
        return wifiCodeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        wifiCodeRepository.deleteById(id);
    }

    @Override
    public List<WifiCode> findAll() {
        return (List<WifiCode>)wifiCodeRepository.findAll();
    }

    @Override
    public WifiCode getOne(Long id) {
        return wifiCodeRepository.getOne(id);
    }

    @Override
    public List<WifiCode> findByVisitorAuthorized(UserVisitor userVisitor) {
        return (List<WifiCode>)wifiCodeRepository.findByVisitorAuthorized(userVisitor);
    }

    @Override
    public List<WifiCode> findAllActiveRequest() {
        return (List<WifiCode>)wifiCodeRepository.findAllActiveRequest();
    }

    @Override
    public WifiCode findByIdWifiCode(Long id) {
        return wifiCodeRepository.findByIdWifiCode(id);
    }
    
}
