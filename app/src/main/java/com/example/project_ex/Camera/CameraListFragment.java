package com.example.project_ex.Camera;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.project_ex.R;

import java.util.ArrayList;


public class CameraListFragment extends Fragment {
    private ArrayList<CameraVO> cameraData;
    private RecyclerView rvCameraList;
    private RecordListAdapter cameraListAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public ViewGroup onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup =(ViewGroup) inflater.inflate(R.layout.fragment_record_list, container, false);
        rvCameraList = viewGroup.findViewById(R.id.rvCameraList);
        linearLayoutManager = new LinearLayoutManager(getContext());
        rvCameraList.setLayoutManager(linearLayoutManager);

        cameraData = new ArrayList<>();

        cameraData.add(new CameraVO("외곽 카메라","shmrd1",R.drawable.imagegorani,"2022-09-04"));
        cameraData.add(new CameraVO("외곽 카메라","shmrd1",R.drawable.imagegorani,"2022-09-05"));
        cameraData.add(new CameraVO("외곽 카메라","shmrd1",R.drawable.imagegorani,"2022-09-04"));


        cameraListAdapter = new RecordListAdapter(getContext(),cameraData);
        rvCameraList.setAdapter(cameraListAdapter);
        return viewGroup;
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