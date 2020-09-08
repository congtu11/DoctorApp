package com.example.doctormedicineapp.MainActiviti;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doctormedicineapp.R;
import com.example.doctormedicineapp.model.BookCallModel;
import com.example.doctormedicineapp.model.TicketModel;
import com.example.doctormedicineapp.network.ApiService;
import com.example.doctormedicineapp.network.RetrofitBuilder;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailNotification extends AppCompatActivity {
    private TextView tv_time;
    private TextView tv_date;
    private TextView tv_fullname;
    private TextView tv_age;
    private TextView tv_sex;
    private TextView tv_phone;

    private  int id_ticket;
    private  int id_videocall;
    ApiService service;
    public static final String TAG=" LOG";
    private Button btn_confirm;
    private int id_dtnot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        id_ticket = intent.getIntExtra("id_ticket",0);
        id_videocall= intent.getIntExtra("id_videocall",0);
        id_dtnot = intent.getIntExtra("id_dtnot",0);
        if (id_ticket != 0 && id_videocall ==0 ) {
            setContentView(R.layout.activity_detail_notification);
            tv_date = findViewById(R.id.tv_date_notd);
            tv_time = findViewById(R.id.tv_time_notd);
            tv_fullname = findViewById(R.id.tv_fullname_notd);
            tv_age= findViewById(R.id.tv_age_notd);
            tv_sex= findViewById(R.id.tv_sex_notd);
            tv_phone= findViewById(R.id.tv_phone_notd);
            service = RetrofitBuilder.createService(ApiService.class);
            Call<List<TicketModel>> call = service.getTicket(id_ticket);
            call.enqueue(new Callback<List<TicketModel>>() {
                @Override
                public void onResponse(Call<List<TicketModel>> call, Response<List<TicketModel>> response) {
                    if (response.isSuccessful()) {
                        List<TicketModel> list = response.body();
                        for (TicketModel data:list) {
                            tv_date.setText(data.getDate());
                            tv_time.setText(data.getTime());
                            tv_fullname.setText(data.getFullname());
                            tv_sex.setText(data.getSex());
                            tv_age.setText(data.getAge()+"");
                            tv_phone.setText(data.getPhone()+"");
                        }
                    }

                }

                @Override
                public void onFailure(Call<List<TicketModel>> call, Throwable t) {

                }
            });
            btn_confirm = findViewById(R.id.btn_confirm);
            btn_confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "ID NOT"+id_dtnot);
                    Log.d(TAG, "ID Ticket"+id_ticket);
                    Call<String> call1 = service.confirmticket(id_ticket,id_dtnot);
                    call1.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            if (response.isSuccessful()) {
                                Toast.makeText(DetailNotification.this, "Xác nhận thành công ", Toast.LENGTH_SHORT).show();
                                Intent intent1 = new Intent(DetailNotification.this,LoadNavi.class);
                                startActivity(intent1);
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.d(TAG, "onFailure: "+t.getMessage());
                        }
                    });
                }
            });
        }
        else if (id_ticket == 0 && id_videocall !=0) {
            Log.d(TAG, "ID VIDEO CALL"+ id_videocall);
            setContentView(R.layout.notification_detail_callvideo);
            tv_date = findViewById(R.id.tv_date_not_video);
            tv_time = findViewById(R.id.tv_time_not_video);
            service = RetrofitBuilder.createService(ApiService.class);
            btn_confirm=findViewById(R.id.btn_confirms);
            Call<List<BookCallModel>> call = service.getbookvideocall(id_videocall);
            call.enqueue(new Callback<List<BookCallModel>>() {
                @Override
                public void onResponse(Call<List<BookCallModel>> call, Response<List<BookCallModel>> response) {
                    if (response.isSuccessful()) {
                        List<BookCallModel> list = response.body();
                        for (BookCallModel data:list) {
                            tv_date.setText(data.getDate());
                            tv_time.setText(data.getTime());
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<BookCallModel>> call, Throwable t) {
                    Log.d(TAG, "onFailure: "+ t.getMessage());
                }
            });
btn_confirm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String codecall= getAlphaNumericString(5);
        Log.d(TAG, "Code call"+codecall);
        Call<String> call1 = service.confirmcall(id_videocall,codecall,id_dtnot);
        call1.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(DetailNotification.this, "Xác nhận thành công ", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(DetailNotification.this,LoadNavi.class);
                    startActivity(intent1);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
});
        }


    }
  public   static String getAlphaNumericString(int n)
    {

        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString
                = new String(array, Charset.forName("UTF-8"));

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();

        // remove all spacial char
        String  AlphaNumericString
                = randomString
                .replaceAll("[^A-Za-z0-9]", "");

        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < AlphaNumericString.length(); k++) {

            if (Character.isLetter(AlphaNumericString.charAt(k))
                    && (n > 0)
                    || Character.isDigit(AlphaNumericString.charAt(k))
                    && (n > 0)) {

                r.append(AlphaNumericString.charAt(k));
                n--;
            }
        }

        // return the resultant string
        return r.toString();
    }
}
