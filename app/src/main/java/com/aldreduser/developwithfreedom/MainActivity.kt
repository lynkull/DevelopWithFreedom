package com.aldreduser.developwithfreedom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aldreduser.developwithfreedom.Level_1.*

// use this app to build anything and test your skills

// also do a drop down menu
// file storage PrintStream(openFIleOutput("out.txt", MODE_PRIVATE))

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun logicStatementsButtonClicked(view: View) {
        val intent = Intent(this, LogicStatementsActivity::class.java)
        startActivity(intent)
    }
    fun functionsAndParametersButtonClicked(view: View) {
        val intent = Intent(this, FunctionsAndParametersActivity::class.java)
        startActivity(intent)
    }
    fun dropDownMenuButtonClicked(view: View) {
        val intent = Intent(this, DropDownMenuActivity::class.java)
        startActivity(intent)
    }


    fun hideAndShowLayoutButtonClicked(view: View) {
        val intent = Intent(this, HideAndShowLayoutActivity::class.java)
        startActivity(intent)
    }
    fun marginsPaddingButtonCicked(view: View) {
        val intent = Intent(this, MarginsPaddingActivity::class.java)
        startActivity(intent)
    }


    // for file storage can use buffer reader or scanner
}
