package com.aldreduser.developwithfreedom.Level_2.Storage_Package

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level2_activity_get_preferences.*

class GetPreferencesActivity : AppCompatActivity() {

    val prefFileName = "Notes"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2_activity_get_preferences)

        getData()
    }

    fun loadButtonClicked(view: View) {
        getData()
    }
    fun saveButtonClicked(view: View) {
        saveData()
    }

    fun saveData() {
        val thisActSharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with(thisActSharedPref.edit()) {
            putString(prefFileName, textBoxToSave.text.toString())
            commit()
            // saved
        }
    }
    fun getData() {
        val thisActSharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        textBoxToSave.setText(thisActSharedPref.getString(prefFileName, ""))  //the second parameter is the default value
    }
}
