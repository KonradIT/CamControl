package com.chernowii.camcontrol.camera.goproAPI;

import java.net.URI;

/**
 * Created by konrad on 5/13/17.
 */

public class GPLive {
    public static final String LiveResource = "udp://10.5.5.9:8554";
    public static final void startPreview(){
        URI command = URI.create(GPConstants.executeUri("?p1=gpStream&a1=proto_v2&c1=restart"));
    }
}
