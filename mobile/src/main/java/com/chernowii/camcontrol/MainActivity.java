package com.chernowii.camcontrol;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.chernowii.camcontrol.camera.*;
import com.github.hiteshsondhi88.libffmpeg.ExecuteBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException;

import java.io.IOException;
import java.net.URI;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Connect new camera", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemBackgroundResource(R.drawable.drawer_list_selector);
        navigationView.setNavigationItemSelectedListener(this);
        detectCameraConnected();
    }
    public void detectCameraConnected(){
        if(canConnect(com.chernowii.camcontrol.camera.goproAPI.Camera.connectionURL)){
            setCamera("GoPro", CameraList.GOPROCAMERA);
        }
        else{
            setCamera("TRY AGAIN", CameraList.TRY_AGAIN);
        }
    }
    Boolean connection = false;
    public boolean canConnect(String uri){
        final OkHttpClient client = new OkHttpClient();

        final Request isconnected = new Request.Builder()
                .url(HttpUrl.get(URI.create(uri)))
                .build();
        client.newCall(isconnected).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    connection = true;
                }

            }
        });
        return connection;
    }

    public void setCamera(String camname, Integer camID){
        TextView cameraname = (TextView)findViewById(R.id.camera_connect_status);
        Button camerabutton = (Button)findViewById(R.id.connect_btn);
        cameraname.setText(camname);
        camerabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_view);
            }
        });
        if(camID.equals(CameraList.TRY_AGAIN)){
            cameraname.setText("Please connect your camera and try again.");
            camerabutton.setText(camname);
            camerabutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    detectCameraConnected();
                }
            });
        }
    }
    /*
        UI NAVIGATION
    */

    public void handleActivities(int layout){
        setContentView(layout);
        if(layout == R.layout.activity_view){
            //start FFmpeg
            FFmpeg ffmpeg = FFmpeg.getInstance(getApplicationContext());
            try {
                // to execute "ffmpeg -version" command you just need to pass "-version"
                final String localAddress = "udp://127.0.0.1:10000";
                ffmpeg.execute(new String[]{"-f", "mpegts", "-i", "udp://10.5.5.9:8554", "-b", "800k", "-r", "30", "-f", "mpegts", localAddress}, new ExecuteBinaryResponseHandler() {

                    @Override
                    public void onStart() {}

                    @Override
                    public void onProgress(String message) {
                        VideoView preview = (VideoView)findViewById(R.id.video_preview);
                        preview.setVideoURI(Uri.parse(localAddress));
                        preview.setVideoPath(localAddress);
                    }

                    @Override
                    public void onFailure(String message) {}

                    @Override
                    public void onSuccess(String message) {}

                    @Override
                    public void onFinish() {}
                });
            } catch (FFmpegCommandAlreadyRunningException e) {
                // Handle if FFmpeg is already running
            }
        }
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);

            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setItemBackgroundResource(R.drawable.drawer_list_selector);
            navigationView.setNavigationItemSelectedListener(this);
        } else if (id == R.id.nav_view) {
            setContentView(R.layout.activity_view);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);

            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setItemBackgroundResource(R.drawable.drawer_list_selector);
            navigationView.setNavigationItemSelectedListener(this);

        } else if (id == R.id.nav_browse) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
