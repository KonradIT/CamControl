package com.chernowii.camcontrol.view;

import android.app.Dialog;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.chernowii.camcontrol.R;

import com.chernowii.camcontrol.camera.goproAPI.GPCamera;
import com.chernowii.camcontrol.camera.goproAPI.model.GPConstants;
import com.github.hiteshsondhi88.libffmpeg.ExecuteBinaryResponseHandler;
import com.github.hiteshsondhi88.libffmpeg.FFmpeg;
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException;

import org.videolan.libvlc.IVLCVout;
import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.Media;
import org.videolan.libvlc.MediaPlayer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by konrad on 2/18/18.
 */

public class PreviewActivity extends AppCompatActivity implements IVLCVout.Callback {
    public final static String TAG = "Preview_Activity";
    private String mFilePath;
    private SurfaceView mSurface;
    private SurfaceHolder holder;
    private LibVLC libvlc;
    private MediaPlayer mMediaPlayer = null;
    private int mVideoWidth;
    private int mVideoHeight;
    Integer count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_view);
        Button restart = (Button)findViewById(R.id.startPreview);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stream();
                createPlayer(mFilePath);
            }
        });
        Button stop = (Button)findViewById(R.id.stoppreviewbtn);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FFmpeg ffmpeg = FFmpeg.getInstance(getApplicationContext());
                if(ffmpeg.isFFmpegCommandRunning()){
                    ffmpeg.killRunningProcesses();
                }
                releasePlayer();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        Button setHQ = (Button)findViewById(R.id.setQuality);
        setHQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(PreviewActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.radiobutton_dialog);
                List<String> stringList=new ArrayList<>();  // here is list
                final String[] resolutions =  {"720p","480p","240p"};
                for(int i=0;i<resolutions.length;i++) {
                    stringList.add(resolutions[i]);
                }
                RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.radio_group);

                for(int i=0;i<stringList.size();i++){
                    RadioButton rb=new RadioButton(PreviewActivity.this); // dynamically creating RadioButton and adding to RadioGroup.
                    rb.setText(stringList.get(i));
                    rg.addView(rb);
                }

                dialog.show();
                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        int childCount = group.getChildCount();
                        for (int x = 0; x < childCount; x++) {
                            RadioButton btn = (RadioButton) group.getChildAt(x);
                            if (btn.getId() == checkedId) {
                                switch (btn.getText().toString()){
                                    case "720p":
                                        GoProSet("64", "7");
                                        setBitrate();
                                    case "480p":
                                        GoProSet("64", "4");
                                        setBitrate();
                                    case "240p":
                                        GoProSet("64", "1");
                                        setBitrate();
                                }

                            }
                        }
                    }
                });
            }
        });
        Stream();
        mFilePath = "udp://@:8555/gopro";
        Log.d(TAG, "Playing: " + mFilePath);
        mSurface = (SurfaceView) findViewById(R.id.surface);
        holder = mSurface.getHolder();
    }
    void setBitrate(){
        final Dialog dialog = new Dialog(PreviewActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.radiobutton_dialog);
        List<String> stringList=new ArrayList<>();  // here is list
        final String[] bitrates =  {"4 Mbps","2 Mbps","1 Mbps","600 Kbps","250 Kbps"};
        for(int i=0;i<bitrates.length;i++) {
            stringList.add(bitrates[i]);
        }
        RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.radio_group);

        for(int i=0;i<stringList.size();i++){
            RadioButton rb=new RadioButton(PreviewActivity.this); // dynamically creating RadioButton and adding to RadioGroup.
            rb.setText(stringList.get(i));
            rg.addView(rb);
        }

        dialog.show();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int childCount = group.getChildCount();
                for (int x = 0; x < childCount; x++) {
                    RadioButton btn = (RadioButton) group.getChildAt(x);
                    if (btn.getId() == checkedId) {
                        switch (btn.getText().toString()){
                            case "4 Mbps":
                                GoProSet("62", "4000000");
                            case "2 Mbps":
                                GoProSet("62", "2000000");
                            case "1 Mbps":
                                GoProSet("62", "1000000");
                            case "600 Kbps":
                                GoProSet("62", "600000");
                            case "250 Kbps":
                                GoProSet("62", "250000");
                        }

                        Stream();
                        createPlayer(mFilePath);

                    }
                }
            }
        });


    }


    void GoProSet(String param, String value){

    }
    void Stream(){

        //Call http://10.5.5.9/gp/gpControl/execute?p1=gpStream&a1=proto_v2&c1=restart

        GPCamera.sendCommand(GPConstants.Commands.Stream.Restart);
        try {
            String[] cmd = {"-f", "mpegts", "-i", "udp://:8554", "-f", "mpegts","udp://127.0.0.1:8555/gopro?pkt_size=64"};
            FFmpeg ffmpeg = FFmpeg.getInstance(getApplicationContext());

            ffmpeg.execute(cmd, new ExecuteBinaryResponseHandler() {

                @Override
                public void onStart() {
                    count += 1;
                    if(count == 7){
                        count = 0;
                        GPCamera.sendCommand(GPConstants.Commands.Stream.Restart);
                    }
                }

                @Override
                public void onProgress(String message) {
                    Log.d("FFmpeg",message);
                    GPCamera.sendCommand(GPConstants.Commands.Stream.Restart);

                }

                @Override
                public void onFailure(String message) {
                    Toast.makeText(getApplicationContext(),"Stream fail",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSuccess(String message) {}

                @Override
                public void onFinish() {}
            });
        } catch (FFmpegCommandAlreadyRunningException e) {
            // Handle if FFmpeg is already running
        }
        //Preview();
        createPlayer(mFilePath);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setSize(mVideoWidth, mVideoHeight);
    }

    @Override
    protected void onResume() {
        super.onResume();
        createPlayer(mFilePath);
    }

    @Override
    protected void onPause() {
        super.onPause();
        releasePlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlayer();
    }


    /**
     * Used to set size for SurfaceView
     *
     * @param width
     * @param height
     */

    private void setSize(int width, int height) {
        mVideoWidth = width;
        mVideoHeight = height;
        if (mVideoWidth * mVideoHeight <= 1)
            return;

        if (holder == null || mSurface == null)
            return;

        int w = getWindow().getDecorView().getWidth();
        int h = getWindow().getDecorView().getHeight();
        boolean isPortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        if (w > h && isPortrait || w < h && !isPortrait) {
            int i = w;
            w = h;
            h = i;
        }

        float videoAR = (float) mVideoWidth / (float) mVideoHeight;
        float screenAR = (float) w / (float) h;

        if (screenAR < videoAR)
            h = (int) (w / videoAR);
        else
            w = (int) (h * videoAR);

        holder.setFixedSize(mVideoWidth, mVideoHeight);
        ViewGroup.LayoutParams lp = mSurface.getLayoutParams();
        lp.width = w;
        lp.height = h;
        mSurface.setLayoutParams(lp);
        mSurface.invalidate();
        if (width * height == 0)
            return;

        // store video size
        mVideoWidth = width;
        mVideoHeight = height;
        setSize(mVideoWidth, mVideoHeight);
    }

    /**
     * Creates MediaPlayer and plays video
     *
     * @param media
     */
    private void createPlayer(String media) {
        releasePlayer();
        try {
            if (media.length() > 0) {
                Toast toast = Toast.makeText(this, media, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0,
                        0);
                toast.show();
            }

            // Create LibVLC
            // TODO: make this more robust, and sync with audio demo
            ArrayList<String> options = new ArrayList<String>();
            //options.add("--subsdec-encoding <encoding>");
            options.add("--aout=opensles");
            options.add("--audio-time-stretch"); // time stretching
            options.add("-vvv"); // verbosity
            libvlc = new LibVLC(this, options);
            holder.setKeepScreenOn(true);

            // Creating media player
            mMediaPlayer = new MediaPlayer(libvlc);
            mMediaPlayer.setEventListener(mPlayerListener);

            // Seting up video output
            final IVLCVout vout = mMediaPlayer.getVLCVout();
            vout.setVideoView(mSurface);
            //vout.setSubtitlesView(mSurfaceSubtitles);
            vout.addCallback(this);
            vout.attachViews();

            Media m = new Media(libvlc, Uri.parse(media));
            mMediaPlayer.setMedia(m);
            mMediaPlayer.play();
        } catch (Exception e) {
            Toast.makeText(this, "Error in creating player!", Toast
                    .LENGTH_LONG).show();
        }
    }

    private void releasePlayer() {
        if (libvlc == null)
            return;
        mMediaPlayer.stop();
        final IVLCVout vout = mMediaPlayer.getVLCVout();
        vout.removeCallback(this);
        vout.detachViews();
        holder = null;
        libvlc.release();
        libvlc = null;

        mVideoWidth = 0;
        mVideoHeight = 0;
    }

    /**
     * Registering callbacks
     */
    private MediaPlayer.EventListener mPlayerListener = new MyPlayerListener(this);



    @Override
    public void onSurfacesCreated(IVLCVout vout) {

    }

    @Override
    public void onSurfacesDestroyed(IVLCVout vout) {

    }


    private static class MyPlayerListener implements MediaPlayer.EventListener {
        private WeakReference<PreviewActivity> mOwner;

        public MyPlayerListener(PreviewActivity owner) {
            mOwner = new WeakReference<PreviewActivity>(owner);
        }

        @Override
        public void onEvent(MediaPlayer.Event event) {
            PreviewActivity player = mOwner.get();

            switch (event.type) {
                case MediaPlayer.Event.EndReached:
                    Log.d(TAG, "MediaPlayerEndReached");
                    player.releasePlayer();
                    break;
                case MediaPlayer.Event.Playing:
                case MediaPlayer.Event.Paused:
                case MediaPlayer.Event.Stopped:
                default:
                    break;
            }
        }
    }

}