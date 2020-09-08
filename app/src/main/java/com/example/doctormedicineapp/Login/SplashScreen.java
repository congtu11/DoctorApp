package com.example.doctormedicineapp.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doctormedicineapp.MainActiviti.LoadNavi;
import com.example.doctormedicineapp.R;
import com.example.doctormedicineapp.network.ApiService;
import com.example.doctormedicineapp.network.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    TokenManager tokenManager;
    ApiService service;
    Boolean checkLogin = true;
    IDUerManager checkDoc;
    public static final String TAG = "A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefss", MODE_PRIVATE));
        checkDoc = IDUerManager.getInstance(getSharedPreferences("prefdoc", MODE_PRIVATE));
        if (tokenManager == null) {
            checkLogin = false;
        } else {
            if (tokenManager.getToken().getAccessToken() == null) {
                checkLogin = false;
            } else {
                if (checkDoc == null) {
                    checkLogin = false;
                } else {
                    if (checkDoc.getID().getID_USER() == 0) {
                        checkLogin = false;
                    } else {
                        checkLogin = true;
                    }
                }
            }

        }
        if (checkLogin==true) {
            Log.d(TAG, "ID: "+ checkDoc.getID().getID_USER());
            Log.d(TAG, "token: " +tokenManager.getToken().getAccessToken());
            Log.d("TAG", "doInBackground: Check serve ");
            service = RetrofitBuilder.createServiceAuth(ApiService.class,tokenManager);
            Call<String> call = service.checkLogins();
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        checkLogin=false;
                        Log.d("TAG", "onResponse: Check thanh cong dang nhap");
                    }
                    else if (response.code()==400) {
                        checkLogin =true;
                        Log.d("TAG", "onResponse: Check thaat bai dang nhap");
                    }
                    else {
                        Log.d("TAG", "onResponse: Loi khi dang nhap");
                    }
                    if (checkLogin==true) {
                        Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
                        startActivity(intent);
                    }
                    else if(checkLogin==false) {

                        Intent intent = new Intent(SplashScreen.this, LoadNavi.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("TAG", "onFailure: Loi dang nhap that bai");
                    Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
                    startActivity(intent);
                }
            });


        }
        else {
            Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
