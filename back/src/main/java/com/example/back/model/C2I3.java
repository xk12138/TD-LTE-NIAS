package com.example.back.model;

import javax.persistence.*;

@Entity
@Table(name = "tbC2I3")
@IdClass(value = C2I3Key.class)
public class C2I3 {

    @Id
    @Column(name = "CELL1")
    private String CELL1;

    @Id
    @Column(name = "CELL2")
    private String CELL2;

    @Id
    @Column(name = "CELL3")
    private String CELL3;

    @Override
    public String toString() {
        return "C2I3{" +
                ", CELL1='" + CELL1 + '\'' +
                ", CELL2='" + CELL2 + '\'' +
                ", CELL3='" + CELL3 + '\'' +
                '}';
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
