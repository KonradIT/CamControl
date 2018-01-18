package com.chernowii.camcontrol.camera.goproAPI;

import java.net.URI;

import okhttp3.HttpUrl;
import okhttp3.Request;

/**
 * Created by konrad on 1/2/17.
 */

public class Camera {
    public static final String connectionURL = "http://10.5.5.9:8080";
    public static final String commandURL = "http://10.5.5.9";
    public void sendCommand(URI command) {
        final Request request = new Request.Builder()
                .url(HttpUrl.get(command))
                .build();
    }
}
