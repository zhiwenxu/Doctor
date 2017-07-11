package com.uestcpg.doctor.beans;

import com.uestcpg.doctor.Class.Sick;

import java.util.List;

/**
 * Created by dmsoft on 2017/7/8.
 */
public class GetSickListBean {
    private String Success;
    private String Message;
    private List<Sick> sicks;

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

    public List<Sick> getSicks() {
        return sicks;
    }

    public void setSicks(List<Sick> sicks) {
        this.sicks = sicks;
    }
}
