package com.chernowii.camcontrol.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;

import com.chernowii.camcontrol.R;
import com.chernowii.camcontrol.util.ImgAdapter;
import com.chernowii.camcontrol.view.CameraActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImgAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Intent myIntent = new Intent(MainActivity.this, CameraActivity.class);
                myIntent.putExtra("camera", position); //Optional parameters
                MainActivity.this.startActivity(myIntent);
            }
        });
    }

    /*
        UI NAVIGATION
    */

    public static String getPath() {
        checkAndMakeFolder();
        File folder = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "GOPRO");
        File file = new File(folder, "temp.avi");
        return file.getAbsolutePath();
    }
    private static void checkAndMakeFolder() {
        File folder = new File(Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "GOPRO");
        if (!folder.exists()) {
            Log.i("TAG", "Folder not found, creating.");
            folder.mkdir();
        } else {
            Log.i("TAG", "Folder found.");
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
        if (id == R.id.action_about) {
            Intent myIntent = new Intent(MainActivity.this, AboutApp.class);
            MainActivity.this.startActivity(myIntent);
            return true;
        }
        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
            MainActivity.this.startActivity(myIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
