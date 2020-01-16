package com.aldreduser.developwithfreedom.Level_2.Pass_Data_To_Activity_Package

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aldreduser.developwithfreedom.R

class PassDataToActivityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2_activity_pass_data_to_activity)
    }

    fun testActivityOneClicked(view: View) {
        var intent = Intent(this, TestActivityOne::class.java)

        intent.putExtra("thisnamething", "COURSETITLEOBJECTTOPASS")

        startActivity(intent)
    }

    // some objects cannot be attached to bundles (like .putExtra)
    // some objects should not be attached to bundles (Very large data sets, like a large array list (50 entries))

    // parcelable, Serializable
    // passing classes to an activity.
    // maybe this is not recommended. Only pass data instead.

    fun passArrayListClicked(view: View) {
        var numbers = listOf<Int>(56, 2,3 ,8 ,9)

        var intent = Intent(this, ArrayBeingPassedActivity::class.java)

        // to pass a list, need to use parcealable or maybe serializable
        // intent.putExtra("listOfNumbers", numbers)

        startActivity(intent)
    }
}
