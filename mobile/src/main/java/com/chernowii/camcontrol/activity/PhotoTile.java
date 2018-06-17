package com.chernowii.camcontrol.activity;

import android.os.Build;
import android.service.quicksettings.TileService;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.chernowii.camcontrol.camera.goproAPI.ApiBase;
import com.chernowii.camcontrol.camera.goproAPI.ApiClient;
import com.chernowii.camcontrol.camera.goproAPI.model.GPConstants;
import com.chernowii.camcontrol.camera.goproAPI.model.GoProResponse;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by konrad on 1/2/17.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class PhotoTile extends TileService {
    private final int STATE_OFF = 0;
    private final int STATE_ON = 1;
    private final String LOG_TAG = "MyTileService";

    @Override
    public void onTileAdded() {
        Log.d(LOG_TAG, "onTileAdded");
    }

    @Override
    public void onTileRemoved() {
        Log.d(LOG_TAG, "onTileRemoved");
    }

    @Override
    public void onClick() {
        Log.d(LOG_TAG, "onClick state = " + Integer.toString(getQsTile().getState()));
        Call<GoProResponse> takePhoto = GPConstants.Commands.Shutter.shutter;
        takePhoto.enqueue(new Callback<GoProResponse>() {


            @Override
            public void onResponse(Call<GoProResponse> call, Response<GoProResponse> response) {
                Log.d("LOG",response.message());
                getQsTile().setLabel("Taken!");
                getQsTile().updateTile();
            }

            @Override
            public void onFailure(Call<GoProResponse> call, Throwable t) {

            }

                });


    }
    @Override
    public void onStartListening () {
        Log.d(LOG_TAG, "onStartListening");
    }

    @Override
    public void onStopListening () {
        Log.d(LOG_TAG, "onStopListening");
    }
}