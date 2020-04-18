package com.example.roomfindernepal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class roomAdapter extends RecyclerView.Adapter<roomAdapter.MyViewholder> {
    private List<singleModelClass> modelClassList;

    public roomAdapter(List<singleModelClass> modelClassList) {
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public roomAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull roomAdapter.MyViewholder holder, int position) {
        int img = modelClassList.get(position).getImage();
        String type = modelClassList.get(position).getType();
        String detail = modelClassList.get(position).getDetail();
        holder.setData(img, type, detail);

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        private ImageView roomImg;
        private TextView roomType;
        private TextView roomDetails;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            roomImg = itemView.findViewById(R.id.img_id);
            roomType = itemView.findViewById(R.id.roomType_id);
            roomDetails = itemView.findViewById(R.id.detail_id);
        }

        public void setData(int img, String type, String detail) {
            roomImg.setImageResource(img);
            roomType.setText(type);
            roomDetails.setText(detail);
        }
    }
}
