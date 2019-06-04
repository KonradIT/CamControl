package com.chernowii.camcontrol.camera.goproAPI.model

import com.chernowii.camcontrol.camera.goproAPI.ApiBase
import com.chernowii.camcontrol.camera.goproAPI.ApiClient

/**
 * Created by konrad on 5/13/17.
 */

object GPLive {
    val LiveResource = "udp://10.5.5.9:8554"
    fun startPreview() {
        val GoProApi = ApiBase.mainClient.create(ApiClient::class.java)
        val streamOn = GoProApi.execute("?p1=gpStream&a1=proto_v2&c1=restart")
    }

    class Bitrate

    class Resolution
}
