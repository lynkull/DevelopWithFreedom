package com.aldreduser.developwithfreedom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

// use this app to build anything adn test your skills

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun hideAndShowLayoutButtonClicked(view: View) {
        val intent = Intent(this, HideAndShowLayoutActivity::class.java)
        startActivity(intent)
    }
}
