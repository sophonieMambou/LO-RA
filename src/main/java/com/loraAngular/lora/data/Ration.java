/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loraAngular.lora.data;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sophonie
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Ration.findByBesoin", query = "SELECT a FROM Ration a WHERE a.besoinAlimentaire.id = :param")
})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ration implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "besoinAlimentaire_id")
    private BesoinAlimentaire besoinAlimentaire;

    @ManyToOne
    @JoinColumn(name = "valeursEnergetiques_id")
    private ValeursEnergetiques valeursEnergetiques;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BesoinAlimentaire getBesoinAlimentaire() {
        return besoinAlimentaire;
    }

    public void setBesoinAlimentaire(BesoinAlimentaire besoinAlimentaire) {
        this.besoinAlimentaire = besoinAlimentaire;
    }

    public ValeursEnergetiques getValeursEnergetiques() {
        return valeursEnergetiques;
    }

    public void setValeursEnergetiques(ValeursEnergetiques valeursEnergetiques) {
        this.valeursEnergetiques = valeursEnergetiques;
    }

}
