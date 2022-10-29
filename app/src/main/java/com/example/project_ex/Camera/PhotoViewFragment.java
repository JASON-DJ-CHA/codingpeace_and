package com.example.project_ex.Camera;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_ex.R;
import com.example.project_ex.home.HomeFragment;
import com.example.project_ex.home.HomeListVO;


public class PhotoViewFragment extends Fragment{
    ImageView ivPhoto;
    TextView tvPhotoDate,tvDevice,tvTime;
    private HomeListVO vo;

    public PhotoViewFragment(HomeListVO vo){
        this.vo = vo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_view, container, false);

        ivPhoto = view.findViewById(R.id.ivPhoto);
        tvPhotoDate = view.findViewById(R.id.tvPhotoDate);
        tvDevice = view.findViewById(R.id.tvDevice);
        tvTime = view.findViewById(R.id.tvTime);

        ivPhoto.setImageResource(vo.getImgId2());
        tvPhotoDate.setText(vo.getDate());
        tvDevice.setText(vo.getModelDesignation());
        tvTime.setText(vo.getTime());
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
                        new HomeFragment() // 내가 fl에 넣고 싶은 fragment의 객체 (new Fragment1)
                ).commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }




}