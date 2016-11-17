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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author sophonie
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BesoinAlimentaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "especes_id")
    private Especes especes;

    @OneToMany
    private List<Ration> ration;

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

    public Especes getEspeces() {
        return especes;
    }

    public void setEspeces(Especes especes) {
        this.especes = especes;
    }

    public List<Ration> getRation() {
        return ration;
    }

    public void setRation(List<Ration> ration) {
        this.ration = ration;
    }
}
