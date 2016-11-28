/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.dao.impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.loraAngular.lora.dao.IBesoinAlimentaire;
import com.loraAngular.lora.data.BesoinAlimentaire;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Component;

/**
 *
 * @author sophonie
 */
@Component
public class BesoinAlimentaireDao extends GenericDao<BesoinAlimentaire, Long> implements IBesoinAlimentaire {

    @Override
    public List<BesoinAlimentaire> findByEspece(Long id) throws DataAccessException {
        try {
            return (List<BesoinAlimentaire>) (getManager().createNamedQuery("BesoinAlimentaire.findByEspece").setParameter("param", id).getResultList());
        } catch (NoResultException ex) {
            return null;
        }
    }
}
