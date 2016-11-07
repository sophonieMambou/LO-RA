/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.controller;

import com.loraAngular.lora.data.BesoinAlimentaire;
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
@RequestMapping(path = "/besoinAlimentaires")
public class BesoinAlimentaireController {

    @Resource
    private ILoraServices loraServices;
    
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public BesoinAlimentaire creerBesoinAlimentaire(@RequestBody BesoinAlimentaire besoinAlimentaire) throws ServiceException {
        return loraServices.saveOrUpdate(besoinAlimentaire);
    }

//   
//    
//   @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
//    public BesoinAlimentaire modifierBesoinAlimentaire(@PathVariable(value = "id")long id, @RequestBody BesoinAlimentaire besoinAlimentaire){
//        BesoinAlimentaire c = loraServices.findBesoinAlimentaireById(id);
//        c.setNom(besoinAlimentaire.getNom());
//        c.setComptes(besoinAlimentaire.getComptes());
//        c.setProfil(besoinAlimentaire.getProfil());
//        return loraServices.creerOuModifierBesoinAlimentaire(c);
//    }
//    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<BesoinAlimentaire> listerBesoinAlimentaire() throws ServiceException {
        return loraServices.findAllBesoinAlimentaire();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public BesoinAlimentaire findBesoinAlimentaire(@PathVariable(value = "id") long id) throws ServiceException {
        return loraServices.findBesoinAlimentaireById(id);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteBesoinAlimentaire(@PathVariable(value = "id") long id) throws ServiceException {
        loraServices.deleteBesoinAlimentaire(id);
    }
}
