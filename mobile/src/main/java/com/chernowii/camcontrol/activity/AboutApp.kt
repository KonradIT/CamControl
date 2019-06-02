package com.chernowii.camcontrol.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.chernowii.camcontrol.R

import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element

class AboutApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val versionElement = Element()
        versionElement.title = "Version 1.0"
        val emailElement = Element()
        emailElement.title = "Email me"
        emailElement.intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:mail@chernowii.com"))

        val aboutPage = AboutPage(this)
                .isRTL(false)
                .setDescription(getString(R.string.app_description))
                .addItem(versionElement)
                .addItem(emailElement)
                .addWebsite("http://chernowii.com")
                .addTwitter("konrad_it")
                .addPlayStore("com.chernowii.camcontrol")
                .addGitHub("konradit")
                .create()
        setContentView(aboutPage)
    }
}
