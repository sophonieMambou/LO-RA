/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

/**
 *
 * @author sophonie
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Especes implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private String nom;
    
    private TypeAnimaux type;
    
    @OneToMany
    private List<BesoinAlimentaire> besoinAlimentaire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypeAnimaux getType() {
        return type;
    }

    public void setType(TypeAnimaux type) {
        this.type = type;
    }

    public List<BesoinAlimentaire> getBesoinAlimentaire() {
        return besoinAlimentaire;
    }

    public void setBesoinAlimentaire(List<BesoinAlimentaire> besoinAlimentaire) {
        this.besoinAlimentaire = besoinAlimentaire;
    }
    
}
