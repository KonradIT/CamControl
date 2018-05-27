package com.chernowii.camcontrol.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.chernowii.camcontrol.R;

public class ImgAdapter extends BaseAdapter {
    private Context mContext;

    public ImgAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        if (convertView == null) {
            imageView = new ImageView(mContext);
            float iconWidth = displayMetrics.widthPixels / displayMetrics.density;
            imageView.setLayoutParams(new ViewGroup.LayoutParams(400, 400));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(40, 10, 40, 10);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.camera_selector_hero3plus, R.drawable.camera_selector_hero4,
            R.drawable.camera_selector_hero5_session, R.drawable.camera_selector_hero5

    };
}