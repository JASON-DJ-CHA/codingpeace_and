package com.example.project_ex.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_ex.Camera.PhotoViewFragment;
import com.example.project_ex.MainActivity;
import com.example.project_ex.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder>{

    private ArrayList<HomeListVO> arrayList;
    private Context context;


    public HomeListAdapter(ArrayList<HomeListVO> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_record,parent,false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeListAdapter.ViewHolder holder, int position) {
        int pos = position;

        holder.imgID.setImageResource(arrayList.get(position).getImgId());
        holder.modelDesignation.setText(arrayList.get(position).getModelDesignation());
        holder.tvDate.setText(arrayList.get(position).getDate());
        holder.btnLook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.fl,new PhotoViewFragment(arrayList.get(pos))).commit();

            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imgID;
        protected ImageView imgID2;
        protected TextView modelDesignation;
        protected TextView tvDate;
        protected TextView tvTime;
        protected Button btnLook;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.imgID = (ImageView) view.findViewById(R.id.imgCapture);
            this.modelDesignation = (TextView) view.findViewById(R.id.tvModelDesignation);
            this.btnLook = (Button) view.findViewById(R.id.btnLook);
            this.tvDate = (TextView) view.findViewById(R.id.tvDate);
        }
    }
}
