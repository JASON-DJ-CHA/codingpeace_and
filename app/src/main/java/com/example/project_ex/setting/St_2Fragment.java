package com.example.project_ex.setting;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project_ex.R;

// 어플설정
public class St_2Fragment extends Fragment {
    Button btnSt_Decre,btnSt_Incre,btnSt_md;
    TextView textView7,textView6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_st_2, container, false);

        btnSt_Incre = view.findViewById(R.id.btnSt_Incre);
        btnSt_Decre = view.findViewById(R.id.btnSt_Decre);
        btnSt_md = view.findViewById(R.id.btnSt_md);
        textView7 = view.findViewById(R.id.textView7);
        textView6 = view.findViewById(R.id.textView6);

        btnSt_Incre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView6.setTextSize(20);
                textView7.setTextSize(30);
            }
        });

        btnSt_md.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView6.setTextSize(14);
                textView7.setTextSize(24);
            }
        });

        btnSt_Decre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView6.setTextSize(10);
                textView7.setTextSize(14);
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.fl, // fragment가 들어갈 위치 : fl
                        new SettingFragment() // 내가 fl에 넣고 싶은 fragment의 객체 (new Fragment1)
                ).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }
}