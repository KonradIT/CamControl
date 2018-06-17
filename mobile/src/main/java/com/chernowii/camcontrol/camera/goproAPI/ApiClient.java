package com.chernowii.camcontrol.camera.goproAPI;

import com.chernowii.camcontrol.camera.goproAPI.model.GoProResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface ApiClient {

    @GET("/gp/gpControl/setting/{param}/{option}")
    Call<GoProResponse> config(@Path("param") String param, @Path("option") String option);

    @GET("/gp/gpControl/command/{param}")
    Call<GoProResponse> command(@Path("param") String param);

    @GET("gp/gpControl/execute/{param}")
    Call<GoProResponse> execute(@Path("param") String param);

}
