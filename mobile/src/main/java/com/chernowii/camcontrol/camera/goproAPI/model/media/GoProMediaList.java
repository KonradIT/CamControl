package com.chernowii.camcontrol.camera.goproAPI.model.media;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GoProMediaList {
    @SerializedName("media")
    public List<GoProFolder> data = new ArrayList();
}
