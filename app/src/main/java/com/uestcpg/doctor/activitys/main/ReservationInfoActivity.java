package com.uestcpg.doctor.activitys.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    EditText Reservation_Name;
    @InjectView(R.id.reservation_sex)
    EditText Reservation_Sex;
    @InjectView(R.id.reservation_old)
    EditText Reservation_Old;
    @InjectView(R.id.reservation_career)
    EditText Reservation_Career;
    @InjectView(R.id.reservation_height)
    EditText Reservation_Height;
    @InjectView(R.id.reservation_weight)
    EditText Reservation_Weight;
    @InjectView(R.id.reservation_current_symptom)
    EditText Reservation_Current_Symptom;
    @InjectView(R.id.reservation_begin_sick_time)
    EditText Reservation_Begin_Sick_Time;
    @InjectView(R.id.reservation_taken_treatment)
    EditText Reservation_Taken_Treatment;
    @InjectView(R.id.reservation_taken_place)
    EditText Reservation_Taken_Place;
    @InjectView(R.id.reservation_doctor_suggest)
    EditText Reservation_Doctor_Suggest;

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
        Log.i("A123",Rname);
    }


    private void Reservation(){

        Reservation_Name.setText(Rname);
        Reservation_Sex.setText(Rsex);
        Reservation_Old.setText(Rold);
        Reservation_Career.setText(Rcareer);
        Reservation_Height.setText(Rheight);
        Reservation_Weight.setText(Rweight);
        Reservation_Current_Symptom.setText(Rcurrent_symptom);
        Reservation_Begin_Sick_Time.setText(Rbegin_sick_time);
        Reservation_Taken_Treatment.setText(Rtaken_treatment);
        Reservation_Taken_Place.setText(Rtaken_place);
        Reservation_Doctor_Suggest.setText(Rdoctor_suggest);



    }
    @Override
    public void onClick(View v) {
        if(v == Reservation_confirm_Btn){
            finish();
        }
    }
}
