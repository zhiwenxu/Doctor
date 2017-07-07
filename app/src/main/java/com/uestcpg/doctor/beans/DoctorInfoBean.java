package com.uestcpg.doctor.beans;

/**
 * Created by poplx on 2017/7/7.
 */

public class DoctorInfoBean {
    private String Success;
    private String Message;
    private String Name;
    private String IconUrl;
    private String Appllation;
    private String Major;

    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIconUrl() {
        return IconUrl;
    }

    public void setIconUrl(String iconUrl) {
        IconUrl = iconUrl;
    }

    public String getAppllation() {
        return Appllation;
    }

    public void setAppllation(String appllation) {
        Appllation = appllation;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }
}
