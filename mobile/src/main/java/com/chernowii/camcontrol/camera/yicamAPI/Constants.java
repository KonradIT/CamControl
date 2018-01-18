package com.chernowii.camcontrol.camera.yicamAPI;


import java.net.URI;

/**
 * Created by konrad on 1/2/17.
 */

public class Constants {
    public static String baseUri(String param, String val) {
        return "192.168.42.1:7878" + param + "/" + val;
    }

    public static class Commands {

    }
}
