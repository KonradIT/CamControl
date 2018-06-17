package com.chernowii.camcontrol.activity;

import android.preference.PreferenceActivity;
import android.os.Bundle;

import com.chernowii.camcontrol.R;

public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
    }
}


