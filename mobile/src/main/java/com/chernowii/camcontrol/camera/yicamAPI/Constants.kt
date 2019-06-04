package com.chernowii.camcontrol.camera.yicamAPI


import java.net.URI

/**
 * Created by konrad on 1/2/17.
 */

object Constants {
    fun baseUri(param: String, `val`: String): String {
        return "192.168.42.1:7878$param/$`val`"
    }

    class Commands
}
