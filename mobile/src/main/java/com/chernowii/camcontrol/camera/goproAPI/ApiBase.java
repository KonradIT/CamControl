package com.chernowii.camcontrol.camera.goproAPI;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBase {


    public static class Info{
        public static final String VendorSite="http://gopro.com";
    }

    private static Retrofit GoProMainAPI = null;
    private static Retrofit GoProMediaAPI = null;

    static Retrofit getMainClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        GoProMainAPI = new Retrofit.Builder()
                .baseUrl("http://10.5.5.9")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return GoProMainAPI;
    }

    static Retrofit getMediaClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        GoProMediaAPI = new Retrofit.Builder()
                .baseUrl("http://10.5.5.9:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return GoProMediaAPI;
    }
}
