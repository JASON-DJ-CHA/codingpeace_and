package com.example.project_ex.DateChart;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPager2AdapterDateChartFirstPage extends FragmentStateAdapter{
    private int mdCount;
    private DateChartFragment fa;

    public ViewPager2AdapterDateChartFirstPage(DateChartFragment fa, int count) {
        super(fa);
        this.fa = fa;
        this.mdCount = count;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);

        if(index==0) return new SubChartFragment1(fa);
        else if(index==1) return new SubChartFragment2();
        else return new SubChartFragment3();
     }

    @Override
    public int getItemCount() {
        return mdCount;
    }

    public int getRealPosition(int position){
        return position % mdCount;
    }
}


