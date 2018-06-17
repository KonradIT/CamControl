package com.chernowii.camcontrol.camera.goproAPI.model.media;

import com.google.gson.annotations.SerializedName;

public class GoProFile {

    @SerializedName("n")
    public String filename;

    @SerializedName("mod")
    public String mod;

    @SerializedName("s")
    public String filesize;
}
