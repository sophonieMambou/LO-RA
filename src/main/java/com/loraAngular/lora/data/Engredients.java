/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.data;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
public class Engredients implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private String nom;
    
    private int prix;
    
    private TypeAliments type_aliment;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "engredients")
    private List<Composition> composition;

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

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public TypeAliments getType_aliment() {
        return type_aliment;
    }

    public void setType_aliment(TypeAliments type_aliment) {
        this.type_aliment = type_aliment;
    }

    public List<Composition> getComposition() {
        return composition;
    }

    public void setComposition(List<Composition> composition) {
        this.composition = composition;
    }
    
}
