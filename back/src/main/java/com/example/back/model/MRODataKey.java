package com.example.back.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class MRODataKey implements Serializable {

    private Date TimeStamp;
    private String ServingSector;
    private String InterferingSector;

    @Override
    public String toString() {
        return "MRODataKey{" +
                "TimeStamp=" + TimeStamp +
                ", ServingSector='" + ServingSector + '\'' +
                ", InterferingSector='" + InterferingSector + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MRODataKey that = (MRODataKey) o;
        return Objects.equals(TimeStamp, that.TimeStamp) &&
                Objects.equals(ServingSector, that.ServingSector) &&
                Objects.equals(InterferingSector, that.InterferingSector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TimeStamp, ServingSector, InterferingSector);
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
}
