package com.hub.entity;

public class NirdataWithBLOBs extends Nirdata {
    private String data;

    private String mark;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}