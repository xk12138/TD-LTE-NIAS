package com.example.back.model;

import java.io.Serializable;
import java.util.Objects;

public class C2I3Key implements Serializable {
    private String CELL1;
    private String CELL2;
    private String CELL3;

    @Override
    public String toString() {
        return "C2I3Key{" +
                "CELL1='" + CELL1 + '\'' +
                ", CELL2='" + CELL2 + '\'' +
                ", CELL3='" + CELL3 +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        C2I3Key c2I3Key = (C2I3Key) o;
        return Objects.equals(CELL1, c2I3Key.CELL1) &&
                Objects.equals(CELL2, c2I3Key.CELL2)&&
                Objects.equals(CELL3, c2I3Key.CELL3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CELL1, CELL2,CELL3);
    }

    public String getCELL1() {
        return CELL1;
    }

    public void setCELL1(String CELL1) { this.CELL1 = CELL1; }

    public String getCELL2() {
        return CELL2;
    }

    public void setCELL2(String CELL2) { this.CELL2 = CELL2; }

    public String getCELL3() {
        return CELL3;
    }

    public void setCELL3(String CELL3) { this.CELL3 = CELL3; }


}
