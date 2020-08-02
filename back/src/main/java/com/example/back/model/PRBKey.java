package com.example.back.model;

import java.io.Serializable;
import java.util.Objects;

public class PRBKey implements Serializable {

    private String 起始时间;
    private String 小区名;

    @Override
    public String toString() {
        return "PRBKey{" +
                "起始时间='" + 起始时间 + '\'' +
                ", 小区名='" + 小区名 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PRBKey prbKey = (PRBKey) o;
        return Objects.equals(起始时间, prbKey.起始时间) &&
                Objects.equals(小区名, prbKey.小区名);
    }

    @Override
    public int hashCode() {
        return Objects.hash(起始时间, 小区名);
    }

    public String get起始时间() {
        return 起始时间;
    }

    public void set起始时间(String 起始时间) {
        this.起始时间 = 起始时间;
    }

    public String get小区名() {
        return 小区名;
    }

    public void set小区名(String 小区名) {
        this.小区名 = 小区名;
    }
}
