package com.example.back.model;

import javax.persistence.*;

@Entity
@Table(name = "tbC2I")
@IdClass(value = C2IKey.class)
public class C2I {

    @Column(name = "CITY")
    private String CITY;

    @Id
    @Column(name = "SCELL")
    private String SCELL;

    @Id
    @Column(name = "NCELL")
    private String NCELL;

    @Column(name = "PrC2I9")
    private Float PrC2I9;

    @Column(name = "C2I_Mean")
    private Float C2I_Mean;

    @Column(name = "std")
    private Float std;

    @Column(name = "SampleCount")
    private Float SampleCount;

    @Column(name = "WeightedC2I")
    private Float WeightedC2I;

    @Override
    public String toString() {
        return "C2I{" +
                "CITY='" + CITY + '\'' +
                ", SCELL='" + SCELL + '\'' +
                ", NCELL='" + NCELL + '\'' +
                ", PrC2I9=" + PrC2I9 +
                ", C2I_Mean=" + C2I_Mean +
                ", std=" + std +
                ", SampleCount=" + SampleCount +
                ", WeightedC2I=" + WeightedC2I +
                '}';
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
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

    public Float getPrC2I9() {
        return PrC2I9;
    }

    public void setPrC2I9(Float prC2I9) {
        PrC2I9 = prC2I9;
    }

    public Float getC2I_Mean() {
        return C2I_Mean;
    }

    public void setC2I_Mean(Float c2I_Mean) {
        C2I_Mean = c2I_Mean;
    }

    public Float getStd() {
        return std;
    }

    public void setStd(Float std) {
        this.std = std;
    }

    public Float getSampleCount() {
        return SampleCount;
    }

    public void setSampleCount(Float sampleCount) {
        SampleCount = sampleCount;
    }

    public Float getWeightedC2I() {
        return WeightedC2I;
    }

    public void setWeightedC2I(Float weightedC2I) {
        WeightedC2I = weightedC2I;
    }
}
