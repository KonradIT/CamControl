package com.chernowii.camcontrol.camera.goproAPI

import com.chernowii.camcontrol.camera.goproAPI.model.GoProResponse
import com.chernowii.camcontrol.camera.goproAPI.model.media.GoProMediaList
import com.chernowii.camcontrol.camera.goproAPI.model.media.GoProMetadata

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @get:GET("/gp/gpMediaList")
    val mediaList: Call<GoProMediaList>

    @GET("/gp/gpControl/setting/{param}/{option}")
    fun config(@Path("param") param: String, @Path("option") option: String): Call<GoProResponse>

    @GET("/gp/gpControl/command/{param}")
    fun command(@Path("param") param: String, @Query("p") option: String): Call<GoProResponse>

    @GET("gp/gpControl/execute/{param}")
    fun execute(@Path("param") param: String): Call<GoProResponse>

    @GET("/gp/getMediaMetadata")
    fun getMediaMetadata(@Query("p") GoProMedia: String, @Query("t") MetadataOption: String): Call<GoProMetadata>

    @GET("/gp/getMediaMetadata")
    fun getThumbnail(@Query("p") GoProMedia: String): Call<GoProMetadata>
}
