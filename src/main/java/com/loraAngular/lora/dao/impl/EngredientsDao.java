/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.dao.impl;

import com.douwe.generic.dao.impl.GenericDao;
import com.loraAngular.lora.dao.IEngredients;
import com.loraAngular.lora.data.Engredients;
import org.springframework.stereotype.Component;

/**
 *
 * @author sophonie
 */
@Component
public class EngredientsDao extends GenericDao<Engredients, Long> implements IEngredients{
    
}
