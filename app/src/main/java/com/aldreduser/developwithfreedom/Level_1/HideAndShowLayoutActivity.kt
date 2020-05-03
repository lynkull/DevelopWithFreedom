package com.aldreduser.developwithfreedom.Level_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.activity_hide_and_show_layout.*

class HideAndShowLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hide_and_show_layout)

        toggle_text_button.setOnLongClickListener {
            val hiddenLayout = hidden_layout  // try to make this private

            if(hiddenLayout.isGone){
                hiddenLayout.visibility = View.VISIBLE
            } else if(!hiddenLayout.isGone) {
                hiddenLayout.setVisibility(View.GONE)
            }
            return@setOnLongClickListener true
        }

        programaticallyButton.setOnClickListener {
            val intent = Intent(this, ProgramaticLayoutActivity::class.java)
            startActivity(intent)
        }
    }

    fun toggleTextButtonPressed(view: View) {
        val hiddenText = hidden_text        // try to make this private
        if(hiddenText.isVisible){
            hidden_text.setVisibility(View.INVISIBLE)
        } else if(!hiddenText.isVisible) {
            hidden_text.setVisibility(View.VISIBLE)
        }
    }

    fun actionBarButtonPressed(view: View) {

    }
}
