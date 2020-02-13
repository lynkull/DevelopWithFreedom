package com.aldreduser.developwithfreedom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aldreduser.developwithfreedom.Level_1.*
import com.aldreduser.developwithfreedom.Level_2.Storage_Package.LocalStorageActivity
import com.aldreduser.developwithfreedom.Level_2.Pass_Data_To_Activity_Package.PassDataToActivityActivity
import com.aldreduser.developwithfreedom.Level_3.RecyclerViewActivity

// use this app to build anything and test your skills

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun hideAndShowLayoutButtonClicked(view: View) {
        val intent = Intent(this, HideAndShowLayoutActivity::class.java)
        startActivity(intent)
    }
    fun logicStatementsButtonClicked(view: View) {
        val intent = Intent(this, LogicStatementsActivity::class.java)
        startActivity(intent)
    }
    fun functionsAndParametersButtonClicked(view: View) {
        val intent = Intent(this, FunctionsAndParametersActivity::class.java)
        startActivity(intent)
    }
    fun marginsPaddingButtonCicked(view: View) {
        val intent = Intent(this, MarginsPaddingActivity::class.java)
        startActivity(intent)
    }
    fun dropDownMenuButtonClicked(view: View) {
        val intent = Intent(this, DropDownMenuActivity::class.java)
        startActivity(intent)
    }

    fun passDataToActivityClicked(view: View) {
        val intent = Intent(this, PassDataToActivityActivity::class.java)
        startActivity(intent)
    }



    fun localFileStorageClicked(view: View) {
        val intent = Intent(this, LocalStorageActivity::class.java)
        startActivity(intent)
    }// file storage PrintStream(openFIleOutput("out.txt", MODE_PRIVATE))
    // for file storage can use buffer reader or scanner




    fun recyclerViewCLicked(view: View) {
        val intent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }

}
