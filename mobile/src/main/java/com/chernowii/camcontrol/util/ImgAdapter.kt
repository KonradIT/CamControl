package com.chernowii.camcontrol.util

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

import com.chernowii.camcontrol.R

class ImgAdapter(private val mContext: Context) : BaseAdapter() {

    // references to our images
    private val mThumbIds = arrayOf(R.drawable.camera_selector_hero3plus, R.drawable.camera_selector_hero4, R.drawable.camera_selector_hero5_session, R.drawable.camera_selector_hero5)

    override fun getCount(): Int {
        return mThumbIds.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    // create a new ImageView for each item referenced by the Adapter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: ImageView
        val displayMetrics = mContext.resources.displayMetrics
        if (convertView == null) {
            imageView = ImageView(mContext)
            val iconWidth = displayMetrics.widthPixels / displayMetrics.density
            imageView.layoutParams = ViewGroup.LayoutParams(400, 400)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(40, 10, 40, 10)
        } else {
            imageView = convertView as ImageView
        }

        imageView.setImageResource(mThumbIds[position])
        return imageView
    }
}