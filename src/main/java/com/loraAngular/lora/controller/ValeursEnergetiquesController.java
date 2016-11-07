/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.controller;

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
@RequestMapping(path = "/valeursenergetiques")
public class ValeursEnergetiquesController {

    @Resource
    private ILoraServices loraServices;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ValeursEnergetiques creerValeursEnergetiques(@RequestBody ValeursEnergetiques valeursEnergetiques) throws ServiceException {
        return loraServices.saveOrUpdate(valeursEnergetiques);
    }

//   @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
//    public ValeursEnergetiques modifierValeursEnergetiques(@PathVariable(value = "id")long id, @RequestBody ValeursEnergetiques valeursEnergetiques){
//        ValeursEnergetiques c = loraServices.findValeursEnergetiquesById(id);
//        c.setNom(valeursEnergetiques.getNom());
//        c.setComptes(valeursEnergetiques.getComptes());
//        c.setProfil(valeursEnergetiques.getProfil());
//        return loraServices.creerOuModifierValeursEnergetiques(c);
//    }
    @RequestMapping(method = RequestMethod.GET)
    public List<ValeursEnergetiques> listerValeursEnergetiques() throws ServiceException {
        return loraServices.findAllValeursEnergetiques();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ValeursEnergetiques findValeursEnergetiques(@PathVariable(value = "id") long id) throws ServiceException {
        return loraServices.findValeursEnergetiquesById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteValeursEnergetiques(@PathVariable(value = "id") long id) throws ServiceException {
        loraServices.deleteValeursEnergetiques(id);
    }
}
