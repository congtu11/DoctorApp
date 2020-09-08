package com.example.doctormedicineapp.network;


import com.example.doctormedicineapp.entities.AccessToken;
import com.example.doctormedicineapp.entities.IDUser;
import com.example.doctormedicineapp.model.BookCallModel;
import com.example.doctormedicineapp.model.NotificationDoctorModel;
import com.example.doctormedicineapp.model.NotificationModel;
import com.example.doctormedicineapp.model.TicketModel;
import com.example.doctormedicineapp.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    // Register User
    @POST("register")
    @FormUrlEncoded
    Call<AccessToken> register(@Field("name") String name, @Field("email") String email, @Field("password") String password, @Field("c_password") String c_password);
    //Login User
    @POST("login")
    @FormUrlEncoded
    Call<AccessToken> login(@Field("username") String username, @Field("password") String password);
    //Refresh code but not use now
    @POST("refresh")
    @FormUrlEncoded
    Call<AccessToken> refresh(@Field("refresh_token") String refreshToken);
    @POST("logout")
    Call<String> logout();
    //Book ticket
    @POST("bookticket")
    @FormUrlEncoded
    Call<String> bookticket(@Field("id_doctor") int id_doctor, @Field("fullname") String fullname, @Field("age") int age, @Field("sex") String sex, @Field("phone") int phone, @Field("date") String date, @Field("time") String time);
    //Get Notification
    @GET("getNotification")
    Call<List<NotificationModel>> getNotification();
    //Get all medicine
    @GET("getAllMedicine")
    @POST("addtocart")
    @FormUrlEncoded
    Call<String> addtocart(@Field("id_medicine") int id_medicine, @Field("amount") int amount);
    @GET("getInforUser")
    Call<List<UserModel>> getInfoUser();
    @POST("bookvideocall")
    @FormUrlEncoded
    Call<String> bookvideocall(@Field("id_doctor") int id_doctor, @Field("date") String date, @Field("time") String time);
      @GET("checkDoctor")
        Call<IDUser> checkDoctor();
      @GET("getNotificationDoctor/{id}")
Call<List<NotificationDoctorModel>> getNotificationDoctor(@Path("id") int id_doctor);
      @GET("getBookticket/{id}")
    Call<List<TicketModel>> getTicket(@Path("id") int id_ticket);
      @GET("getBookvideocall/{id}")
    Call<List<BookCallModel>> getbookvideocall(@Path("id") int id_videocall);
      @POST("confirmNotCall")
      @FormUrlEncoded
    Call<String> confirmcall(@Field("id_videocall") int id_videocall,@Field("codecall") String codecall,@Field("id_dtnot") int id_dtnot);
      @GET("getBookticketbyIddoctor/{id}")
    Call<List<BookCallModel>> getBookvideocalls(@Path("id") int id_doctor);
    @POST("confirmticket")
    @FormUrlEncoded
    Call<String> confirmticket(@Field("id_ticket") int id_ticket,@Field("id_dtnot") int id_dtnot);
    @GET("checkLogins")
    Call<String> checkLogins();



}
