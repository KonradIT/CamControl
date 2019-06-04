package com.chernowii.camcontrol.camera.goproAPI.model

/**
 * Created by konrad on 5/13/17.
 */

class GPMedia {
    fun listMedia() {
        //http://10.5.5.9/gp/gpMediaList
    }

    fun getMediaItem(folder: String, file: String) {
        //http://10.5.5.9:8080/videos/DCIM/folder/fie
    }

    fun deleteMediaItem(folder: String, file: String) {
        //http://10.5.5.9:8080/videos/DCIM/folder/fie
    }
}
