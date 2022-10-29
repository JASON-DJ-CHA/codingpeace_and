package com.example.project_ex.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.project_ex.LoginActivity;
import com.example.project_ex.R;


public class SettingFragment extends Fragment {
    Button btnSt_user, btnSt_app, btnSt_usercom, btnSt_userof, btnSt_userout;

    private  Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_setting,container,false);
        View view2 = inflater.inflate(R.layout.activity_main,container, false);
        FrameLayout fl;
        fl = view2.findViewById(R.id.fl);
        btnSt_user = view.findViewById(R.id.btnSt_user);
        btnSt_app = view.findViewById(R.id.btnSt_app);
        btnSt_usercom = view.findViewById(R.id.btnSt_usercom);
        btnSt_userout = view.findViewById(R.id.btnSt_userout);
        // Toast창을 위함
        context = container.getContext();

        btnSt_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(
                        R.id.fl, new St_1UpdateFragment()
                ).commit();
            }
        });

        // 어플설정 Button -> 해당 fg로 이동
        btnSt_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction().replace(
                        R.id.fl, new St_2Fragment()
                ).commit();
            }
        });
        // 기기문의 버튼을 누르면 alert창 띄우기
        btnSt_usercom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // onVlicShowAlert 메소드 값 넣어서 불러오기
                onClickShowAlert(view);
            }
        });



        // 기기전원 Button -> fg로 이동
//        btnSt_userof.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getParentFragmentManager().beginTransaction().replace(
//                        R.id.fl, new St_4Fragment()
//                ).commit();
//            }
//        });

//      로그아웃버튼 실행시 기존의 기록 삭제이 이후 JoinActivity로 돌아가기
        btnSt_userout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        return view;
    }
    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder =
                new AlertDialog.Builder(getContext());
        // alert의 title과 Messege 세팅
        myAlertBuilder.setTitle("고객문의");
        myAlertBuilder.setMessage("1234@naver.com으로 문의바랍니다 :)");
        // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
        myAlertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        // Alert를 생성해주고 보여주는 메소드(show를 선언해야 Alert가 생성됨)
        myAlertBuilder.show();

    }

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