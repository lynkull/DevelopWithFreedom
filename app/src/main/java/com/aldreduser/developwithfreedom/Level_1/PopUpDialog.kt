package com.aldreduser.developwithfreedom.Level_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.aldreduser.developwithfreedom.R

class PopUpDialog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level1_activity_pop_up_dialog)
    }

    // pop up meddage
    fun showInfo() {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("My Dialog")
        builder.setMessage("Welcome to my app!")

        //yes and no options
        builder.setPositiveButton("OK") { _,_ ->
            // code to run when ok is pressed
        }
        builder.setPositiveButton("Cancel") { _,_ ->
            // code to run when ok is pressed
        }

        val dialog = builder.create()
        dialog.show()
    }
}
