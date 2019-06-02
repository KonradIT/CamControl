package com.chernowii.camcontrol.camera.goproAPI.model.media

import com.google.gson.annotations.SerializedName

class GoProFile {

    @SerializedName("n")
    var filename: String? = null

    @SerializedName("mod")
    var mod: String? = null

    @SerializedName("s")
    var filesize: String? = null
}
