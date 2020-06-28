package com.example.back.model;

import java.io.Serializable;
import java.util.Objects;

public class C2IKey implements Serializable {

    private String SCELL;
    private String NCELL;

    @Override
    public String toString() {
        return "C2IKey{" +
                "SCELL='" + SCELL + '\'' +
                ", NCELL='" + NCELL + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C2IKey c2IKey = (C2IKey) o;
        return Objects.equals(SCELL, c2IKey.SCELL) &&
                Objects.equals(NCELL, c2IKey.NCELL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SCELL, NCELL);
    }

    public String getSCELL() {
        return SCELL;
    }

    public void setSCELL(String SCELL) {
        this.SCELL = SCELL;
    }

    public String getNCELL() {
        return NCELL;
    }

    public void setNCELL(String NCELL) {
        this.NCELL = NCELL;
    }
}
