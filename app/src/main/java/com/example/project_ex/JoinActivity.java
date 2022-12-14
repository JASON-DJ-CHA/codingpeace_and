package com.example.project_ex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class JoinActivity extends AppCompatActivity {

    EditText etId2, etPw2, etPw3, etAdr;
    Button btnComp, btnIdCheck;
    String ID, ID2, pw1, pw2;
    TextView tvPasswordCheck;

    ArrayList<String> id_list = new ArrayList<>();
    DBHelper helper;
    SQLiteControl sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        tvPasswordCheck = findViewById(R.id.tvPasswordCheck);
        etId2=findViewById(R.id.etId2);
        etPw2=findViewById(R.id.etPw2);
        etPw3=findViewById(R.id.etPw3);
        etAdr=findViewById(R.id.etAdr);
        btnComp=findViewById(R.id.btnComp);
        btnIdCheck = findViewById(R.id.btnIdCheck);

        btnComp.setClickable(false);

        helper = new DBHelper(
                JoinActivity.this,
                "User.db",
                null,
                1
        );
        sqlite = new SQLiteControl(helper);

        checkPW();

        checkID();

        joinCom();
//        btnComp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {

//            }
//        });

    }
    private void joinCom() {
        btnComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id= etId2.getText().toString();
                String pw= etPw2.getText().toString();
                String adr = etAdr.getText().toString();
                sqlite.insert(id,pw,adr);
            }
        });
    }
    private void checkID() {
        btnIdCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID = "admin";
                Toast.makeText(JoinActivity.this,etId2.getText().toString() , Toast.LENGTH_SHORT).show();
                ID2 = etId2.getText().toString();
                if(ID.equals(ID2)){
                    AlertDialog.Builder myAlertBuilder =
                            new AlertDialog.Builder(JoinActivity.this);
                    // alert??? title??? Messege ??????
                    myAlertBuilder.setTitle("????????? ????????????");
                    myAlertBuilder.setMessage("?????? ???????????? ??????????????????.");
                    // ?????? ?????? (Ok ????????? Cancle ?????? )
                    myAlertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    // Alert??? ??????????????? ???????????? ?????????(show??? ???????????? Alert??? ?????????)
                    myAlertBuilder.show();

                }else{
                    AlertDialog.Builder myAlertBuilder =
                            new AlertDialog.Builder(JoinActivity.this);
                    // alert??? title??? Messege ??????
                    myAlertBuilder.setTitle("????????? ????????????");
                    myAlertBuilder.setMessage("?????????????????????.");
                    // ?????? ?????? (Ok ????????? Cancle ?????? )
                    myAlertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    // Alert??? ??????????????? ???????????? ?????????(show??? ???????????? Alert??? ?????????)
                    myAlertBuilder.show();

                }

            }
        });
    }

    private void checkPW() {
        etPw3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                pw1 = etPw2.getText().toString();
                pw2 = etPw3.getText().toString();
                    if(pw2.equals(pw1)){
                        tvPasswordCheck.setText("?????????????????? ???????????????.");
                        tvPasswordCheck.setTextColor(Color.BLUE);
                        btnComp.setClickable(true);

                    }else {
                        tvPasswordCheck.setText("?????????????????? ?????? ????????????.");
                        tvPasswordCheck.setTextColor(Color.RED);
                    }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                pw1 = etPw2.getText().toString();
                pw2 = etPw3.getText().toString();

                    if(pw2.equals(pw1)){
                        tvPasswordCheck.setText("???  ??????????????? ???????????????.");
                        tvPasswordCheck.setTextColor(Color.BLUE);
                        btnComp.setClickable(true);

                    }else {
                        tvPasswordCheck.setText("???  ??????????????? ?????? ????????????.");
                        tvPasswordCheck.setTextColor(Color.RED);
                    }
            }
        });
    }
}