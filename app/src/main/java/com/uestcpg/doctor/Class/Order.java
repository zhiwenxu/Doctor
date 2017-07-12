package com.uestcpg.doctor.Class;

/**
 * Created by poplx on 2017/7/10.
 */

public class Order {
    private String name;
    private String iconUrl;
    private String dateTime;
    private String isAccept;
    private String sickPhone;
    private String id;
    private String reason;

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
        return isAccept;
    }

    public void setIsAccept(String isAccept) {
        this.isAccept = isAccept;
    }

    public String getSickPhone() {
        return sickPhone;
    }

    public void setSickPhone(String sickPhone) {
        this.sickPhone = sickPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
