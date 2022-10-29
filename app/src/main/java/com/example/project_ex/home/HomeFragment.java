package com.example.project_ex.home;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.project_ex.Camera.AddDeviceFragment;
import com.example.project_ex.DateChart.DateChartFragment;
import com.example.project_ex.LiveFragment;
import com.example.project_ex.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class HomeFragment extends Fragment {

    private ArrayList<HomeListVO> hlData;
    private RecyclerView rvRecord;
    private HomeListAdapter homeListAdapter;
    private LinearLayoutManager linearLayoutManager;
    private Switch swSystemState;
    private TextView tvListNum,tvTodayDate;
    private Button btnRecord,btnLiveCheck;
    Date currentTime = Calendar.getInstance().getTime();
    public static String format_yyyyMMdd = "yyyy/MM/dd";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        linearLayoutManager = new LinearLayoutManager(getContext());

        rvRecord = view.findViewById(R.id.rvRecord);
        btnRecord = view.findViewById(R.id.btnRecord);
        btnLiveCheck = view.findViewById(R.id.btnLiveCheck2);
        rvRecord.setLayoutManager(linearLayoutManager);
        swSystemState = view.findViewById(R.id.swSystemState);
        tvListNum = view.findViewById(R.id.tvListNum);

        tvTodayDate = view.findViewById(R.id.tvTodayDate);

        // 오늘 날짜 가져오기
        SimpleDateFormat format = new SimpleDateFormat(format_yyyyMMdd, Locale.getDefault());
        String current = format.format(currentTime);
        tvTodayDate.setText(current);


        hlData = new ArrayList<>();

        hlData.add(new HomeListVO("op748","2022-09-04","14:05:27",R.drawable.wildboar_size,R.drawable.s13));
        hlData.add(new HomeListVO("op248","2022-09-04","14:05:27",R.drawable.waterdeer_size,R.drawable.s12));
        hlData.add(new HomeListVO("op132","2022-09-04","16:05:27",R.drawable.waterdeer_size,R.drawable.imagegorani));
        hlData.add(new HomeListVO("op248","2022-09-04","14:05:27",R.drawable.wildboar_size,R.drawable.s13));
        hlData.add(new HomeListVO("op132","2022-09-08","14:05:27",R.drawable.waterdeer_size,R.drawable.imagegorani));
        hlData.add(new HomeListVO("op132","2022-09-04","14:05:27",R.drawable.waterdeer_size,R.drawable.imagegorani));



        // 출현 횟수 설정
        String dataSize = String.valueOf(hlData.size());
        tvListNum.setText(dataSize);

        homeListAdapter = new HomeListAdapter(hlData, getContext());
        rvRecord.setAdapter(homeListAdapter);
        swSystemState.setChecked(true);
        swSystemState.setText("시스템이 활성화 상태입니다.");
        swSystemState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    swSystemState.setText("시스템이 활성화 상태입니다.");
                }else{
                    swSystemState.setText("시스템이 비활성화 상태입니다.");
                    
                }
                    
            }
        });

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.fl, // fragment가 들어갈 위치 : fl
                        new DateChartFragment() // 내가 fl에 넣고 싶은 fragment의 객체 (new Fragment1)
                ).commit();
            }
        });

        btnLiveCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.fl,
                        new LiveFragment()
                ).commit();
            }
        });
            
        
//        Button btnFirst = view.findViewById(R.id.btnFirst);
//        Button btnSecond = view.findViewById(R.id.btnSecond);
//        ImageView imgAlarmOn = view.findViewById(R.id.imgAlarmOn);
//        int[] firstIcons= {R.drawable.pigsize,R.drawable.wildboar_size,R.drawable.waterdeer_size};
//        int[] firstStrings = {R.string.home_1st_1,R.string.home_1st_2,R.string.home_1st_3};
//        int[] secondIcons = {R.drawable.on_size,R.drawable.off_size};
//        int[] secondStrings = {R.string.home_2nd_2,R.string.home_2nd_1};
//        int[] Alarm = {R.drawable.camera1,R.drawable.camera2};

//        imgAlarmOn.setImageResource(Alarm[0]);
//
//
//        btnFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(i == firstIcons.length-1){
//                    i = 0;
//                }else{
//                    i++;
//                }
//
////                btnFirst.setCompoundDrawables(firstIcons[i],null,null,null);
//
//                btnFirst.setCompoundDrawablesWithIntrinsicBounds(0,firstIcons[i],0,0);
//                btnFirst.setText(firstStrings[i]);
//            }
//        });
//
//        btnSecond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(i == secondIcons.length-1){
//                    i = 0;
//                    imgAlarmOn.setImageResource(Alarm[0]);
//                }else{
//                    i++;
//                    imgAlarmOn.setImageResource(Alarm[1]);
//                }
//                btnSecond.setCompoundDrawablesWithIntrinsicBounds(secondIcons[i],0,0,0);
//                btnSecond.setText(secondStrings[i]);
//
//            }
//        });
//        //기기가 가동중일때
//        if(AlarmNum == 0){
//
//        }else{
//
//        }
        return view;
    }

    // back pressed 기능
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }


}