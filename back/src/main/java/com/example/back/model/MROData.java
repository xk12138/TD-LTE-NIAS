package com.example.back.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbMROData")
@IdClass(value = MRODataKey.class)
public class MROData {

    @Id
    @Column(name = "TimeStamp")
    private Date TimeStamp;

    @Id
    @Column(name = "ServingSector")
    private String ServingSector;

    @Id
    @Column(name = "InterferingSector")
    private String InterferingSector;

    @Column(name = "LteScRSRP")
    private Integer LteScRSRP;

    @Column(name = "LteNcRSRP")
    private Integer LteNcRSRP;

    @Column(name = "LteNcEarfcn")
    private Integer LteNcEarfcn;

    @Column(name = "LteNcPci")
    private Integer LteNcPci;

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

    public Date getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
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

    public Integer getLteScRSRP() {
        return LteScRSRP;
    }

    public void setLteScRSRP(Integer lteScRSRP) {
        LteScRSRP = lteScRSRP;
    }

    public Integer getLteNcRSRP() {
        return LteNcRSRP;
    }

    public void setLteNcRSRP(Integer lteNcRSRP) {
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
