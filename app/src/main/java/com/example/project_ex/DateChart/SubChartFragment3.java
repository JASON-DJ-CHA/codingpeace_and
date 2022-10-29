package com.example.project_ex.DateChart;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_ex.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class SubChartFragment3 extends Fragment {
    private ViewGroup viewGroup;
    LineChart lineChart3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_sub_chart3,container,false);

        //초기화
        lineChart3 = viewGroup.findViewById(R.id.chart);

        //1. 데이터셋에 데이터 넣기
        LineDataSet lineDataSet1 = new LineDataSet(data1(), "고라니");
        LineDataSet lineDataSet2 = new LineDataSet(data2(), "멧돼지");

        //2. 리스트에 데이터셋 추가
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);

        lineDataSet1.setColor(Color.RED);
        lineDataSet2.setColor(Color.BLUE);

        chartStyle();

        //3. 라인데이터에 리스트 추가
        LineData data = new LineData(dataSets);

        //4. 차트에 라인데이터 추가
        lineChart3.setData(data);

        //5. 차트 초기화
        lineChart3.invalidate();

        return viewGroup;
    }

    private void chartStyle() {
        /* 차트 스타일 */
        //배경색상
        lineChart3.setBackgroundColor(Color.WHITE);

        // 차트 데이터 없음 표시
        lineChart3.setNoDataText("날짜를 선택해 주세요");


        YAxis yAxis; // Y축 불러오기
        XAxis xAxis = lineChart3.getXAxis(); // x축 불러오기
        Legend legend = lineChart3.getLegend(); //범례 불러오기

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        // y축 오른쪽 비활성화
        lineChart3.getAxisRight().setEnabled(false);

        // 차트 데이터 없음 텍스트 색상 변경
        lineChart3.setNoDataTextColor(Color.RED);

        //범례 글자 크기
        legend.setTextSize(15);
        //범례 라인으로 바꾸기
        legend.setForm(Legend.LegendForm.LINE);

        // 범례 그래프 내부에 그리기
        legend.setDrawInside(true);
        // 격자 그리드 적용
        lineChart3.setDrawGridBackground(true);

        //차트 외곽선 진하게 적용
        lineChart3.setDrawBorders(true);

        // Description표시 제거
        lineChart3.getDescription().setEnabled(false);

        //손가락으로 확대가능
        lineChart3.setPinchZoom(true);

        // 차트 패딩
        lineChart3.setPadding(30,30,30,30);

        // 차트 라인 선 굵기
        lineChart3.setMinimumWidth(4);
    }

    // 차트 ArrayList<Entry>는 깃허브에서 가지고온것으로 선택할것
    private ArrayList<Entry> data1(){
        ArrayList<Entry> dataList = new ArrayList<>();
        dataList.add(new Entry(1,10));
        dataList.add(new Entry(2,20));
        dataList.add(new Entry(3,30));
        dataList.add(new Entry(4,20));
        dataList.add(new Entry(5,10));

        return dataList;
    }

    private ArrayList<Entry> data2(){
        ArrayList<Entry> dataList = new ArrayList<>();
        dataList.add(new Entry(1,15));
        dataList.add(new Entry(2,11));
        dataList.add(new Entry(3,10));
        dataList.add(new Entry(4,00));
        dataList.add(new Entry(5,10));

        return dataList;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}