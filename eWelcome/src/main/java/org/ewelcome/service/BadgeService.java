/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ewelcome.service;

import java.util.List;
import java.util.Optional;
import org.ewelcome.entity.Badge;
import org.ewelcome.entity.Person;

/**
 *
 * @author angele
 */
public interface BadgeService {
    Badge save(Badge entity);
    void delete(Long id);
    List<Badge> findAll();
    Badge getOne(Long id);
    Optional<Badge> findById(Long id);
}
