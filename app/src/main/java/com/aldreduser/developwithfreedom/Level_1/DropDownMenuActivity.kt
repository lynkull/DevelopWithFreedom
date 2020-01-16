package com.aldreduser.developwithfreedom.Level_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.activity_drop_down_menu.*

// DO NOT USE THIS METHOD, use the one for kotlin

class DropDownMenuActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drop_down_menu)

        var spinner:Spinner = spinner1

        // (contex, array, layout)
        var adapter:ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,
            R.array.numbers, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // click listener
        spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var text:String = parent!!.getItemAtPosition(position).toString()
        Toast.makeText(parent.context, text, Toast.LENGTH_SHORT).show()
    }


    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun kotlinVersionClicked(view: View) {
        val intent = Intent(this, DropDownMenuKotlinVersionActivity::class.java)
        startActivity(intent)
    }
}
