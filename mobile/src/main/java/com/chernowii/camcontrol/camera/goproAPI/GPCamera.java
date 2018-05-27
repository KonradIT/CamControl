package com.chernowii.camcontrol.camera.goproAPI;

import java.io.IOException;
import java.net.URI;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by konrad on 1/2/17.
 */

public class GPCamera {
    public static final String connectionURL = "http://10.5.5.9:8080";
    public static final String commandURL = "http://10.5.5.9";

    public static class Info{
        public static final String VendorSite="http://gopro.com";
    }
    private static final OkHttpClient client = new OkHttpClient();

    public static final String[] sendCommand(URI command) {
        final String[] HttpResponse = new String[1];
        final Request request = new Request.Builder()
                .url(HttpUrl.get(command))
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                HttpResponse[0] =e.toString();
            }

            @Override public void onResponse(Call call, Response response) throws IOException {
                HttpResponse[0] = response.message();


            }
        });
        return HttpResponse;
    }

}
