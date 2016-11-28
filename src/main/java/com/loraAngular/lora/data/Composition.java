/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.data;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author sophonie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Composition.findByEngredient", query = "SELECT a FROM Composition a WHERE a.engredients.id = :param")
})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Composition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private float valMin;

    private float valMax;

    @ManyToOne
    @JoinColumn(name = "engredients_id")
    private Engredients engredients;

    @ManyToOne
    @JoinColumn(name = "valeursEnergetiques_id")
    private ValeursEnergetiques valeursEnergetiques;

    public Composition(Engredients engredients, ValeursEnergetiques valeursEnergetiques) {
        this.engredients = engredients;
        this.valeursEnergetiques = valeursEnergetiques;
    }

    public Composition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValMin() {
        return valMin;
    }

    public void setValMin(float valMin) {
        this.valMin = valMin;
    }

    public float getValMax() {
        return valMax;
    }

    public void setValMax(float valMax) {
        this.valMax = valMax;
    }

    public Engredients getEngredients() {
        return engredients;
    }

    public void setEngredients(Engredients engredients) {
        this.engredients = engredients;
    }

    public ValeursEnergetiques getValeursEnergetiques() {
        return valeursEnergetiques;
    }

    public void setValeursEnergetiques(ValeursEnergetiques valeursEnergetiques) {
        this.valeursEnergetiques = valeursEnergetiques;
    }
}
