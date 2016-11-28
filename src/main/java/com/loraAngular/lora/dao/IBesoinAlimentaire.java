/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.loraAngular.lora.data.BesoinAlimentaire;
import java.util.List;

/**
 *
 * @author sophonie
 */
public interface IBesoinAlimentaire extends IDao<BesoinAlimentaire, Long> {

    public List<BesoinAlimentaire> findByEspece(Long id) throws DataAccessException;
}
