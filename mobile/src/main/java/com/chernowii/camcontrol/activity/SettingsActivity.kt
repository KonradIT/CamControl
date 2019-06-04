package com.chernowii.camcontrol.activity

import android.preference.PreferenceActivity
import android.os.Bundle

import com.chernowii.camcontrol.R

class SettingsActivity : PreferenceActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.pref_general)
    }
}


