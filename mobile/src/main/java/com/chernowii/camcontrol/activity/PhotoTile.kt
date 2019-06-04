package com.chernowii.camcontrol.activity

import android.os.Build
import android.service.quicksettings.TileService
import androidx.annotation.RequiresApi
import android.util.Log
import android.widget.Toast

import com.chernowii.camcontrol.camera.goproAPI.ApiBase
import com.chernowii.camcontrol.camera.goproAPI.ApiClient
import com.chernowii.camcontrol.camera.goproAPI.model.GPConstants
import com.chernowii.camcontrol.camera.goproAPI.model.GoProResponse

import java.io.IOException

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by konrad on 1/2/17.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
class PhotoTile : TileService() {
    private val STATE_OFF = 0
    private val STATE_ON = 1
    private val LOG_TAG = "MyTileService"

    override fun onTileAdded() {
        Log.d(LOG_TAG, "onTileAdded")
    }

    override fun onTileRemoved() {
        Log.d(LOG_TAG, "onTileRemoved")
    }

    override fun onClick() {
        Log.d(LOG_TAG, "onClick state = " + Integer.toString(qsTile.state))
        val takePhoto = GPConstants.Commands.Shutter.shutter
        takePhoto.enqueue(object : Callback<GoProResponse> {


            override fun onResponse(call: Call<GoProResponse>, response: Response<GoProResponse>) {
                Log.d("LOG", response.message())
                qsTile.label = "Taken!"
                qsTile.updateTile()
            }

            override fun onFailure(call: Call<GoProResponse>, t: Throwable) {

            }

        })


    }

    override fun onStartListening() {
        Log.d(LOG_TAG, "onStartListening")
    }

    override fun onStopListening() {
        Log.d(LOG_TAG, "onStopListening")
    }
}