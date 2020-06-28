package com.example.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbCell")
public class Cell {

    @Column(name = "CITY")
    private String CITY;

    @Id
    @Column(name = "SECTOR_ID")
    private String SECTOR_ID;

    @Column(name = "SECTOR_NAME")
    private String SECTOR_NAME;

    @Column(name = "ENODEBID")
    private Float ENODEBID;

    @Column(name = "ENODEB_NAME")
    private String ENODEB_NAME;

    @Column(name = "EARFCN")
    private Float EARFCN;

    @Column(name = "PCI")
    private Float PCI;

    @Column(name = "PSS")
    private Float PSS;

    @Column(name = "SSS")
    private Float SSS;

    @Column(name = "TAC")
    private Float TAC;

    @Column(name = "VENDOR")
    private String VENDOR;

    @Column(name = "LONGITUDE")
    private Float LONGITUDE;

    @Column(name = "LATITUDE")
    private Float LATITUDE;

    @Column(name = "STYLE")
    private String STYLE;

    @Column(name = "AZIMUTH")
    private Float AZIMUTH;

    @Column(name = "HEIGHT")
    private Float HEIGHT;

    @Column(name = "ELECTTILT")
    private Float ELECTTILT;

    @Column(name = "MECHTILT")
    private Float MECHTILT;

    @Column(name = "TOTLETILT")
    private Float TOTLETILT;

    @Override
    public String toString() {
        return "Cell{" +
                "CITY='" + CITY + '\'' +
                ", SECTOR_ID='" + SECTOR_ID + '\'' +
                ", SECTOR_NAME='" + SECTOR_NAME + '\'' +
                ", ENODEBID=" + ENODEBID +
                ", ENODEB_NAME='" + ENODEB_NAME + '\'' +
                ", EARFCN=" + EARFCN +
                ", PCI=" + PCI +
                ", PSS=" + PSS +
                ", SSS=" + SSS +
                ", TAC=" + TAC +
                ", VENDOR='" + VENDOR + '\'' +
                ", LONGITUDE=" + LONGITUDE +
                ", LATITUDE=" + LATITUDE +
                ", STYLE='" + STYLE + '\'' +
                ", AZIMUTH=" + AZIMUTH +
                ", HEIGHT=" + HEIGHT +
                ", ELECTTILT=" + ELECTTILT +
                ", MECHTILT=" + MECHTILT +
                ", TOTLETILT=" + TOTLETILT +
                '}';
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getSECTOR_ID() {
        return SECTOR_ID;
    }

    public void setSECTOR_ID(String SECTOR_ID) {
        this.SECTOR_ID = SECTOR_ID;
    }

    public String getSECTOR_NAME() {
        return SECTOR_NAME;
    }

    public void setSECTOR_NAME(String SECTOR_NAME) {
        this.SECTOR_NAME = SECTOR_NAME;
    }

    public Float getENODEBID() {
        return ENODEBID;
    }

    public void setENODEBID(Float ENODEBID) {
        this.ENODEBID = ENODEBID;
    }

    public String getENODEB_NAME() {
        return ENODEB_NAME;
    }

    public void setENODEB_NAME(String ENODEB_NAME) {
        this.ENODEB_NAME = ENODEB_NAME;
    }

    public Float getEARFCN() {
        return EARFCN;
    }

    public void setEARFCN(Float EARFCN) {
        this.EARFCN = EARFCN;
    }

    public Float getPCI() {
        return PCI;
    }

    public void setPCI(Float PCI) {
        this.PCI = PCI;
    }

    public Float getPSS() {
        return PSS;
    }

    public void setPSS(Float PSS) {
        this.PSS = PSS;
    }

    public Float getSSS() {
        return SSS;
    }

    public void setSSS(Float SSS) {
        this.SSS = SSS;
    }

    public Float getTAC() {
        return TAC;
    }

    public void setTAC(Float TAC) {
        this.TAC = TAC;
    }

    public String getVENDOR() {
        return VENDOR;
    }

    public void setVENDOR(String VENDOR) {
        this.VENDOR = VENDOR;
    }

    public Float getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(Float LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public Float getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(Float LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public String getSTYLE() {
        return STYLE;
    }

    public void setSTYLE(String STYLE) {
        this.STYLE = STYLE;
    }

    public Float getAZIMUTH() {
        return AZIMUTH;
    }

    public void setAZIMUTH(Float AZIMUTH) {
        this.AZIMUTH = AZIMUTH;
    }

    public Float getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(Float HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public Float getELECTTILT() {
        return ELECTTILT;
    }

    public void setELECTTILT(Float ELECTTILT) {
        this.ELECTTILT = ELECTTILT;
    }

    public Float getMECHTILT() {
        return MECHTILT;
    }

    public void setMECHTILT(Float MECHTILT) {
        this.MECHTILT = MECHTILT;
    }

    public Float getTOTLETILT() {
        return TOTLETILT;
    }

    public void setTOTLETILT(Float TOTLETILT) {
        this.TOTLETILT = TOTLETILT;
    }
}
