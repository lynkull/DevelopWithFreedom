package com.aldreduser.developwithfreedom.Level_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
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

    //hide and show a layout
    fun toggleTextButtonPressed(view: View) {
        val hiddenText = hidden_text        // try to make this private
        if(hiddenText.isVisible){
            hidden_text.setVisibility(View.INVISIBLE)
        } else if(!hiddenText.isVisible) {
            hidden_text.setVisibility(View.VISIBLE)
        }
    }

    //changing the look of the actionbar (text size, color, etc)
    fun actionBarButtonPressed(view: View) {
        // Changing the action bar can be done in manifest file, programmatically in file, or in resource file
        //https://www.youtube.com/watch?v=510WE8CmiXI       by changing it in resource files (quick fix)
        //https://www.youtube.com/watch?v=DMkzIOLppf4       by creating a toolbar xml file (BEST PRACTICE, more customizable)
        //      if doing this, need to change to "Theme.AppCompat.Light.NoActionBar" in styles.xml file

        //this is programatically
        title = "Whatever title you want."
        //font size
        //gravity (center)
        //      these crash  my app:
        //back button   actionBar.setHomeButtonEnabled(true); // actionBar.setDisplayHomeAsUpEnabled(true)
        //actionBar.setIcon(R.drawable.ic_android) //this didn't work but idek what an icon is used for here
    }

    //Options Menu button. In action bar (...)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.level1_layout_options_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if(id == R.id.add_action){
            Toast.makeText(this, "item Add clicked", Toast.LENGTH_SHORT).show()
            return true
        }else{ //if (id == R.id.settings_action)
            Toast.makeText(this, "Setting clicked", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
