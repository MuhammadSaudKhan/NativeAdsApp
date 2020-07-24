package com.saud.adsapp.Model;

public class AdsModel {
    private String id;
    private String ad_unit_id;

    public AdsModel() {
    }

    public AdsModel(String id, String ad_unit_id) {
        this.id = id;
        this.ad_unit_id = ad_unit_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAd_unit_id() {
        return ad_unit_id;
    }

    public void setAd_unit_id(String ad_unit_id) {
        this.ad_unit_id = ad_unit_id;
    }
}
