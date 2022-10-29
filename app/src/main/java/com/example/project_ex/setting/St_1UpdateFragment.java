package com.example.project_ex.setting;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project_ex.R;

public class St_1UpdateFragment extends Fragment {

    private Button btnSt_UpdateCom;
    private Context context;
    private EditText etChangePw1,etChangePw2,etChangeAdr;
    private TextView tvCheck;
    private String pw1, pw2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_st_1_update, container, false);

        btnSt_UpdateCom=view.findViewById(R.id.btnSt_UpdateCom);
        etChangePw1=view.findViewById(R.id.etChangePw1);
        etChangePw2=view.findViewById(R.id.etChangePw2);
        etChangeAdr=view.findViewById(R.id.etChangeAdr);
        tvCheck=view.findViewById(R.id.tvCheck);
        btnSt_UpdateCom.setClickable(false);


        etChangePw2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pw1 = etChangePw1.getText().toString();
                pw2 = etChangePw2.getText().toString();
                if(pw2.equals(pw1)){
                    tvCheck.setText("●비밀번호가 일치합니다.");
                    tvCheck.setTextColor(Color.BLUE);
//                    btnSt_UpdateCom.setClickable(true);

                }else {
                    tvCheck.setText("●비밀번호가 일치하지 않습니다.");
                    tvCheck.setTextColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                pw1 = etChangePw1.getText().toString();
                pw2 = etChangePw2.getText().toString();
                if(pw2.equals(pw1)){
                    tvCheck.setText("●비밀번호가 일치합니다.");
                    tvCheck.setTextColor(Color.BLUE);
//                    btnSt_UpdateCom.setClickable(true);

                }else {
                    tvCheck.setText("●비밀번호가 하지 않습니다.");
                    tvCheck.setTextColor(Color.RED);
                }
            }
        });
        //Toast 창을 위함
        context = container.getContext();


        // 수정완료 버튼
        btnSt_UpdateCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //수정완료 버튼을 눌렀을시 Toast 창으로 "수정완료 띄우기"
                Toast.makeText(context, "회원정보 수정완료", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.fl, // fragment가 들어갈 위치 : fl
                        new SettingFragment() // 내가 fl에 넣고 싶은 fragment의 객체 (new Fragment1)
                ).commit();
            }
        });

        return  view;
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