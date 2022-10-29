package com.example.project_ex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.project_ex.Camera.DeviceListFragment;
import com.example.project_ex.home.HomeFragment;
import com.example.project_ex.setting.SettingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnv;
    FrameLayout fl;


    // 알림 서비스


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "tjdrufz님 환영합니다.", Toast.LENGTH_SHORT).show();

        bnv = findViewById(R.id.bnv);
        fl = findViewById(R.id.fl);

        onClickShowAlert();

        // 네비게이션 바 중앙 디폴트
        bnv.getMenu().findItem(R.id.tab1).setChecked(true);


        // 첫번째 페이지 설정해놓기.
        getSupportFragmentManager().beginTransaction().replace(
                R.id.fl,
                new HomeFragment()
        ).commit();


        // 네비 연결 설정
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case  R.id.tab1:

                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.fl,
                                new HomeFragment()
                        ).commit();


                        break;



                    case  R.id.tab4:
                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.fl,
                                new DeviceListFragment()
                        ).commit();
                        break;
                    case  R.id.tab5:
                        getSupportFragmentManager().beginTransaction().replace(
                                R.id.fl,
                                new SettingFragment()
                        ).commit();
                        break;
                }

                return true;
            }
        });

    }
    public void onClickShowAlert() {
        AlertDialog.Builder myAlertBuilder =
                new AlertDialog.Builder(MainActivity.this);
        // alert의 title과 Messege 세팅
        myAlertBuilder.setTitle("새로운 알림!");
        myAlertBuilder.setMessage("확인하지 않은 6건의 알림이 있습니다.");
        // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
        myAlertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        // Alert를 생성해주고 보여주는 메소드(show를 선언해야 Alert가 생성됨)
        myAlertBuilder.show();

    }


}