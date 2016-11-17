package com.loraAngular.lora.controller;

import com.loraAngular.lora.data.Engredients;
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
 * @author Vincent Douwe <douwevincent@yahoo.fr>
 */
@RestController
@RequestMapping(path = "/engredients")
public class EngredientsController {
    
    @Resource
    private ILoraServices loraServices;
    
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Engredients creerEngredients(@RequestBody Engredients engredient) throws ServiceException{
        return loraServices.saveOrUpdate(engredient);
    }
    
   
    
//   @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
//    public Engredients modifierEngredients(@PathVariable(value = "id")long id, @RequestBody Engredients engredient) throws ServiceException{
//        Engredients c = loraServices.findEngredientsById(id);
//        c.setNom(engredient.getNom());
//        c.setType(engredient.getType());
//        return loraServices.saveOrUpdateEngredients(engredient);
//    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Engredients> listerEngredients() throws ServiceException{
        return loraServices.findAllEngredients();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Engredients findEngredients(@PathVariable(value = "id")long id) throws ServiceException{
        return loraServices.findEngredientsById(id);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteEngredients(@PathVariable(value = "id")long id) throws ServiceException{
        loraServices.deleteEngredients(id);
    }
}
