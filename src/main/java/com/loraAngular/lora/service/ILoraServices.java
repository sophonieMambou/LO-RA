/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.service;


import com.loraAngular.lora.data.BesoinAlimentaire;
import com.loraAngular.lora.data.Composition;
import com.loraAngular.lora.data.Engredients;
import com.loraAngular.lora.data.Especes;
import com.loraAngular.lora.data.Ration;
import com.loraAngular.lora.data.ValeursEnergetiques;
import java.util.List;

/**
 *
 * @author sophonie
 */
public interface ILoraServices {
    
    public BesoinAlimentaire saveOrUpdate(BesoinAlimentaire besoinAlimentaire) throws ServiceException;

    public BesoinAlimentaire findBesoinAlimentaireById(Long id) throws ServiceException;

    public void deleteBesoinAlimentaire(Long id) throws ServiceException;
    
    public List<BesoinAlimentaire> findAllBesoinAlimentaire() throws ServiceException;
    
    public Composition saveOrUpdate(Composition composition) throws ServiceException;

    public Composition findCompositionById(Long id) throws ServiceException;

    public void deleteComposition(Long id) throws ServiceException;
    
    public List<Composition> findAllComposition() throws ServiceException;
    
    public Engredients saveOrUpdate(Engredients engredients) throws ServiceException;

    public Engredients findEngredientsById(Long id) throws ServiceException;

    public void deleteEngredients(Long id) throws ServiceException;
    
    public List<Engredients> findAllEngredients() throws ServiceException;

    public Especes saveOrUpdateEspeces(Especes especes) throws ServiceException;

    public void deleteEspeces(Long id) throws ServiceException;

    public Especes findEspecesById(Long id) throws ServiceException;

    public List<Especes> findAllEspeces() throws ServiceException;
    
    public Ration saveOrUpdate(Ration ration) throws ServiceException;

    public Ration findRationById(Long id) throws ServiceException;

    public void deleteRation(Long id) throws ServiceException;
    
    public List<Ration> findAllRation() throws ServiceException;
    
    public ValeursEnergetiques saveOrUpdate(ValeursEnergetiques valeursEnergetiques) throws ServiceException;

    public ValeursEnergetiques findValeursEnergetiquesById(Long id) throws ServiceException;
    
    public void deleteValeursEnergetiques(Long id) throws ServiceException;
    
    public List<ValeursEnergetiques> findAllValeursEnergetiques() throws ServiceException;
}
