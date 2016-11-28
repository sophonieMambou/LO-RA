/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.service.impl;

import com.douwe.generic.dao.DataAccessException;
import com.loraAngular.lora.dao.IBesoinAlimentaire;
import com.loraAngular.lora.dao.IComposition;
import com.loraAngular.lora.dao.IEngredients;
import com.loraAngular.lora.dao.IEspeces;
import com.loraAngular.lora.dao.IRation;
import com.loraAngular.lora.dao.IValeursEnergetiques;
import com.loraAngular.lora.data.BesoinAlimentaire;
import com.loraAngular.lora.data.Composition;
import com.loraAngular.lora.data.Engredients;
import com.loraAngular.lora.data.Especes;
import com.loraAngular.lora.data.Ration;
import com.loraAngular.lora.data.ValeursEnergetiques;
import com.loraAngular.lora.service.ILoraServices;
import com.loraAngular.lora.service.ServiceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sophonie
 */
@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Transactional
public class LoraServices implements ILoraServices {

    @Resource
    private IEspeces especesDao;

    @Resource
    private IBesoinAlimentaire besoinAlimentaireDao;

    @Resource
    private IEngredients engredientsDao;

    @Resource
    private IComposition compositionDao;

    @Resource
    private IRation rationDao;

    @Resource
    private IValeursEnergetiques valeursEnergetiquesDao;

    public IBesoinAlimentaire getBesoinAlimentaireDao() {
        return besoinAlimentaireDao;
    }

    public void setBesoinAlimentaireDao(IBesoinAlimentaire besoinAlimentaireDao) {
        this.besoinAlimentaireDao = besoinAlimentaireDao;
    }

    public IComposition getCompositionDao() {
        return compositionDao;
    }

    public void setCompositionDao(IComposition compositionDao) {
        this.compositionDao = compositionDao;
    }

    public IEngredients getEngredientsDao() {
        return engredientsDao;
    }

    public void setEngredientsDao(IEngredients engredientsDao) {
        this.engredientsDao = engredientsDao;
    }

    public IRation getRationDao() {
        return rationDao;
    }

    public void setRationDao(IRation rationDao) {
        this.rationDao = rationDao;
    }

    public IValeursEnergetiques getValeursEnergetiquesDao() {
        return valeursEnergetiquesDao;
    }

    public void setValeursEnergetiquesDao(IValeursEnergetiques valeursEnergetiquesDao) {
        this.valeursEnergetiquesDao = valeursEnergetiquesDao;
    }

    public IEspeces getEspecesDao() {
        return especesDao;
    }

    public void setEspecesDao(IEspeces especesDao) {
        this.especesDao = especesDao;
    }

    @Override
    public Especes saveOrUpdateEspeces(Especes especes) throws ServiceException {
        try {
            if (especes.getId() == null) {
                return especesDao.create(especes);
            } else {
                return especesDao.update(especes);
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public void deleteEspeces(Long id) throws ServiceException {
        try {
            Especes especes = especesDao.findById(id);
            especesDao.delete(especes);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public Especes findEspecesById(Long id) throws ServiceException {
        try {
            return especesDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public List<Especes> findAllEspeces() throws ServiceException {
        try {
            return especesDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public BesoinAlimentaire saveOrUpdate(BesoinAlimentaire besoinAlimentaire) throws ServiceException {
        try {
            if (besoinAlimentaire.getId() == null) {
                return besoinAlimentaireDao.create(besoinAlimentaire);
            } else {
                return besoinAlimentaireDao.update(besoinAlimentaire);
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public BesoinAlimentaire findBesoinAlimentaireById(Long id) throws ServiceException {
        try {
            return besoinAlimentaireDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public List<BesoinAlimentaire> findByEspece(Long id) throws ServiceException {
        try {
            return besoinAlimentaireDao.findByEspece(id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void deleteBesoinAlimentaire(Long id) throws ServiceException {
        try {
            BesoinAlimentaire besoinAlimentaire = besoinAlimentaireDao.findById(id);
            besoinAlimentaireDao.delete(besoinAlimentaire);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public List<BesoinAlimentaire> findAllBesoinAlimentaire() throws ServiceException {
        try {
            return besoinAlimentaireDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public Composition saveOrUpdate(Composition composition) throws ServiceException {
        try {
            if (composition.getId() == null) {
                return compositionDao.create(composition);
            } else {
                return compositionDao.update(composition);
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public Composition findCompositionById(Long id) throws ServiceException {
        try {
            return compositionDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public void deleteComposition(Long id) throws ServiceException {
        try {
            Composition composition = compositionDao.findById(id);
            compositionDao.delete(composition);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public List<Composition> findAllComposition() throws ServiceException {
        try {
            return compositionDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public List<Composition> findByEngredient(Long id) throws ServiceException {
        try {
            return compositionDao.findByEngredient(id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Engredients saveOrUpdate(Engredients engredients) throws ServiceException {
        try {
            if (engredients.getId() == null) {
                return engredientsDao.create(engredients);
            } else {
                return engredientsDao.update(engredients);
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public Engredients findEngredientsById(Long id) throws ServiceException {
        try {
            return engredientsDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public void deleteEngredients(Long id) throws ServiceException {
        try {
            Engredients engredients = engredientsDao.findById(id);
            engredientsDao.delete(engredients);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public List<Engredients> findAllEngredients() throws ServiceException {
        try {
            return engredientsDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public Ration saveOrUpdate(Ration ration) throws ServiceException {
        try {
            if (ration.getId() == null) {
                return rationDao.create(ration);
            } else {
                return rationDao.update(ration);
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public Ration findRationById(Long id) throws ServiceException {
        try {
            return rationDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public void deleteRation(Long id) throws ServiceException {
        try {
            Ration ration = rationDao.findById(id);
            rationDao.delete(ration);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public List<Ration> findAllRation() throws ServiceException {
        try {
            return rationDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public List<Ration> findByBesoin(Long id) throws ServiceException {
        try {
            return rationDao.findByBesoin(id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public ValeursEnergetiques saveOrUpdate(ValeursEnergetiques valeursEnergetiques) throws ServiceException {
        try {
            if (valeursEnergetiques.getId() == null) {
                return valeursEnergetiquesDao.create(valeursEnergetiques);
            } else {
                return valeursEnergetiquesDao.update(valeursEnergetiques);
            }
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public ValeursEnergetiques findValeursEnergetiquesById(Long id) throws ServiceException {
        try {
            return valeursEnergetiquesDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }

    @Override
    public void deleteValeursEnergetiques(Long id) throws ServiceException {
        try {
            ValeursEnergetiques valeursEnergetiques = valeursEnergetiquesDao.findById(id);
            valeursEnergetiquesDao.delete(valeursEnergetiques);
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non effectué");
        }
    }

    @Override
    public List<ValeursEnergetiques> findAllValeursEnergetiques() throws ServiceException {
        try {
            return valeursEnergetiquesDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(LoraServices.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("non trouvé");
        }
    }
}
