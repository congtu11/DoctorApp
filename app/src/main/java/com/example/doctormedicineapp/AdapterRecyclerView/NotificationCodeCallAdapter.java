package com.example.doctormedicineapp.AdapterRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctormedicineapp.R;
import com.example.doctormedicineapp.model.BookCallModel;

import java.util.List;

public class NotificationCodeCallAdapter extends RecyclerView.Adapter<NotificationCodeCallAdapter.DataViewHolder> {
    Context context;
    List<BookCallModel> data;
    private int stt = 0;
    public NotificationCodeCallAdapter(Context context,List<BookCallModel> data){
        this.context=context;
        this.data=data;
    }

    @NonNull
    @Override
    public NotificationCodeCallAdapter.DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_code_call, parent, false);
        return new NotificationCodeCallAdapter.DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationCodeCallAdapter.DataViewHolder holder, int position) {
            //holder.tv_stt.setText(stt);
            holder.tv_date.setText(data.get(position).getDate());
            holder.tv_time.setText(data.get(position).getTime());
            holder.tv_code.setText(data.get(position).getCodecall());
           // stt++;
    }

    @Override
    public int getItemCount() {
        return data== null ? 0 : data.size();
    }
    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_stt;
        private TextView tv_date;
        private TextView tv_time;
        private TextView tv_code;


        public DataViewHolder(View itemView) {
            super(itemView);

            tv_date = itemView.findViewById(R.id.tv_date_c);
            tv_time = itemView.findViewById(R.id.tv_time_c);
            tv_code= itemView.findViewById(R.id.tv_code_c);

        }
    }
}
