package com.example.project_ex.Camera;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.project_ex.R;


public class AddDeviceFragment extends Fragment {

    EditText etInsertDeviceModel,etInsertDeviceName,etMemo;
    RadioGroup rgSelectModel;
    Button btnAdd;
    String deviceDesignation,tvDeviceName,radioResult;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_device, container, false);
        // 기기명칭
        etInsertDeviceModel = view.findViewById(R.id.etInsertDeviceModel);
        deviceDesignation = etInsertDeviceModel.getText().toString();
        // 모델명
        etInsertDeviceName = view.findViewById(R.id.etInsertDeviceName);
        tvDeviceName = etInsertDeviceName.getText().toString();

        etMemo = view.findViewById(R.id.etMemo);

        rgSelectModel = view.findViewById(R.id.rgSelectModel);

        btnAdd = view.findViewById(R.id.btnAdd);

        rgSelectModel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
                switch (checkId){
                    case R.id.rdCamera:
                        radioResult = "카메라";
                        Toast.makeText(getActivity(), radioResult, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdElectricFence:
                        radioResult = "전기울타리";
                        Toast.makeText(getActivity(), radioResult, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdSpeaker:
                        radioResult = "음향";
                        Toast.makeText(getActivity(), radioResult, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rdEtc:
                        radioResult = "기타";
                        Toast.makeText(getActivity(), radioResult, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.fl, // fragment가 들어갈 위치 : fl
                        new DeviceListFragment() // 내가 fl에 넣고 싶은 fragment의 객체 (new Fragment1)
                ).commit();
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
                        new DeviceListFragment() // 내가 fl에 넣고 싶은 fragment의 객체 (new Fragment1)
                ).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }
}