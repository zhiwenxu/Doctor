package com.uestcpg.doctor.Class;

/**
 * Created by poplx on 2017/7/10.
 */

public class Order {
    private String name;
    private String iconUrl;
    private String dateTime;
    private String IsAccept;
    private String sickPhone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getIsAccept() {
        return IsAccept;
    }

    public void setIsAccept(String isAccept) {
        IsAccept = isAccept;
    }

    public String getSickPhone() {
        return sickPhone;
    }

    public void setSickPhone(String sickPhone) {
        this.sickPhone = sickPhone;
    }
}
