package com.example.project_ex.Camera;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.project_ex.R;

import java.util.ArrayList;

public class DeviceListFragment extends Fragment {
    private ArrayList<DeviceVO> deviceData;
    private RecyclerView rvDevice;
    private DeviceListAdapter deviceListAdapter ;
    private LinearLayoutManager linearLayoutManager;

    private ImageView ivAdd;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult( String key,  Bundle bundle) {
                // We use a String here, but any type that can be put in a Bundle is supported
                String result = bundle.getString("bundleKey");
                // Do something with the result...
            }
        });

        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(
//                        R.id.fl, // fragment가 들어갈 위치 : fl
//                        new DeviceFragment() // 내가 fl에 넣고 싶은 fragment의 객체 (new Fragment1)
//                ).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup viewGroup =(ViewGroup) inflater.inflate(R.layout.fragment_device_list, container, false);
        rvDevice = viewGroup.findViewById(R.id.rvDevice);
        linearLayoutManager = new LinearLayoutManager(getContext());
        rvDevice.setLayoutManager(linearLayoutManager);

        ivAdd = viewGroup.findViewById(R.id.ivAdd);
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(
                        R.id.fl, // fragment가 들어갈 위치 : fl
                       new AddDeviceFragment() // 내가 fl에 넣고 싶은 fragment의 객체 (new Fragment1)
               ).commit();
            }
        });

        deviceData = new ArrayList<>();

        deviceData.add(new DeviceVO(R.drawable.colorcamera,"동쪽 카메라","CP_Camera","2022-09-04","카메라"));
        deviceData.add(new DeviceVO(R.drawable.colorcamera2,"북동쪽 카메라","CP_Camera","2022-09-04","카메라"));
        deviceData.add(new DeviceVO(R.drawable.device1,"전기 목책기","CP_EF","2022-09-05","퇴치기"));
        deviceData.add(new DeviceVO(R.drawable.device2,"광원 퇴치기","CP_L","2022-09-04","퇴치기"));
        deviceData.add(new DeviceVO(R.drawable.device3,"음향장치","CP_S","2022-09-04","퇴치기"));


        deviceListAdapter = new DeviceListAdapter(getContext(),deviceData);
        rvDevice.setAdapter(deviceListAdapter);
        return viewGroup;
    }


}