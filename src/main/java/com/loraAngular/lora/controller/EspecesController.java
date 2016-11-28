package com.loraAngular.lora.controller;

import com.loraAngular.lora.data.Especes;
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
@RequestMapping(path = "/especes")
public class EspecesController {
    
    @Resource
    private ILoraServices loraServices;
    
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Especes creerEspeces(@RequestBody Especes espece) throws ServiceException{
        return loraServices.saveOrUpdateEspeces(espece);
    }
    
   
    
   @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Especes modifierEspeces(@PathVariable(value = "id")long id, @RequestBody Especes espece) throws ServiceException{
        Especes c = loraServices.findEspecesById(id);
        c.setNom(espece.getNom());
        c.setType(espece.getType());
        return loraServices.saveOrUpdateEspeces(espece);
    }
    
    @RequestMapping(method = RequestMethod.GET,value = "/")
    public List<Especes> listerEspeces() throws ServiceException{
        return loraServices.findAllEspeces();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Especes findEspeces(@PathVariable(value = "id")long id) throws ServiceException{
        return loraServices.findEspecesById(id);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteEspeces(@PathVariable(value = "id")long id) throws ServiceException{
        loraServices.deleteEspeces(id);
    }
}
