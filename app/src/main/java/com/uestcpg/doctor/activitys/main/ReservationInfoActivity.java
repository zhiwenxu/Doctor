package com.uestcpg.doctor.activitys.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.okhttp.Request;
import com.uestcpg.doctor.R;
import com.uestcpg.doctor.app.AppStatus;
import com.uestcpg.doctor.app.BaseActivity;
import com.uestcpg.doctor.beans.RespondBean;
import com.uestcpg.doctor.network.APPUrl;
import com.uestcpg.doctor.network.GsonHelper;
import com.uestcpg.doctor.network.OkHttpCallBack;
import com.uestcpg.doctor.network.OkHttpManager;
import com.uestcpg.doctor.utils.ParamUtil;
import com.uestcpg.doctor.utils.StringUtil;
import com.uestcpg.doctor.utils.T;


import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by poplx on 2017/7/19.
 */

public class ReservationInfoActivity extends BaseActivity implements View.OnClickListener {


    @InjectView(R.id.reservation_confirm_btn)
    Button Reservation_confirm_Btn;
    @InjectView(R.id.reservation_name)
    TextView Reservation_Name;
    @InjectView(R.id.reservation_sex)
    TextView Reservation_Sex;
    @InjectView(R.id.reservation_old)
    TextView Reservation_Old;
    @InjectView(R.id.reservation_career)
    TextView Reservation_Career;
    @InjectView(R.id.reservation_height)
    TextView Reservation_Height;
    @InjectView(R.id.reservation_weight)
    TextView Reservation_Weight;
    @InjectView(R.id.reservation_current_symptom)
    TextView Reservation_Current_Symptom;
    @InjectView(R.id.reservation_begin_sick_time)
    TextView Reservation_Begin_Sick_Time;
    @InjectView(R.id.reservation_taken_treatment)
    TextView Reservation_Taken_Treatment;
    @InjectView(R.id.reservation_taken_place)
    TextView Reservation_Taken_Place;
    @InjectView(R.id.reservation_doctor_suggest)
    TextView Reservation_Doctor_Suggest;

    private String Rname;
    private String Rsex;
    private String Rold;
    private String Rcareer;
    private String Rheight;
    private String Rweight;
    private String Rcurrent_symptom;
    private String Rbegin_sick_time;
    private String Rtaken_treatment;
    private String Rtaken_place;
    private String Rdoctor_suggest;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_info);
        init();
    }
    private void init(){

        initTitle();
        setCenterTv("病历详情");

        Rname = getIntent().getStringExtra("name");
        Rsex = getIntent().getStringExtra("sex");
        Rold = getIntent().getStringExtra("old");
        Rcareer = getIntent().getStringExtra("career");
        Rheight = getIntent().getStringExtra("height");
        Rweight = getIntent().getStringExtra("weight");
        Rcurrent_symptom = getIntent().getStringExtra("current_symptom");
        Rbegin_sick_time = getIntent().getStringExtra("begin_sick_time");
        Rtaken_treatment = getIntent().getStringExtra("taken_treatment");
        Rtaken_place = getIntent().getStringExtra("taken_place");
        Rdoctor_suggest = getIntent().getStringExtra("doctor_suggest");
        ButterKnife.inject(this);
        Reservation_confirm_Btn.setOnClickListener(this);
        Reservation();
    }


    private void Reservation(){

        Reservation_Name.setText(StringUtil.null2Empty(Rname));
        Reservation_Sex.setText(StringUtil.null2Empty(Rsex));
        Reservation_Old.setText(StringUtil.null2Empty(Rold));
        Reservation_Career.setText(StringUtil.null2Empty(Rcareer));
        Reservation_Height.setText(StringUtil.null2Empty(Rheight));
        Reservation_Weight.setText(StringUtil.null2Empty(Rweight));
        Reservation_Current_Symptom.setText(StringUtil.null2Empty(Rcurrent_symptom));
        Reservation_Begin_Sick_Time.setText(StringUtil.null2Empty(Rbegin_sick_time));
        Reservation_Taken_Treatment.setText(StringUtil.null2Empty(Rtaken_treatment));
        Reservation_Taken_Place.setText(StringUtil.null2Empty(Rtaken_place));
        Reservation_Doctor_Suggest.setText(StringUtil.null2Empty(Rdoctor_suggest));

    }
    @Override
    public void onClick(View v) {
        if(v == Reservation_confirm_Btn){
            finish();
        }
    }
}
