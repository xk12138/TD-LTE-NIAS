package com.example.back.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class KPIKey implements Serializable {

    private Date 起始时间;
    private String 小区名;

    @Override
    public String toString() {
        return "KPIKey{" +
                "起始时间=" + 起始时间 +
                ", 小区名='" + 小区名 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KPIKey kpiKey = (KPIKey) o;
        return Objects.equals(起始时间, kpiKey.起始时间) &&
                Objects.equals(小区名, kpiKey.小区名);
    }

    @Override
    public int hashCode() {
        return Objects.hash(起始时间, 小区名);
    }

    public Date get起始时间() {
        return 起始时间;
    }

    public void set起始时间(Date 起始时间) {
        this.起始时间 = 起始时间;
    }

    public String get小区名() {
        return 小区名;
    }

    public void set小区名(String 小区名) {
        this.小区名 = 小区名;
    }
}
