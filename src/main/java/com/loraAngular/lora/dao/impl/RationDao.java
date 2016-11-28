/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.dao.impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.loraAngular.lora.dao.IRation;
import com.loraAngular.lora.data.Ration;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Component;

/**
 *
 * @author sophonie
 */
@Component
public class RationDao extends GenericDao<Ration, Long> implements IRation {

    @Override
    public List<Ration> findByBesoin(Long id) throws DataAccessException {
        try {
            return (List<Ration>) (getManager().createNamedQuery("Ration.findByBesoin").setParameter("param", id).getResultList());
        } catch (NoResultException ex) {
            return null;
        }
    }
}
