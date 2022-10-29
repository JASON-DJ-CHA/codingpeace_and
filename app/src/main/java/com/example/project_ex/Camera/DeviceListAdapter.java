package com.example.project_ex.Camera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_ex.MainActivity;
import com.example.project_ex.R;

import java.util.ArrayList;

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.ViewHolder> {
    private ArrayList<DeviceVO> arrayList;
    private Context context;

    public DeviceListAdapter(ArrayList<DeviceVO> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public DeviceListAdapter(Context context, ArrayList<DeviceVO> deviceData) {
        this.arrayList = deviceData;
        this.context = context;
    }

    @NonNull
    @Override
    public DeviceListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DeviceListAdapter.ViewHolder holder, int position) {
        holder.tvDeviceDesignation.setText(arrayList.get(position).getTvDeviceDesignation());
        holder.tvDeviceName.setText(arrayList.get(position).getTvDeviceName());
        holder.tvDeviceDate.setText(arrayList.get(position).getTvDeviceDate());
        holder.tvDeviceType.setText(arrayList.get(position).getTvDeviceType());
        holder.imgDeviceId.setImageResource(arrayList.get(position).getImgDeviceID());
        holder.btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean i = true;
                if (i == true){
                    holder.btnOn.setText("ON");
                    i = false;
                }else if(i==false) {
                    holder.btnOn.setText("OFF");
                    i = true;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected ImageView imgDeviceId;
        protected TextView tvDeviceDesignation;
        protected TextView tvDeviceName;
        protected TextView tvDeviceDate;
        protected TextView tvDeviceType;
        protected Button btnOn;
        protected Button btnOff;

        public ViewHolder(View view) {
            super(view);
            this.imgDeviceId = (ImageView) view.findViewById(R.id.imgDevice);
            this.tvDeviceDesignation = (TextView) view.findViewById(R.id.tvDeviceDesignation);
            this.tvDeviceName = (TextView) view.findViewById(R.id.tvDeviceName);
            this.tvDeviceDate = (TextView) view.findViewById(R.id.tvDeviceDate);
            this.tvDeviceType = (TextView) view.findViewById(R.id.tvDeviceType);
            this.btnOn = (Button) view.findViewById(R.id.btnOn);
            this.btnOff = (Button) view.findViewById(R.id.btnOn);

        }
    }
}
