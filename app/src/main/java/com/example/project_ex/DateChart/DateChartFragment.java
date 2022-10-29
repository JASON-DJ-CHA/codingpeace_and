package com.example.project_ex.DateChart;

import android.content.Context;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_ex.R;
import com.example.project_ex.home.HomeFragment;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DateChartFragment extends Fragment {
    private Button btnOpenCalendar;
    private  ViewPager2 vpChart;
    private TabLayout tlDWM;
    private ViewGroup viewGroup;
    private int num_page = 3;
    private FragmentStateAdapter pagerAdapter;
    private TextView tvChartDate;
    Date date1,date2;
    String dateString1,dateString2 ;
    Bundle dBundle;

    // 어뎁터 및 화면 구성
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_chart,container,false);

        tvChartDate = viewGroup.findViewById(R.id.tvChartDate);
        tlDWM = viewGroup.findViewById(R.id.tlDWM);
        vpChart = viewGroup.findViewById(R.id.vpChart);
        btnOpenCalendar = viewGroup.findViewById(R.id.btnOpenCalendar);

        // 뷰페이저 2 연결 코드 끝

        //기간 선택하는 메서드
            btnOpenCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();
                builder.setTitleText("날짜를 선택해주세요");
//                builder.set
                builder.setSelection(Pair.create(MaterialDatePicker
                        .thisMonthInUtcMilliseconds(),MaterialDatePicker
                        .todayInUtcMilliseconds()));

                MaterialDatePicker materialDatePicker = builder.build();
                materialDatePicker.show(getChildFragmentManager(), "날짜 선택");

                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long,Long>>() {
                    @Override
                    public void onPositiveButtonClick(Pair<Long,Long> selection) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM월 dd일");
                        date1 = new Date();
                        date2 = new Date();

                        date1.setTime(selection.first);
                        date2.setTime(selection.second);

                        dateString1 = simpleDateFormat.format(date1);
                        dateString2 = simpleDateFormat.format(date2);

                        tvChartDate.setText(dateString1 + "~"+dateString2);

                        dBundle = new Bundle();
                        dBundle.putString("startDate", dateString1);
                        dBundle.putString("endDate",dateString2);

                        // 뷰페이저 2 연결
                        pagerAdapter = new ViewPager2AdapterDateChartFirstPage(DateChartFragment.this,num_page);
                        vpChart.setAdapter(pagerAdapter);


                        // tabLayout 설정 코드
                        new TabLayoutMediator(tlDWM, vpChart, new TabLayoutMediator.TabConfigurationStrategy() {
                            @Override
                            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                                switch (position){
                                    case 0:{
                                        tab.setText("일간보기");
//                        for(int i = 0; i<)
                                        break;
                                    }
                                    case 1:{
                                        tab.setText("주간보기");
                                        break;
                                    }
                                    case 2:{
                                        tab.setText("월간보기");
                                        break;
                                    }
                                }
                            }
                        }).attach();
                        // tabLayout 설정 종료

                    }
                });

                }
            });





        return viewGroup;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.fl, // fragment가 들어갈 위치 : fl
                        new HomeFragment() // 내가 fl에 넣고 싶은 fragment의 객체 (new Fragment1)
                ).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }


}