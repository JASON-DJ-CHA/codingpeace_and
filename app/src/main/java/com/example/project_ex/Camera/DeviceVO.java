package com.example.project_ex.Camera;

import android.widget.Button;

public class DeviceVO {
    private int imgDeviceID;
    private String tvDeviceDesignation;
    private String tvDeviceName;
    private String tvDeviceDate;
    private String tvDeviceType;

    public int getImgDeviceID() {
        return imgDeviceID;
    }

    public void setImgDeviceID(int imgDeviceID) {
        this.imgDeviceID = imgDeviceID;
    }

    public String getTvDeviceDesignation() {
        return tvDeviceDesignation;
    }

    public void setTvDeviceDesignation(String tvDeviceDesignation) {
        this.tvDeviceDesignation = tvDeviceDesignation;
    }

    public String getTvDeviceName() {
        return tvDeviceName;
    }

    public void setTvDeviceName(String tvDeviceName) {
        this.tvDeviceName = tvDeviceName;
    }

    public String getTvDeviceDate() {
        return tvDeviceDate;
    }

    public void setTvDeviceDate(String tvDeviceDate) {
        this.tvDeviceDate = tvDeviceDate;
    }

    public String getTvDeviceType() {
        return tvDeviceType;
    }

    public void setTvDeviceType(String tvDeviceType) {
        this.tvDeviceType = tvDeviceType;
    }

    public DeviceVO(int imgDeviceID, String tvDeviceDesignation, String tvDeviceName, String tvDeviceDate, String tvDeviceType) {
        this.imgDeviceID = imgDeviceID;
        this.tvDeviceDesignation = tvDeviceDesignation;
        this.tvDeviceName = tvDeviceName;
        this.tvDeviceDate = tvDeviceDate;
        this.tvDeviceType = tvDeviceType;
    }
}
