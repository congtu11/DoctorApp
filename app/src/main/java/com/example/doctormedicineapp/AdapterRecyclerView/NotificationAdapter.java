package com.example.doctormedicineapp.AdapterRecyclerView;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctormedicineapp.MainActiviti.DetailNotification;
import com.example.doctormedicineapp.R;
import com.example.doctormedicineapp.model.NotificationDoctorModel;
import com.example.doctormedicineapp.model.NotificationModel;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.DataViewHolder> {
    private  Context context;
    private List<NotificationDoctorModel> data;
    public static final String TAG=" LOG";
    public NotificationAdapter(Context context, List<NotificationDoctorModel> data){
        this.context=context;
        this.data=data;
    }
    @NonNull
    @Override
    public NotificationAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new NotificationAdapter.DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.DataViewHolder holder, int position) {
            holder.content.setText(data.get(position).getContent());
            holder.tv_time.setText(data.get(position).getCreated_at());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (data.get(position).getId_ticket() == 0) {
                        Log.d(TAG, "ID VIDEOCALL " + data.get(position).getId_videocall());
                        Intent intent = new Intent(context, DetailNotification.class);
                        intent.putExtra("id_videocall", data.get(position).getId_videocall());
                        intent.putExtra("id_dtnot",data.get(position).getId());
                        context.startActivity(intent);
                    }
                    if (data.get(position).getId_videocall() == 0) {
                        Log.d(TAG, "ID TICKET" + data.get(position).getId_ticket());
                        Intent intent = new Intent(context, DetailNotification.class);
                        intent.putExtra("id_ticket", data.get(position).getId_ticket());
                        intent.putExtra("id_dtnot",data.get(position).getId());
                        context.startActivity(intent);
                    }
                }
            });
        Log.d("TG", "onBindViewHolder: "+data.size());
    }

    @Override
    public int getItemCount() {
        return data== null ? 0 : data.size();
    }
    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private TextView content;
        private TextView tv_time;
        private CardView cardView;


        public DataViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.img_iconNot);
            content = itemView.findViewById(R.id.tv_content);
            tv_time = itemView.findViewById(R.id.tv_timeNot);
            cardView= itemView.findViewById(R.id.cv_not);

        }
    }
    public void show() {
        Log.d("TAG", "show: "+ data.toString() );

    }
}
