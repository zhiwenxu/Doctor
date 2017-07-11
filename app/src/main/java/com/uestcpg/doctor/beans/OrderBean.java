package com.uestcpg.doctor.beans;

import com.uestcpg.doctor.Class.Order;

import java.util.List;

/**
 * Created by dmsoft on 2017/7/6.
 */

public class OrderBean {

    private List<Order> doctorOrders;
    private String Success;
    private String Message;

    public List<Order> getOrders() {
        return doctorOrders;
    }


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
    public void setOrders(List<Order> doctorOrders) {
        this.doctorOrders = doctorOrders;
    }
}
