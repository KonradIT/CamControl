package com.chernowii.camcontrol.camera.goproAPI.model.media

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class GoProMediaList {
    @SerializedName("media")
    var data: List<GoProFolder> = ArrayList()
}
