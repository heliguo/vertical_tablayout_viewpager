package com.example.vertical_tablayout_viewpager.verticaltablayout.verticaltabpager;


/**
 * author:lgh on 2020-04-20 13:56
 */
public class VerticalBean {

    private String sjmc;
    private String cph;
    private String sfz;
    private String sjh;
    private String cydw;
    private String hpmc;

    private String clxx;
    private int indexTd;
    private int indexCph;

    public VerticalBean(String sjmc, String cph, String sfz, String sjh, String cydw, String hpmc, String clxx, int indexTd, int indexCph) {
        this.sjmc = sjmc;
        this.cph = cph;
        this.sfz = sfz;
        this.sjh = sjh;
        this.cydw = cydw;
        this.hpmc = hpmc;
        this.clxx = clxx;
        this.indexTd = indexTd;
        this.indexCph = indexCph;
    }

    public String getSjmc() {
        return sjmc;
    }

    public void setSjmc(String sjmc) {
        this.sjmc = sjmc;
    }

    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }

    public String getSfz() {
        return sfz;
    }

    public void setSfz(String sfz) {
        this.sfz = sfz;
    }

    public String getSjh() {
        return sjh;
    }

    public void setSjh(String sjh) {
        this.sjh = sjh;
    }

    public String getCydw() {
        return cydw;
    }

    public void setCydw(String cydw) {
        this.cydw = cydw;
    }

    public String getHpmc() {
        return hpmc;
    }

    public void setHpmc(String hpmc) {
        this.hpmc = hpmc;
    }

    public String getClxx() {
        return clxx;
    }

    public void setClxx(String clxx) {
        this.clxx = clxx;
    }

    public int getIndexTd() {
        return indexTd;
    }

    public void setIndexTd(int indexTd) {
        this.indexTd = indexTd;
    }

    public int getIndexCph() {
        return indexCph;
    }

    public void setIndexCph(int indexCph) {
        this.indexCph = indexCph;
    }
}
