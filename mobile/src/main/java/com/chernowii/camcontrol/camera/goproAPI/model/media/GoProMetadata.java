package com.chernowii.camcontrol.camera.goproAPI.model.media;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GoProMetadata {

    @SerializedName("dur")
    public Integer duration;

    @SerializedName("profile")
    public Integer profile;

    @SerializedName("tag_count")
    public Integer tag_count;

    @SerializedName("tags")
    public List<Integer> tags = new ArrayList();

}
