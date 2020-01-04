package com.aldreduser.developwithfreedom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_hide_and_show_layout.*

// layout will show when the button is clicked
// also do a drop down menu
// file storage PrintStream(openFIleOutput("out.txt", MODE_PRIVATE))

class HideAndShowLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hide_and_show_layout)

        toggle_text_button.setOnLongClickListener {
            var hiddenLayout = hidden_layout  // try to make this private

            if(hiddenLayout.isGone){
                hiddenLayout.setVisibility(View.VISIBLE)
            } else if(!hiddenLayout.isGone) {
                hiddenLayout.setVisibility(View.GONE)
            }
            return@setOnLongClickListener true
        }
    }

    fun toggleTextButtonPressed(view: View) {
        var hiddenText = hidden_text        // try to make this private
        if(hiddenText.isVisible){
            hidden_text.setVisibility(View.INVISIBLE)
        } else if(!hiddenText.isVisible) {
            hidden_text.setVisibility(View.VISIBLE)
        }
    }
}
