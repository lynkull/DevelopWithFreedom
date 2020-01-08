package com.aldreduser.developwithfreedom.Level_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aldreduser.developwithfreedom.Level_2.Pass_Data_To_Activity_Package.TestActivityOne
import com.aldreduser.developwithfreedom.R

class PassDataToActivityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass_data_to_activity)
    }

    fun testActivityOneClicked(view: View) {
        var intent = Intent(this, TestActivityOne::class.java)

        intent.putExtra("thisnamething", "COURSETITLEOBJECTTOPASS")

        startActivity(intent)
    }
}
