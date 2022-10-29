package com.example.project_ex;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {



    EditText etId1, etPw1;
    Button btnLogin,btnJoin;
    String Id,Pw, adminId,adminPw;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        etId1 = findViewById(R.id.etId1);
        etPw1 = findViewById(R.id.etPw1);
        btnLogin = findViewById(R.id.btnLogin);
        btnJoin = findViewById(R.id.btnJoin);

        if (requestQueue ==null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Id = etId1.getText().toString();
                Pw = etPw1.getText().toString();
                adminId = "admin";
                adminPw = "admin";
//                hideKeyboard();
                String url = "http://127.0.0.1:3000/login";

                StringRequest request =new StringRequest(
                        Request.Method.POST,
                        url,
                        new com.android.volley.Response.Listener<String>() {

                            @Override
                            public void onResponse(String response) {
//                                 요청했을 때 성공 시
                                Toast.makeText(LoginActivity.this, "연결성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
//                                if(!response.equals("로그인 실패")){
//                                    try {
//                                        JSONObject jsonObject = new JSONObject(response);
//                                        JSONArray jsonArray = jsonObject.getJSONArray("data");
//                                        if(jsonArray.length() != 0){
//                                            for(int i = 0; i<jsonArray.length(); i++){
//                                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//                                                String  id = jsonObject1.getString("id");
//                                                String  pw = jsonObject1.getString("pw");
//
//
//                                            }
//                                        }
//                                    }
//                                }




                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // 요청했을 때 실패 시
                                Toast.makeText(LoginActivity.this, "연결실패", Toast.LENGTH_SHORT).show();

                            }
                        }
                )
                {
                    // getParams():Map라는 메서드 오버라이딩 : ctrl +o
                    // 자바 key로 바꾼사람들은 alt +insert

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        // Map : dictionarty, json과 비슷한 key, value로 이루어져 있음
                        Map<String,String> params = new HashMap<>();
                        params.put("user_id",Id);
                        params.put("user_pw",Pw);


                        return params;
                    }
                };
                //StringRequest이 끝나는 괄호

                //로그인 정보 미입력 시
//                if (Id.trim().length() == 0 || Pw.trim().length() == 0 || Id == null || Pw == null) {
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                    builder.setTitle("알림")
//                            .setMessage("로그인 정보를 입력바랍니다.")
//                            .setPositiveButton("확인", null)
//                            .create()
//                            .show();
//                    AlertDialog alertDialog = builder.create();
//                    alertDialog.show();
//
//                } else if (Id.equals("admin")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
//                } else {
//                    AlertDialog.Builder myAlertBuilder =
//                            new AlertDialog.Builder(LoginActivity.this);
//                    // alert의 title과 Messege 세팅
//                    myAlertBuilder.setTitle("계정을 확인해주세요");
//                    myAlertBuilder.setMessage("아이디 혹은 비밀번호를 확인해주세요");
//                    // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
//                    myAlertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                        }
//                    });
//                    //Alert를 생성해주고 보여주는 메소드(show를 선언해야 Alert가 생성됨)
//                    myAlertBuilder.show();
//                }
            }

        });

    }


//
//    private void hideKeyboard()
//    {
//        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(etId1.getWindowToken(), 0);
//        imm.hideSoftInputFromWindow(etPw1.getWindowToken(), 0);
//    }


    //화면 터치 시 키보드 내려감
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev){
        View focusView = getCurrentFocus();
        if (focusView != null) {
            Rect rect = new Rect();
            focusView.getGlobalVisibleRect(rect);
            int x = (int) ev.getX(), y = (int) ev.getY();
            if (!rect.contains(x, y)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null)
                    imm.hideSoftInputFromWindow(focusView.getWindowToken(), 0);
                focusView.clearFocus();
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}