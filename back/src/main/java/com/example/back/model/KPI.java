package com.example.back.model;

import javax.persistence.*;

@Entity
@Table(name = "tbKPI")
public class KPI {

    @Column(name = "起始时间")
    private String 起始时间;

    @Column(name = "周期")
    private Integer 周期;

    @Column(name = "网元名称")
    private String 网元名称;

    @Column(name = "小区")
    private String 小区;

    @Id
    @Column(name = "小区名")
    private String 小区名;

    @Column(name = "RRC连接建立完成次数")
    private Integer RRC连接建立完成次数;

    @Column(name = "RRC连接请求次数_包括重发")
    private Integer RRC连接请求次数_包括重发;

    @Column(name = "RRC建立成功率qf")
    private Float RRC建立成功率qf;

    @Column(name = "E_RAB建立成功总次数")
    private Integer E_RAB建立成功总次数;

    @Column(name = "E_RAB建立尝试总次数")
    private Integer E_RAB建立尝试总次数;

    @Column(name = "E_RAB建立成功率")
    private Float E_RAB建立成功率;

    @Column(name = "eNodeB触发的E_RAB异常释放总次数")
    private Integer eNodeB触发的E_RAB异常释放总次数;

    @Column(name = "小区切换出E_RAB异常释放总次数")
    private Integer 小区切换出E_RAB异常释放总次数;

    @Column(name = "E_RAB掉线率_新")
    private Float E_RAB掉线率_新;

    @Column(name = "无线接通率ay")
    private Float 无线接通率ay;

    @Column(name = "eNodeB发起的S1_RESET导致的UE_Context释放次数")
    private Integer eNodeB发起的S1_RESET导致的UE_Context释放次数;

    @Column(name = "UE_Context异常释放次数")
    private Integer UE_Context异常释放次数;

    @Column(name = "UE_Context建立成功总次数")
    private Integer UE_Context建立成功总次数;

    @Column(name = "无线掉线率")
    private Float 无线掉线率;

    @Column(name = "eNodeB内异频切换出成功次数")
    private Integer eNodeB内异频切换出成功次数;

    @Column(name = "eNodeB内异频切换出尝试次数")
    private Integer eNodeB内异频切换出尝试次数;

    @Column(name = "eNodeB内同频切换出成功次数")
    private Integer eNodeB内同频切换出成功次数;

    @Column(name = "eNodeB内同频切换出尝试次数")
    private Integer eNodeB内同频切换出尝试次数;

    @Column(name = "eNodeB间异频切换出成功次数")
    private Integer eNodeB间异频切换出成功次数;

    @Column(name = "eNodeB间异频切换出尝试次数")
    private Integer eNodeB间异频切换出尝试次数;

    @Column(name = "eNodeB间同频切换出成功次数")
    private Integer eNodeB间同频切换出成功次数;

    @Column(name = "eNodeB间同频切换出尝试次数")
    private Integer eNodeB间同频切换出尝试次数;

    @Column(name = "eNB内切换成功率")
    private Float eNB内切换成功率;

    @Column(name = "eNB间切换成功率")
    private Float eNB间切换成功率;

    @Column(name = "同频切换成功率zsp")
    private Float 同频切换成功率zsp;

    @Column(name = "异频切换成功率zsp")
    private Float 异频切换成功率zsp;

    @Column(name = "切换成功率")
    private Float 切换成功率;

    @Column(name = "小区PDCP层所接收到的上行数据的总吞吐量")
    private Integer 小区PDCP层所接收到的上行数据的总吞吐量;

    @Column(name = "小区PDCP层所发送的下行数据的总吞吐量")
    private Integer 小区PDCP层所发送的下行数据的总吞吐量;

    @Column(name = "RRC重建请求次数")
    private Integer RRC重建请求次数;

    @Column(name = "RRC连接重建比率")
    private Float RRC连接重建比率;

    @Column(name = "通过重建回源小区的eNodeB间同频切换出执行成功次数")
    private Integer 通过重建回源小区的eNodeB间同频切换出执行成功次数;

    @Column(name = "通过重建回源小区的eNodeB间异频切换出执行成功次数")
    private Integer 通过重建回源小区的eNodeB间异频切换出执行成功次数;

    @Column(name = "通过重建回源小区的eNodeB内同频切换出执行成功次数")
    private Integer 通过重建回源小区的eNodeB内同频切换出执行成功次数;

    @Column(name = "通过重建回源小区的eNodeB内异频切换出执行成功次数")
    private Integer 通过重建回源小区的eNodeB内异频切换出执行成功次数;

    @Column(name = "eNB内切换出成功次数")
    private Integer eNB内切换出成功次数;

    @Column(name = "eNB内切换出请求次数")
    private Integer eNB内切换出请求次数;

    @Override
    public String toString() {
        return "KPI{" +
                "起始时间='" + 起始时间 + '\'' +
                ", 周期='" + 周期 + '\'' +
                ", 网元名称='" + 网元名称 + '\'' +
                ", 小区=" + 小区 +
                ", 小区名=" + 小区名 +
                ", RRC连接建立完成次数=" + RRC连接建立完成次数 +
                ", RRC连接请求次数_包括重发=" + RRC连接请求次数_包括重发 +
                ", RRC建立成功率qf=" + RRC建立成功率qf +
                ", E_RAB建立成功总次数=" + E_RAB建立成功总次数 +
                ", E_RAB建立尝试总次数=" + E_RAB建立尝试总次数 +
                ", E_RAB建立成功率=" + E_RAB建立成功率 +
                ", eNodeB触发的E_RAB异常释放总次数=" + eNodeB触发的E_RAB异常释放总次数 +
                ", 小区切换出E_RAB异常释放总次数=" + 小区切换出E_RAB异常释放总次数 +
                ", E_RAB掉线率_新=" + E_RAB掉线率_新 +
                ", 无线接通率ay=" + 无线接通率ay +
                ", eNodeB发起的S1_RESET导致的UE_Context释放次数=" + eNodeB发起的S1_RESET导致的UE_Context释放次数 +
                ", UE_Context异常释放次数=" + UE_Context异常释放次数 +
                ", UE_Context建立成功总次数=" + UE_Context建立成功总次数 +
                ", 无线掉线率=" + 无线掉线率 +
                ", eNodeB内异频切换出成功次数=" + eNodeB内异频切换出成功次数 +
                ", eNodeB内异频切换出尝试次数=" + eNodeB内异频切换出尝试次数 +
                ", eNodeB内同频切换出成功次数=" + eNodeB内同频切换出成功次数 +
                ", eNodeB内同频切换出尝试次数=" + eNodeB内同频切换出尝试次数 +
                ", eNodeB间异频切换出成功次数=" + eNodeB间异频切换出成功次数 +
                ", eNodeB间异频切换出尝试次数=" + eNodeB间异频切换出尝试次数 +
                ", eNodeB间同频切换出成功次数=" + eNodeB间同频切换出成功次数 +
                ", eNodeB间同频切换出尝试次数=" + eNodeB间同频切换出尝试次数 +
                ", eNB内切换成功率=" + eNB内切换成功率 +
                ", eNB间切换成功率=" + eNB间切换成功率 +
                ", 同频切换成功率zsp=" + 同频切换成功率zsp +
                ", 异频切换成功率zsp=" + 异频切换成功率zsp +
                ", 切换成功率=" + 切换成功率 +
                ", 小区PDCP层所接收到的上行数据的总吞吐量=" + 小区PDCP层所接收到的上行数据的总吞吐量 +
                ", 小区PDCP层所发送的下行数据的总吞吐量=" + 小区PDCP层所发送的下行数据的总吞吐量 +
                ", RRC重建请求次数=" + RRC重建请求次数 +
                ", RRC连接重建比率=" + RRC连接重建比率 +
                ", 通过重建回源小区的eNodeB间同频切换出执行成功次数=" + 通过重建回源小区的eNodeB间同频切换出执行成功次数 +
                ", 通过重建回源小区的eNodeB间异频切换出执行成功次数=" + 通过重建回源小区的eNodeB间异频切换出执行成功次数 +
                ", 通过重建回源小区的eNodeB内同频切换出执行成功次数=" + 通过重建回源小区的eNodeB内同频切换出执行成功次数 +
                ", 通过重建回源小区的eNodeB内异频切换出执行成功次数=" + 通过重建回源小区的eNodeB内异频切换出执行成功次数 +
                ", eNB内切换出成功次数=" + eNB内切换出成功次数 +
                ", eNB内切换出请求次数=" + eNB内切换出请求次数 +
                '}';
    }

    public String get起始时间() {
        return 起始时间;
    }

    public void set起始时间(String 起始时间) {
        this.起始时间 = 起始时间;
    }

    public Integer get周期() {
        return 周期;
    }

    public void set周期(Integer 周期) {
        this.周期 = 周期;
    }

    public String get网元名称() {
        return 网元名称;
    }

    public void set网元名称(String 网元名称) {
        this.网元名称 = 网元名称;
    }

    public String get小区() {
        return 小区;
    }

    public void set小区(String 小区) {
        this.小区 = 小区;
    }

    public String get小区名() {
        return 小区名;
    }

    public void set小区名(String 小区名) {
        this.小区名 = 小区名;
    }

    public Integer getRRC连接建立完成次数() {
        return RRC连接建立完成次数;
    }

    public void setRRC连接建立完成次数(Integer RRC连接建立完成次数) {
        this.RRC连接建立完成次数 = RRC连接建立完成次数;
    }

    public Integer getRRC连接请求次数_包括重发() {
        return RRC连接请求次数_包括重发;
    }

    public void setRRC连接请求次数_包括重发(Integer RRC连接请求次数_包括重发) {
        this.RRC连接请求次数_包括重发 = RRC连接请求次数_包括重发;
    }

    public Float getRRC建立成功率qf() {
        return RRC建立成功率qf;
    }

    public void setRRC建立成功率qf(Float RRC建立成功率qf) {
        this.RRC建立成功率qf = RRC建立成功率qf;
    }

    public Integer getE_RAB建立成功总次数() {
        return E_RAB建立成功总次数;
    }

    public void setE_RAB建立成功总次数(Integer e_RAB建立成功总次数) {
        E_RAB建立成功总次数 = e_RAB建立成功总次数;
    }

    public Integer getE_RAB建立尝试总次数() {
        return E_RAB建立尝试总次数;
    }

    public void setE_RAB建立尝试总次数(Integer e_RAB建立尝试总次数) {
        E_RAB建立尝试总次数 = e_RAB建立尝试总次数;
    }

    public Float getE_RAB建立成功率() {
        return E_RAB建立成功率;
    }

    public void setE_RAB建立成功率(Float e_RAB建立成功率) {
        E_RAB建立成功率 = e_RAB建立成功率;
    }

    public Integer geteNodeB触发的E_RAB异常释放总次数() {
        return eNodeB触发的E_RAB异常释放总次数;
    }

    public void seteNodeB触发的E_RAB异常释放总次数(Integer eNodeB触发的E_RAB异常释放总次数) {
        this.eNodeB触发的E_RAB异常释放总次数 = eNodeB触发的E_RAB异常释放总次数;
    }

    public Integer get小区切换出E_RAB异常释放总次数() {
        return 小区切换出E_RAB异常释放总次数;
    }

    public void set小区切换出E_RAB异常释放总次数(Integer 小区切换出E_RAB异常释放总次数) {
        this.小区切换出E_RAB异常释放总次数 = 小区切换出E_RAB异常释放总次数;
    }

    public Float getE_RAB掉线率_新() {
        return E_RAB掉线率_新;
    }

    public void setE_RAB掉线率_新(Float e_RAB掉线率_新) {
        E_RAB掉线率_新 = e_RAB掉线率_新;
    }

    public Float get无线接通率ay() {
        return 无线接通率ay;
    }

    public void set无线接通率ay(Float 无线接通率ay) {
        this.无线接通率ay = 无线接通率ay;
    }

    public Integer geteNodeB发起的S1_RESET导致的UE_Context释放次数() {
        return eNodeB发起的S1_RESET导致的UE_Context释放次数;
    }

    public void seteNodeB发起的S1_RESET导致的UE_Context释放次数(Integer eNodeB发起的S1_RESET导致的UE_Context释放次数) {
        this.eNodeB发起的S1_RESET导致的UE_Context释放次数 = eNodeB发起的S1_RESET导致的UE_Context释放次数;
    }

    public Integer getUE_Context异常释放次数() {
        return UE_Context异常释放次数;
    }

    public void setUE_Context异常释放次数(Integer UE_Context异常释放次数) {
        this.UE_Context异常释放次数 = UE_Context异常释放次数;
    }

    public Integer getUE_Context建立成功总次数() {
        return UE_Context建立成功总次数;
    }

    public void setUE_Context建立成功总次数(Integer UE_Context建立成功总次数) {
        this.UE_Context建立成功总次数 = UE_Context建立成功总次数;
    }

    public Float get无线掉线率() {
        return 无线掉线率;
    }

    public void set无线掉线率(Float 无线掉线率) {
        this.无线掉线率 = 无线掉线率;
    }

    public Integer geteNodeB内异频切换出成功次数() {
        return eNodeB内异频切换出成功次数;
    }

    public void seteNodeB内异频切换出成功次数(Integer eNodeB内异频切换出成功次数) {
        this.eNodeB内异频切换出成功次数 = eNodeB内异频切换出成功次数;
    }

    public Integer geteNodeB内异频切换出尝试次数() {
        return eNodeB内异频切换出尝试次数;
    }

    public void seteNodeB内异频切换出尝试次数(Integer eNodeB内异频切换出尝试次数) {
        this.eNodeB内异频切换出尝试次数 = eNodeB内异频切换出尝试次数;
    }

    public Integer geteNodeB内同频切换出成功次数() {
        return eNodeB内同频切换出成功次数;
    }

    public void seteNodeB内同频切换出成功次数(Integer eNodeB内同频切换出成功次数) {
        this.eNodeB内同频切换出成功次数 = eNodeB内同频切换出成功次数;
    }

    public Integer geteNodeB内同频切换出尝试次数() {
        return eNodeB内同频切换出尝试次数;
    }

    public void seteNodeB内同频切换出尝试次数(Integer eNodeB内同频切换出尝试次数) {
        this.eNodeB内同频切换出尝试次数 = eNodeB内同频切换出尝试次数;
    }

    public Integer geteNodeB间异频切换出成功次数() {
        return eNodeB间异频切换出成功次数;
    }

    public void seteNodeB间异频切换出成功次数(Integer eNodeB间异频切换出成功次数) {
        this.eNodeB间异频切换出成功次数 = eNodeB间异频切换出成功次数;
    }

    public Integer geteNodeB间异频切换出尝试次数() {
        return eNodeB间异频切换出尝试次数;
    }

    public void seteNodeB间异频切换出尝试次数(Integer eNodeB间异频切换出尝试次数) {
        this.eNodeB间异频切换出尝试次数 = eNodeB间异频切换出尝试次数;
    }

    public Integer geteNodeB间同频切换出成功次数() {
        return eNodeB间同频切换出成功次数;
    }

    public void seteNodeB间同频切换出成功次数(Integer eNodeB间同频切换出成功次数) {
        this.eNodeB间同频切换出成功次数 = eNodeB间同频切换出成功次数;
    }

    public Integer geteNodeB间同频切换出尝试次数() {
        return eNodeB间同频切换出尝试次数;
    }

    public void seteNodeB间同频切换出尝试次数(Integer eNodeB间同频切换出尝试次数) {
        this.eNodeB间同频切换出尝试次数 = eNodeB间同频切换出尝试次数;
    }

    public Float geteNB内切换成功率() {
        return eNB内切换成功率;
    }

    public void seteNB内切换成功率(Float eNB内切换成功率) {
        this.eNB内切换成功率 = eNB内切换成功率;
    }

    public Float geteNB间切换成功率() {
        return eNB间切换成功率;
    }

    public void seteNB间切换成功率(Float eNB间切换成功率) {
        this.eNB间切换成功率 = eNB间切换成功率;
    }

    public Float get同频切换成功率zsp() {
        return 同频切换成功率zsp;
    }

    public void set同频切换成功率zsp(Float 同频切换成功率zsp) {
        this.同频切换成功率zsp = 同频切换成功率zsp;
    }

    public Float get异频切换成功率zsp() {
        return 异频切换成功率zsp;
    }

    public void set异频切换成功率zsp(Float 异频切换成功率zsp) {
        this.异频切换成功率zsp = 异频切换成功率zsp;
    }

    public Float get切换成功率() {
        return 切换成功率;
    }

    public void set切换成功率(Float 切换成功率) {
        this.切换成功率 = 切换成功率;
    }

    public Integer get小区PDCP层所接收到的上行数据的总吞吐量() {
        return 小区PDCP层所接收到的上行数据的总吞吐量;
    }

    public void set小区PDCP层所接收到的上行数据的总吞吐量(Integer 小区PDCP层所接收到的上行数据的总吞吐量) {
        this.小区PDCP层所接收到的上行数据的总吞吐量 = 小区PDCP层所接收到的上行数据的总吞吐量;
    }

    public Integer get小区PDCP层所发送的下行数据的总吞吐量() {
        return 小区PDCP层所发送的下行数据的总吞吐量;
    }

    public void set小区PDCP层所发送的下行数据的总吞吐量(Integer 小区PDCP层所发送的下行数据的总吞吐量) {
        this.小区PDCP层所发送的下行数据的总吞吐量 = 小区PDCP层所发送的下行数据的总吞吐量;
    }

    public Integer getRRC重建请求次数() {
        return RRC重建请求次数;
    }

    public void setRRC重建请求次数(Integer RRC重建请求次数) {
        this.RRC重建请求次数 = RRC重建请求次数;
    }

    public Float getRRC连接重建比率() {
        return RRC连接重建比率;
    }

    public void setRRC连接重建比率(Float RRC连接重建比率) {
        this.RRC连接重建比率 = RRC连接重建比率;
    }

    public Integer get通过重建回源小区的eNodeB间同频切换出执行成功次数() {
        return 通过重建回源小区的eNodeB间同频切换出执行成功次数;
    }

    public void set通过重建回源小区的eNodeB间同频切换出执行成功次数(Integer 通过重建回源小区的eNodeB间同频切换出执行成功次数) {
        this.通过重建回源小区的eNodeB间同频切换出执行成功次数 = 通过重建回源小区的eNodeB间同频切换出执行成功次数;
    }

    public Integer get通过重建回源小区的eNodeB间异频切换出执行成功次数() {
        return 通过重建回源小区的eNodeB间异频切换出执行成功次数;
    }

    public void set通过重建回源小区的eNodeB间异频切换出执行成功次数(Integer 通过重建回源小区的eNodeB间异频切换出执行成功次数) {
        this.通过重建回源小区的eNodeB间异频切换出执行成功次数 = 通过重建回源小区的eNodeB间异频切换出执行成功次数;
    }

    public Integer get通过重建回源小区的eNodeB内同频切换出执行成功次数() {
        return 通过重建回源小区的eNodeB内同频切换出执行成功次数;
    }

    public void set通过重建回源小区的eNodeB内同频切换出执行成功次数(Integer 通过重建回源小区的eNodeB内同频切换出执行成功次数) {
        this.通过重建回源小区的eNodeB内同频切换出执行成功次数 = 通过重建回源小区的eNodeB内同频切换出执行成功次数;
    }

    public Integer get通过重建回源小区的eNodeB内异频切换出执行成功次数() {
        return 通过重建回源小区的eNodeB内异频切换出执行成功次数;
    }

    public void set通过重建回源小区的eNodeB内异频切换出执行成功次数(Integer 通过重建回源小区的eNodeB内异频切换出执行成功次数) {
        this.通过重建回源小区的eNodeB内异频切换出执行成功次数 = 通过重建回源小区的eNodeB内异频切换出执行成功次数;
    }

    public Integer geteNB内切换出成功次数() {
        return eNB内切换出成功次数;
    }

    public void seteNB内切换出成功次数(Integer eNB内切换出成功次数) {
        this.eNB内切换出成功次数 = eNB内切换出成功次数;
    }

    public Integer geteNB内切换出请求次数() {
        return eNB内切换出请求次数;
    }

    public void seteNB内切换出请求次数(Integer eNB内切换出请求次数) {
        this.eNB内切换出请求次数 = eNB内切换出请求次数;
    }
}
