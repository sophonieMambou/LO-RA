/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.controller;

import com.loraAngular.lora.data.Ration;
import com.loraAngular.lora.service.ILoraServices;
import com.loraAngular.lora.service.ServiceException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sophonie
 */
@RestController
@RequestMapping(path = "/ration")
public class RationController {

    @Resource
    private ILoraServices loraServices;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Ration creerRation(@RequestBody Ration ration) throws ServiceException {
        return loraServices.saveOrUpdate(ration);
    }

//   
//    
//   @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
//    public Ration modifierRation(@PathVariable(value = "id")long id, @RequestBody Ration ration){
//        Ration c = loraServices.findRationById(id);
//        c.setNom(ration.getNom());
//        c.setComptes(ration.getComptes());
//        c.setProfil(ration.getProfil());
//        return loraServices.creerOuModifierRation(c);
//    }
//    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Ration> listerRation() throws ServiceException {
        return loraServices.findAllRation();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Ration findRation(@PathVariable(value = "id") long id) throws ServiceException {
        return loraServices.findRationById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteRation(@PathVariable(value = "id") long id) throws ServiceException {
        loraServices.deleteRation(id);
    }
}
