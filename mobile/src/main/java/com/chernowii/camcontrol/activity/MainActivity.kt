package com.chernowii.camcontrol.activity

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView

import com.chernowii.camcontrol.R
import com.chernowii.camcontrol.util.ImgAdapter
import com.chernowii.camcontrol.view.CameraActivity

import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val gridview = findViewById(R.id.gridview) as GridView
        gridview.adapter = ImgAdapter(this)

        gridview.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            val myIntent = Intent(this@MainActivity, CameraActivity::class.java)
            myIntent.putExtra("camera", position) //Optional parameters
            this@MainActivity.startActivity(myIntent)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_about) {
            val myIntent = Intent(this@MainActivity, AboutApp::class.java)
            this@MainActivity.startActivity(myIntent)
            return true
        }
        if (id == R.id.action_settings) {
            val myIntent = Intent(this@MainActivity, SettingsActivity::class.java)
            this@MainActivity.startActivity(myIntent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {

        /*
        UI NAVIGATION
    */

        val path: String
            get() {
                checkAndMakeFolder()
                val folder = File(Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "GOPRO")
                val file = File(folder, "temp.avi")
                return file.absolutePath
            }

        private fun checkAndMakeFolder() {
            val folder = File(Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "GOPRO")
            if (!folder.exists()) {
                Log.i("TAG", "Folder not found, creating.")
                folder.mkdir()
            } else {
                Log.i("TAG", "Folder found.")
            }
        }
    }


}
