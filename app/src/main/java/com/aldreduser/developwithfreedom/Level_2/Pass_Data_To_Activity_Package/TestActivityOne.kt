package com.aldreduser.developwithfreedom.Level_2.Pass_Data_To_Activity_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldreduser.developwithfreedom.R

class TestActivityOne : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2_activity_test_one)

        // change nav bar title
        var navBarTitle = intent.getStringExtra("thisnamething")
        supportActionBar?.title = navBarTitle
    }
}
