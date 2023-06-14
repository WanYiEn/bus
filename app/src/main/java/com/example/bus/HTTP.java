package com.example.bus;

import android.app.VoiceInteractor;

import org.json.JSONObject;

import java.io.IOException;

import javax.security.auth.callback.Callback;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HTTP {
    public void get(String url, CallBack cb){
        OkHttpClient ok=new OkHttpClient();
        Request request=new Request.Builder().url(url).get().build();
        Call call= ok.newCall(request);
         try {
                Response response=call.execute();
                cb.success(response.body().string());
         } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public  void post(String url, JSONObject jsonObject,CallBack cb){
        OkHttpClient ok = new OkHttpClient();
        RequestBody requestBody=RequestBody.create(MediaType.parse("application/json"),jsonObject.toString());
        Request request=new  Request.Builder().url(url).post(requestBody).build();
        Call call= ok.newCall(request);

        try {
           Response response = call.execute();
            cb.success(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    interface  CallBack{
        void success(String s);
        void  failure(String s);
    }
    }


