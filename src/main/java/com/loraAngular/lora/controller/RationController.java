/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.controller;

import com.loraAngular.lora.data.BesoinAlimentaire;
import com.loraAngular.lora.data.Ration;
import com.loraAngular.lora.data.ValeursEnergetiques;
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

    @RequestMapping(method = RequestMethod.POST, value = "/{id}/{id2}")
    public Ration creerRation(@RequestBody Ration ration, @PathVariable(value = "id") long id, @PathVariable(value = "id2") long id2) throws ServiceException {
        BesoinAlimentaire b = loraServices.findBesoinAlimentaireById(id);
        ValeursEnergetiques v = loraServices.findValeursEnergetiquesById(id2);
        ration.setBesoinAlimentaire(b);
        ration.setValeursEnergetiques(v);
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
    
    @RequestMapping(method = RequestMethod.GET, value = "/Ra/{id}")
    public List<Ration> listeParBesoin(@PathVariable(value = "id") long id) throws ServiceException {
        return loraServices.findByBesoin(id);
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
