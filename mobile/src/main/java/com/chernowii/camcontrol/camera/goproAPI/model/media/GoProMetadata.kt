package com.chernowii.camcontrol.camera.goproAPI.model.media

import com.google.gson.annotations.SerializedName

import java.util.ArrayList

class GoProMetadata {

    @SerializedName("dur")
    var duration: Int? = null

    @SerializedName("profile")
    var profile: Int? = null

    @SerializedName("tag_count")
    var tag_count: Int? = null

    @SerializedName("tags")
    var tags: List<Int> = ArrayList()

}
