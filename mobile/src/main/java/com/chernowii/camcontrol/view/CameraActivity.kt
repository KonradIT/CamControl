package com.chernowii.camcontrol.view

import android.os.Bundle
import android.app.Activity
import androidx.core.content.ContextCompat
import android.view.View
import android.widget.Toast

import com.chernowii.camcontrol.R
import com.luseen.spacenavigation.SpaceItem
import com.luseen.spacenavigation.SpaceNavigationView
import com.luseen.spacenavigation.SpaceOnClickListener

class CameraActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        val spaceNavigationView = findViewById<View>(R.id.space) as SpaceNavigationView
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState)
        spaceNavigationView.setCentreButtonIcon(R.drawable.ic_preview_btn)
        spaceNavigationView.addSpaceItem(SpaceItem("MEDIA", R.drawable.ic_mediabrowse))
        spaceNavigationView.addSpaceItem(SpaceItem("SETTINGS", R.drawable.ic_controlicon))
        spaceNavigationView.showIconOnly()
        spaceNavigationView.setSpaceItemIconSize(resources.getDimension(R.dimen.bottom_bar_ic).toInt())
        spaceNavigationView.setSpaceBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
        spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this, R.color.colorAccent))

        spaceNavigationView.setActiveSpaceItemColor(ContextCompat.getColor(this, R.color.space_white))
        spaceNavigationView.setInActiveSpaceItemColor(ContextCompat.getColor(this, R.color.space_white))
        spaceNavigationView.setSpaceOnClickListener(object : SpaceOnClickListener {
            override fun onCentreButtonClick() {
                Toast.makeText(this@CameraActivity, "onCentreButtonClick", Toast.LENGTH_SHORT).show()
            }

            override fun onItemClick(itemIndex: Int, itemName: String) {
                Toast.makeText(this@CameraActivity, "$itemIndex $itemName", Toast.LENGTH_SHORT).show()
            }

            override fun onItemReselected(itemIndex: Int, itemName: String) {
                Toast.makeText(this@CameraActivity, "$itemIndex $itemName", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val spaceNavigationView = findViewById<View>(R.id.space) as SpaceNavigationView
        spaceNavigationView.onSaveInstanceState(outState)
    }
}
