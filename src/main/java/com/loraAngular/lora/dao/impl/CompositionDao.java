/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.dao.impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.loraAngular.lora.dao.IComposition;
import com.loraAngular.lora.data.Composition;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Component;

/**
 *
 * @author sophonie
 */
@Component
public class CompositionDao extends GenericDao<Composition, Long> implements IComposition{

    @Override
    public List<Composition> findByEngredient(Long id) throws DataAccessException {
        try {
            return (List<Composition>) (getManager().createNamedQuery("Composition.findByEngredient").setParameter("param", id).getResultList());
        } catch (NoResultException ex) {
            return null;
        }
    }
    
}
