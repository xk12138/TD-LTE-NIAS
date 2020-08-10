package com.example.back.model;

import javax.persistence.*;


@Entity
@Table(name = "tbC2Inew")
@IdClass(value = C2InewKey.class)

public class C2Inew {

    @Id
    @Column(name = "SCELL")
    private String SCELL;

    @Id
    @Column(name = "NCELL")
    private String NCELL;

    @Column(name = "C2I_Mean")
    private Float C2I_Mean;

    @Column(name = "C2I_Std")
    private Float C2I_Std;


    @Column(name = "PrC2I9")
    private Float PrC2I9;

    @Column(name = "PrbABS6")
    private Float PrbABS6;

    @Override
    public String toString() {
        return "C2Inew{" +
                ", SCELL='" + SCELL + '\'' +
                ", NCELL='" + NCELL + '\'' +
                ", C2I_Mean=" + C2I_Mean +
                ", C2I_Std=" + C2I_Std +
                ", PrC2I9=" + PrC2I9 +
                ", PrbABS6=" + PrbABS6 +
                '}';
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

    public Float getC2I_Mean() {
        return C2I_Mean;
    }

    public void setC2I_Mean(Float c2I_Mean) {
        C2I_Mean = c2I_Mean;
    }

    public Float getC2I_Std() {
        return C2I_Std;
    }

    public void setC2I_Std(Float c2I_Std) {
        C2I_Std = c2I_Std;
    }

    public Float getPrC2I9() {
        return PrC2I9;
    }

    public void setPrC2I9(Float prC2I9) {
        PrC2I9 = prC2I9;
    }

    public Float getPrbABS6() {
        return PrbABS6;
    }

    public void setPrbABS6(Float prbABS6) {
        PrbABS6 = prbABS6;
    }
}

