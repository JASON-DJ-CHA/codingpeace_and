package com.example.project_ex.Camera;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_ex.MainActivity;
import com.example.project_ex.R;

import java.util.ArrayList;

public class RecordListAdapter extends RecyclerView.Adapter<RecordListAdapter.ViewHolder> {

    private  ArrayList<CameraVO> arrayList;
    private Context context;


    public RecordListAdapter(Context context, ArrayList<CameraVO> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecordListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder( RecordListAdapter.ViewHolder holder, int position) {

        int pos = position;

        holder.imgId.setImageResource(arrayList.get(position).getImgId());
        holder.modelDesignation.setText(arrayList.get(position).getModelDesignation());
        holder.modelName.setText(arrayList.get(position).getModelName());
        holder.tvDate.setText(arrayList.get(position).getDate());
//        holder.btnLook.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((MainActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fl,new PhotoViewFragment(arrayList.get(pos))).commit();
//
//            }
//        });


    }

    @Override
    public int getItemCount() {
                return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imgId;
        protected TextView modelDesignation;
        protected TextView modelName;
        protected TextView tvDate;
        protected Button btnLook;


        public ViewHolder( View view) {
            super(view);
            this.imgId = (ImageView) view.findViewById(R.id.imgCapture);
            this.modelDesignation = (TextView) view.findViewById(R.id.tvModelDesignation);
            this.modelName = (TextView) view.findViewById(R.id.tvModelName);
            this.btnLook = (Button) view.findViewById(R.id.btnLook);
            this.tvDate = (TextView) view.findViewById(R.id.tvDate);
        }
    }
}
