package com.example.back.model;

import java.util.Date;
import java.util.Objects;

public class CellKey {
    private String SECTOR_ID;

    @Override
    public String toString() {
        return "KPIKey{" +
                "小区ID=" + SECTOR_ID+
                 '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CellKey cellKey = (CellKey) o;
        return Objects.equals(SECTOR_ID, cellKey.SECTOR_ID);

    }

    @Override
    public int hashCode() {
        return Objects.hash(SECTOR_ID);
    }

    public String getSectorid() {
        return SECTOR_ID;
    }

    public void setSectorid(String s) {
        this.SECTOR_ID = s;
    }


}
