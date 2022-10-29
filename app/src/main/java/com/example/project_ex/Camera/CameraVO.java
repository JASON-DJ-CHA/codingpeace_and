package com.example.project_ex.Camera;

public class CameraVO {
    private String modelDesignation;
    private String modelName;
    private String Date;
    private int imgId;

    public String getModelDesignation() {
        return modelDesignation;
    }

    public void setModelDesignation(String modelDesignation) {
        this.modelDesignation = modelDesignation;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getImgId() {
        return imgId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public CameraVO(String modelDesignation, String modelName, int imgId, String Date) {
        this.modelDesignation = modelDesignation;
        this.modelName = modelName;
        this.imgId = imgId;
        this.Date = Date;
    }
}
