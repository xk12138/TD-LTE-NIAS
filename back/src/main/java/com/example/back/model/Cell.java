package com.example.back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "tbcell")
public class Cell {

    @Column(name = "CITY")
    private String CITY;

    @Id
    @Column(name = "SECTOR_ID")
    private String SECTOR_ID;

    @Column(name = "SECTOR_NAME")
    private String SECTOR_NAME;

    @Column(name = "ENODEBID")
    private Integer ENODEBID;

    @Column(name = "ENODEB_NAME")
    private String ENODEB_NAME;

    @Column(name = "EARFCN")
    private Integer EARFCN;

    @Column(name = "PCI")
    private Integer PCI;

    @Column(name = "PSS")
    private Integer PSS;

    @Column(name = "SSS")
    private Integer SSS;

    @Column(name = "TAC")
    private Integer TAC;

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

    public static String toKeys() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        s.append("CITY").append(",");
        s.append("SECTOR_ID").append(",");
        s.append("SECTOR_NAME").append(",");
        s.append("ENODEBID").append(",");
        s.append("ENODEB_NAME").append(",");
        s.append("EARFCN").append(",");
        s.append("PCI").append(",");
        s.append("PSS").append(",");
        s.append("SSS").append(",");
        s.append("TAC").append(",");
        s.append("VENDOR").append(",");
        s.append("LONGITUDE").append(",");
        s.append("LATITUDE").append(",");
        s.append("STYLE").append(",");
        s.append("AZIMUTH").append(",");
        s.append("HEIGHT").append(",");
        s.append("ELECTTILT").append(",");
        s.append("MECHTILT").append(",");
        s.append("TOTLETILT").append(")");

        return s.toString();
    }

    public String toMsg() {
        return "(\'" + CITY + "\'," +
                "\'" + SECTOR_ID + "\'," +
                "\'" + SECTOR_NAME + "\'," +
                "\'" + ENODEBID + "\'," +
                "\'" + ENODEB_NAME + "\'," +
                "\'" + EARFCN + "\'," +
                "\'" + PCI + "\'," +
                "\'" + PSS + "\'," +
                "\'" + SSS + "\'," +
                "\'" + TAC + "\'," +
                "\'" + VENDOR + "\'," +
                "\'" + LONGITUDE + "\'," +
                "\'" + LATITUDE + "\'," +
                "\'" + STYLE + "\'," +
                "\'" + AZIMUTH + "\'," +
                "\'" + HEIGHT + "\'," +
                "\'" + ELECTTILT + "\'," +
                "\'" + MECHTILT + "\'," +
                "\'" + TOTLETILT + "\')" ;

    }

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

    public Integer getENODEBID() {
        return ENODEBID;
    }

    public void setENODEBID(Integer ENODEBID) {
        this.ENODEBID = ENODEBID;
    }

    public String getENODEB_NAME() {
        return ENODEB_NAME;
    }

    public void setENODEB_NAME(String ENODEB_NAME) {
        this.ENODEB_NAME = ENODEB_NAME;
    }

    public Integer getEARFCN() {
        return EARFCN;
    }

    public void setEARFCN(Integer EARFCN) {
        this.EARFCN = EARFCN;
    }

    public Integer getPCI() {
        return PCI;
    }

    public void setPCI(Integer PCI) {
        this.PCI = PCI;
    }

    public Integer getPSS() {
        return PSS;
    }

    public void setPSS(Integer PSS) {
        this.PSS = PSS;
    }

    public Integer getSSS() {
        return SSS;
    }

    public void setSSS(Integer SSS) {
        this.SSS = SSS;
    }

    public Integer getTAC() {
        return TAC;
    }

    public void setTAC(Integer TAC) {
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
