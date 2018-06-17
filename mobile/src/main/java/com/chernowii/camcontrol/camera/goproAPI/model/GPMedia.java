package com.chernowii.camcontrol.camera.goproAPI.model;

/**
 * Created by konrad on 5/13/17.
 */

public class GPMedia {
    public void listMedia(){
        //http://10.5.5.9/gp/gpMediaList
    }
    public void getMediaItem(String folder, String file){
        //http://10.5.5.9:8080/videos/DCIM/folder/fie
    }
    public void deleteMediaItem(String folder, String file){
        //http://10.5.5.9:8080/videos/DCIM/folder/fie
    }
}
