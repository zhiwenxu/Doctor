package com.uestcpg.doctor.app;

/**
 * Created by dmsoft on 2017/6/14.
 */

public class AppStatus {
    private static String userid;
    private static String token;
    private static String username;
    private static String rCToken;
    private static String url;
    private static String targetId;

    public static void setUserId(String id){
        userid = id;
    }

    public static void setToken(String t){
        token = t;
    }

    public static void setUsername(String name){
        username = name;
    }


    public static String getUserId(){
        return userid;
    }
    public static String getToken(){
        return token;
    }
    public static String getUsername(){
        return username;
    }

    public static String getrCToken() {
        return rCToken;
    }

    public static void setrCToken(String rCToken) {
        AppStatus.rCToken = rCToken;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        AppStatus.url = url;
    }

    public static String getTargetId() {
        return targetId;
    }

    public static void setTargetId(String targetId) {
        AppStatus.targetId = targetId;
    }
}
