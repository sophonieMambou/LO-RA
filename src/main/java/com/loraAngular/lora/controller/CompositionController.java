/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.controller;

import com.loraAngular.lora.data.Composition;
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
@RequestMapping(path = "/composition")
public class CompositionController {

    @Resource
    private ILoraServices loraServices;
    
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Composition creerComposition(@RequestBody Composition composition) throws ServiceException{
        return loraServices.saveOrUpdate(composition);
    }
    

//   
//    
//   @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
//    public Composition modifierComposition(@PathVariable(value = "id")long id, @RequestBody Composition composition){
//        Composition c = loraServices.findCompositionById(id);
//        c.setNom(composition.getNom());
//        c.setComptes(composition.getComptes());
//        c.setProfil(composition.getProfil());
//        return loraServices.creerOuModifierComposition(c);
//    }
//    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Composition> listerComposition() throws ServiceException {
        return loraServices.findAllComposition();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Composition findComposition(@PathVariable(value = "id") long id) throws ServiceException {
        return loraServices.findCompositionById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteComposition(@PathVariable(value = "id") long id) throws ServiceException {
        loraServices.deleteComposition(id);
    }
}
