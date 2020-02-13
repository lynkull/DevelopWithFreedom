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
        val adapter = ArrayAdapter.createFromResource(this, R.array.city_list, android.R.layout.simple_spinner_item)

        //specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //apply the adapter to the spinner
        spinner.adapter = adapter
    }

    // the difference in layout style between the two spinners is bc of i changed the background on the first

    // choose what to do with the selected item when button is pressed
    // note: if there is no other button, have tot do a .onItemSelectedListener
    fun getValues(view: View) {
        Toast.makeText(this, "Spinner 1 " + spinner.selectedItem.toString() +
                "\nSpinner 2 " + spinner2.selectedItem.toString(), Toast.LENGTH_SHORT).show()
    }
}








// with .onItemSelectedListener
//https://www.youtube.com/watch?v=D5l7MNlqA3M
/*
        // make drop down list (spinner)
        var options = arrayOf("Pro Desk", "Flooring", "Customer Service", "Appliances", "Millwork")
        chooseDepartmentSpinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        chooseDepartmentSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //textForSpinner.text = "Select an Option"
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // choose what happens when each option is clicked (position)


                textForSpinner.text = options.get(position)
            }
        }
*/

