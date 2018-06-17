package com.chernowii.camcontrol.camera.goproAPI;

import com.chernowii.camcontrol.camera.goproAPI.model.GoProResponse;
import com.chernowii.camcontrol.camera.goproAPI.model.media.GoProMediaList;
import com.chernowii.camcontrol.camera.goproAPI.model.media.GoProMetadata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("/gp/gpControl/setting/{param}/{option}")
    Call<GoProResponse> config(@Path("param") String param, @Path("option") String option);

    @GET("/gp/gpControl/command/{param}")
    Call<GoProResponse> command(@Path("param") String param, @Query("p") String option);

    @GET("gp/gpControl/execute/{param}")
    Call<GoProResponse> execute(@Path("param") String param);

    @GET("/gp/gpMediaList")
    Call<GoProMediaList> getMediaList();

    @GET("/gp/getMediaMetadata")
    Call<GoProMetadata> getMediaMetadata(@Query("p") String GoProMedia, @Query("t") String MetadataOption);

    @GET("/gp/getMediaMetadata")
    Call<GoProMetadata> getThumbnail(@Query("p") String GoProMedia);
}
