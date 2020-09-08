package com.example.doctormedicineapp.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.doctormedicineapp.MainActiviti.LoadNavi;
import com.example.doctormedicineapp.R;
import com.example.doctormedicineapp.entities.AccessToken;
import com.example.doctormedicineapp.entities.IDUser;
import com.example.doctormedicineapp.network.ApiService;
import com.example.doctormedicineapp.network.RetrofitBuilder;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText tilEmail;
    EditText tilPassword;
    Button btn_login;
    ApiService service;
    TokenManager tokenManager;
    AwesomeValidation validator;
    Call<AccessToken> call;
    IDUerManager idmanager;
    public static final String TAG ="A";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        service = RetrofitBuilder.createService(ApiService.class);
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefs",MODE_PRIVATE));
        idmanager =IDUerManager.getInstance(getSharedPreferences("prefdoc",MODE_PRIVATE));
        validator = new AwesomeValidation(ValidationStyle.TEXT_INPUT_LAYOUT);

    btn_login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            Log.d(TAG, "onClick:Chay ham nay  ");
            Login();
        }
    });

    }
    public void findView()
    {
        tilEmail = findViewById(R.id.til_email_login);
        tilPassword= findViewById(R.id.til_password_login);
        btn_login = findViewById(R.id.btn_login);

    }
    public void Login() {
        Log.d(TAG, "Login: Chay cai nay chua");
        String email = tilEmail.getText().toString();
        String password = tilPassword.getText().toString();
        tilEmail.setError(null);
        tilPassword.setError(null);
        validator.clear();
        call = service.login(email,password);
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
            if (response.isSuccessful()) {
                Log.w("B","Ngon rồi "+response);
                tokenManager.saveToken(response.body());
                checkDoctor();
            }
            else{
                Log.d(TAG, "Loi"+response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Log.w("a", "LỖi con mẹ nó rồi ");
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (call!=null) {
            call.cancel();
            call=null;
        }
    }

    @Override
    public void onBackPressed() {


    }
    public void checkDoctor() {
        Log.d(TAG, "checkDoctor: Chay cai nay truoc hay cai kia truoc v");
        tokenManager = TokenManager.getInstance(getSharedPreferences("prefss",MODE_PRIVATE));
        service = RetrofitBuilder.createServiceAuth(ApiService.class,tokenManager);
        Call<IDUser> call = service.checkDoctor();
      call.enqueue(new Callback<IDUser>() {
          @Override
          public void onResponse(Call<IDUser> call, Response<IDUser> response) {
              if (response.code()==200) {
                  idmanager.saveID(response.body());
                  Intent intent = new Intent(LoginActivity.this, LoadNavi.class);
                  startActivity(intent);
              }
              if (response.code()==404) {
                  Toast.makeText(LoginActivity.this, "Thông tin sai", Toast.LENGTH_SHORT).show();
              }
          }

          @Override
          public void onFailure(Call<IDUser> call, Throwable t) {

          }
      });
    }
}
