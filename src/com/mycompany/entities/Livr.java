/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

import java.util.Date;

/**
 *
 * @author Achraf
 */
public class Livr {
    private int idv;
    private String namev;
    private String street;
    private String cite;
    private String ville;
    private String codep;
    private String email;
    private String tel;
    private String modelivraison;
    private boolean status;

    public String getModelivraison() {
        return modelivraison;
    }

    public void setModelivraison(String modelivraison) {
        this.modelivraison = modelivraison;
    }
    private String utilisateur;
    private Date date;

    public int getIdv() {
        return idv;
    }

    public void setIdv(int idv) {
        this.idv = idv;
    }

    public String getNamev() {
        return namev;
    }

    public void setNamev(String namev) {
        this.namev = namev;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCite() {
        return cite;
    }

    public void setCite(String cite) {
        this.cite = cite;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodep() {
        return codep;
    }

    public void setCodep(String codep) {
        this.codep = codep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Livr() {
    }

    public Livr(String namev, String street, String cite, String ville, String codep, String email, String tel, String modelivraison, boolean status, Date date) {
        this.namev = namev;
        this.street = street;
        this.cite = cite;
        this.ville = ville;
        this.codep = codep;
        this.email = email;
        this.tel = tel;
        this.modelivraison = modelivraison;
        this.status = status;
        this.date = date;
    }

    public Livr(int idv, String namev, String street, String cite, String ville, String codep, String email, String tel, String modelivraison) {
        this.idv = idv;
        this.namev = namev;
        this.street = street;
        this.cite = cite;
        this.ville = ville;
        this.codep = codep;
        this.email = email;
        this.tel = tel;
        this.modelivraison = modelivraison;
    }

    public Livr(int idv, String namev, String street, String cite, String ville, String codep, String email, String tel, String modelivraison, boolean status, Date date) {
        this.idv = idv;
        this.namev = namev;
        this.street = street;
        this.cite = cite;
        this.ville = ville;
        this.codep = codep;
        this.email = email;
        this.modelivraison = modelivraison;
        this.tel = tel;
        this.status = status;
        this.date = date;
    }

}
