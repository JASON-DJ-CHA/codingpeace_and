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
//                                 ???????????? ??? ?????? ???
                                Toast.makeText(LoginActivity.this, "????????????", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
//                                if(!response.equals("????????? ??????")){
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
                                // ???????????? ??? ?????? ???
                                Toast.makeText(LoginActivity.this, "????????????", Toast.LENGTH_SHORT).show();

                            }
                        }
                )
                {
                    // getParams():Map?????? ????????? ??????????????? : ctrl +o
                    // ?????? key??? ?????????????????? alt +insert

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        // Map : dictionarty, json??? ????????? key, value??? ???????????? ??????
                        Map<String,String> params = new HashMap<>();
                        params.put("user_id",Id);
                        params.put("user_pw",Pw);


                        return params;
                    }
                };
                //StringRequest??? ????????? ??????

                //????????? ?????? ????????? ???
//                if (Id.trim().length() == 0 || Pw.trim().length() == 0 || Id == null || Pw == null) {
//
//                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                    builder.setTitle("??????")
//                            .setMessage("????????? ????????? ??????????????????.")
//                            .setPositiveButton("??????", null)
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
//                    // alert??? title??? Messege ??????
//                    myAlertBuilder.setTitle("????????? ??????????????????");
//                    myAlertBuilder.setMessage("????????? ?????? ??????????????? ??????????????????");
//                    // ?????? ?????? (Ok ????????? Cancle ?????? )
//                    myAlertBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                        }
//                    });
//                    //Alert??? ??????????????? ???????????? ?????????(show??? ???????????? Alert??? ?????????)
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


    //?????? ?????? ??? ????????? ?????????
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