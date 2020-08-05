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
    @Column(name = "TimeStamp")
    private String TimeStamp;

    @Id
    @Column(name = "ServingSector")
    private String ServingSector;

    @Id
    @Column(name = "InterferingSector")
    private String InterferingSector;

    @Column(name = "LteScRSRP")
    private Float LteScRSRP;

    @Column(name = "LteNcRSRP")
    private Float LteNcRSRP;

    @Column(name = "LteNcEarfcn")
    private Integer LteNcEarfcn;

    @Column(name = "LteNcPci")
    private Integer LteNcPci;

    public static String toKeys() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        s.append("TimeStamp").append(",");
        s.append("ServingSector").append(",");
        s.append("InterferingSector").append(",");
        s.append("LteScRSRP").append(",");
        s.append("LteNcRSRP").append(",");
        s.append("LteNcEarfcn").append(",");
        s.append("LteNcPci").append(")");

        return s.toString();
    }

    public String toMsg() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
