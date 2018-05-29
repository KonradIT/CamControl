package com.chernowii.camcontrol.view;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.chernowii.camcontrol.R;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class CameraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.setCentreButtonIcon(R.drawable.ic_preview_btn);
        spaceNavigationView.addSpaceItem(new SpaceItem("MEDIA", R.drawable.ic_mediabrowse));
        spaceNavigationView.addSpaceItem(new SpaceItem("SETTINGS", R.drawable.ic_controlicon));
        spaceNavigationView.showIconOnly();
        spaceNavigationView.setSpaceItemIconSize((int) getResources().getDimension(R.dimen.bottom_bar_ic));
        spaceNavigationView.setSpaceBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this, R.color.colorAccent));

        spaceNavigationView.setActiveSpaceItemColor(ContextCompat.getColor(this, R.color.space_white));
        spaceNavigationView.setInActiveSpaceItemColor(ContextCompat.getColor(this, R.color.space_white));
        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(CameraActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(CameraActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(CameraActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.onSaveInstanceState(outState);
    }
}
