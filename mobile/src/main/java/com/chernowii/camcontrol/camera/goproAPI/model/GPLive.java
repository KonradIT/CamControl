package com.chernowii.camcontrol.camera.goproAPI.model;

import com.chernowii.camcontrol.camera.goproAPI.ApiBase;
import com.chernowii.camcontrol.camera.goproAPI.ApiClient;

import java.net.URI;

import retrofit2.Call;

/**
 * Created by konrad on 5/13/17.
 */

public class GPLive {
    public static final String LiveResource = "udp://10.5.5.9:8554";
    public static final void startPreview(){
        ApiClient GoProApi = ApiBase.getMainClient().create(ApiClient.class);
        Call<GoProResponse> streamOn = GoProApi.execute("?p1=gpStream&a1=proto_v2&c1=restart");
    }

    public static class Bitrate{

    }

    public static class Resolution{

    }
}
