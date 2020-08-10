package com.example.back.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "tbMROData")
@IdClass(value = MRODataKey.class)
public class MROData {

    @Id
    @Column(name = "time_stamp")
    private String TimeStamp;

    @Id
    @Column(name = "serving_sector")
    private String ServingSector;

    @Id
    @Column(name = "interfering_sector")
    private String InterferingSector;

    @Column(name = "lte_scrsrp")
    private Float LteScRSRP;

    @Column(name = "lte_ncrsrp")
    private Float LteNcRSRP;

    @Column(name = "lte_nc_earfcn")
    private Integer LteNcEarfcn;

    @Column(name = "lte_nc_pci")
    private Integer LteNcPci;

    public static String toKeys() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        s.append("time_stamp").append(",");
        s.append("serving_sector").append(",");
        s.append("interfering_sector").append(",");
        s.append("lte_scrsrp").append(",");
        s.append("lte_ncrsrp").append(",");
        s.append("lte_nc_earfcn").append(",");
        s.append("lte_nc_pci").append(")");
        return s.toString();
    }

    public String toMsg() {
        return "(\'" + TimeStamp + "\'," +
                "\'" + ServingSector + "\'," +
                "\'" + InterferingSector + "\'," +
                "\'" + LteScRSRP + "\'," +
                "\'" + LteNcRSRP + "\'," +
                "\'" + LteNcEarfcn + "\'," +
                "\'" + LteNcPci + "\')";
    }

    @Override
    public String toString() {
        return "MROData{" +
                "TimeStamp=" + TimeStamp +
                ", ServingSector='" + ServingSector + '\'' +
                ", InterferingSector='" + InterferingSector + '\'' +
                ", LteScRSRP=" + LteScRSRP +
                ", LteNcRSRP=" + LteNcRSRP +
                ", LteNcEarfcn=" + LteNcEarfcn +
                ", LteNcPci=" + LteNcPci +
                '}';
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getServingSector() {
        return ServingSector;
    }

    public void setServingSector(String servingSector) {
        ServingSector = servingSector;
    }

    public String getInterferingSector() {
        return InterferingSector;
    }

    public void setInterferingSector(String interferingSector) {
        InterferingSector = interferingSector;
    }

    public Float getLteScRSRP() {
        return LteScRSRP;
    }

    public void setLteScRSRP(Float lteScRSRP) {
        LteScRSRP = lteScRSRP;
    }

    public Float getLteNcRSRP() {
        return LteNcRSRP;
    }

    public void setLteNcRSRP(Float lteNcRSRP) {
        LteNcRSRP = lteNcRSRP;
    }

    public Integer getLteNcEarfcn() {
        return LteNcEarfcn;
    }

    public void setLteNcEarfcn(Integer lteNcEarfcn) {
        LteNcEarfcn = lteNcEarfcn;
    }

    public Integer getLteNcPci() {
        return LteNcPci;
    }

    public void setLteNcPci(Integer lteNcPci) {
        LteNcPci = lteNcPci;
    }
}
