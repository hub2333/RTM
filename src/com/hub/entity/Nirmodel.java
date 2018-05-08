package com.hub.entity;

import java.util.Date;

public class Nirmodel {
    private Integer id;

    private String modelname;

    private String interval;

    private Double constant;

    private Date time;

    private String uploader;

    private String coeff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname == null ? null : modelname.trim();
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval == null ? null : interval.trim();
    }

    public Double getConstant() {
        return constant;
    }

    public void setConstant(Double constant) {
        this.constant = constant;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader == null ? null : uploader.trim();
    }

    public String getCoeff() {
        return coeff;
    }

    public void setCoeff(String coeff) {
        this.coeff = coeff == null ? null : coeff.trim();
    }
}