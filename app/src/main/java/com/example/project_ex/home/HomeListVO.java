package com.example.project_ex.home;

public class HomeListVO {
    private String modelDesignation;
    private String Date;
    private String Time;

    public String getTime() {        return Time;    }

    public void setTime(String time) {        Time = time;    }

    private int imgId;
    private int imgId2;


    public int getImgId2() {
        return imgId2;
    }

    public void setImgId2(int imgId2) {
        this.imgId2 = imgId2;
    }

    public String getModelDesignation() {
        return modelDesignation;
    }

    public void setModelDesignation(String modelDesignation) {
        this.modelDesignation = modelDesignation;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public HomeListVO(String modelDesignation, String date, String time, int imgId) {
        this.modelDesignation = modelDesignation;
        Date = date;
        Time = time;
        this.imgId = imgId;
    }
    public HomeListVO(String modelDesignation, String date, String time, int imgId, int imgId2) {
        this.modelDesignation = modelDesignation;
        Date = date;
        Time = time;
        this.imgId = imgId;
        this.imgId2 = imgId2;
    }
}
