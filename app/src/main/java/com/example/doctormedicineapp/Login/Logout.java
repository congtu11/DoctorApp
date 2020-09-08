package com.example.doctormedicineapp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doctormedicineapp.network.ApiService;
import com.example.doctormedicineapp.network.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Logout extends AppCompatActivity {
    TokenManager tokenManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefss",MODE_PRIVATE));
        ApiService service = RetrofitBuilder.createServiceAuth(ApiService.class, tokenManager);
        Call<String> call = service.logout();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("TAG", "onResponse: Thanh cong");
                tokenManager.deleteToken();
                Intent intent = new Intent(Logout.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("TAG", "onFailure: "+t.getMessage());
            }
        });
    }

}
