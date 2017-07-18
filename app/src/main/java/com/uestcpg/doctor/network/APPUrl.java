package com.uestcpg.doctor.network;

/**
 * Created by xzw on 2017/6/19.
 * 保存应用的所有访问服务器地址
 */

public class APPUrl {
    private static final String SERVER_URL = "http://1750q5u152.iask.in:30038/RemoteDoctorServer/";
    public static final String REGISTER_URL = SERVER_URL+"register";  //注册地址
    public static final String LOGIN_URL = SERVER_URL+"login"; //登录地址
    public static final String GET_SICK_LIST_URL = SERVER_URL+"getSickList";//获取病人列表
    public static final String DOCTORINFO_URL = SERVER_URL+"doctorInfo"; //显示医生资料地址
    public static final String GET_RCTOKEN_URL = SERVER_URL+"GetRCToken";//获取融云token
    public static final String SICK_LIST_URL = SERVER_URL+"getSickList";//获得病人列表
    public static final String SICK_INFO_URL = SERVER_URL+"sickInfo";//获得病人信息
    public static final String SET_DOCTOR_URL = SERVER_URL+"setDoctorInfo";//设置病人信息
    public static final String GET_DOCTOR_INFO_URL = SERVER_URL+"getDoctorInfo";//获取医生信息
    public static final String ORDER_YY_URL = SERVER_URL+"orderYy";//发起预约
    public static final String GET_OREDER_URL = SERVER_URL+"sickOrder";//获取预约信息
    public static final String CHECK_ORDER_URL = SERVER_URL+"sickCheckOrder";//获取预约信息
    public static final String DOCTOR_ORDER_URL = SERVER_URL+"doctorOrder";//获取预约的病人
    public static final String DOCTOR_SET_ORDER_URL = SERVER_URL+"setOrder";//医生设置预约情况

}
