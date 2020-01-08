package com.aldreduser.developwithfreedom.Level_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.activity_drop_down_menu_kotlin_version.*

//spinner2 wasn't used in the code so idk how that still works
/*
in practice, just use spinner one, which is the code in onCreate()
 */

class DropDownMenuKotlinVersionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drop_down_menu_kotlin_version)

        //create an ArrayAdapter
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.city_list, android.R.layout.simple_spinner_item)

        //specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //apply the adapter to the spinner
        spinner.adapter = adapter
    }

    // the difference in layout style between the two spinners is bc of i changed the background on the first

    fun getValues(view: View) {
        Toast.makeText(this, "Spinner 1 " + spinner.selectedItem.toString() +
                "\nSpinner 2 " + spinner2.selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }
}
