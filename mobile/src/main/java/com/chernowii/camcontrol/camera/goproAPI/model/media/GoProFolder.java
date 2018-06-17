package com.chernowii.camcontrol.camera.goproAPI.model.media;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GoProFolder {

    @SerializedName("d")
    public String folder;

    @SerializedName("fs")
    public List<GoProFile> data = new ArrayList();
}
