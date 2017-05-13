package com.chernowii.camcontrol;

import android.os.Build;
import android.service.quicksettings.TileService;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.chernowii.camcontrol.camera.goproAPI.*;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by konrad on 1/2/17.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class PhotoTile extends TileService {
    private final int STATE_OFF = 0;
    private final int STATE_ON = 1;
    private final String LOG_TAG = "MyTileService";
    private int toggleState = STATE_ON;
    private final OkHttpClient client = new OkHttpClient();

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
        final Request photo_mode_request = new Request.Builder()
                .url(HttpUrl.get(Constants.cameraModes.photoMode))
                .build();
        final Request shutter_request = new Request.Builder()
                .url(HttpUrl.get(Constants.Shutter.shutter))
                .build();

        client.newCall(photo_mode_request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"GoPro not connected!",Toast.LENGTH_SHORT).show();
                }
                getQsTile().setLabel("Taken!");
                getQsTile().updateTile();
                client.newCall(shutter_request).enqueue(new Callback() {
                    @Override public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override public void onResponse(Call call, Response response) throws IOException {
                        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                        getQsTile().setLabel("Take Photo");
                        getQsTile().updateTile();

                    }
                });

            }
        });
        //send command

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