package com.chernowii.camcontrol.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.chernowii.camcontrol.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class AboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Element versionElement = new Element();
        versionElement.setTitle("Version 1.0");
        Element emailElement = new Element();
        emailElement.setTitle("Email me");
        emailElement.setIntent(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:mail@chernowii.com")));

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(getString(R.string.app_description))
                .addItem(versionElement)
                .addItem(emailElement)
                .addWebsite("http://chernowii.com")
                .addTwitter("konrad_it")
                .addPlayStore("com.chernowii.camcontrol")
                .addGitHub("konradit")
                .create();
        setContentView(aboutPage);
    }
}
