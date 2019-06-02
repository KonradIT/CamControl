package com.chernowii.camcontrol.camera.goproAPI.model.media

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class GoProFolder {

    @SerializedName("d")
    var folder: String? = null

    @SerializedName("fs")
    var data: List<GoProFile> = ArrayList()
}
