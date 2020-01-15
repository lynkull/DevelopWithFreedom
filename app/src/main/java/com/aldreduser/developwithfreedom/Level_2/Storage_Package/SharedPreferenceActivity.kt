package com.aldreduser.developwithfreedom.Level_2.Storage_Package

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.activity_shared_preference.*

// shared preference
/*
uses key value pairs to store data

works for primitive data

- getPreferences()      use if you need only one sharedPreference file for the activity. Works with a default file that belongs to the activity.
- getSharedPreferences()    for multiple shared preference files identified by name, specified with the first parameter. Can call this from any context in the app

get and put files from sharedPreferences

 */

//in this app, the count goes up when a user opens the app
//https://www.youtube.com/watch?v=Fr5nNnJUlo4&t=198s

/*
ITS BETTER TO HAVE AN INDEPENDENT CLASS FOR getSharedPreferences()
 */

class SharedPreferenceActivity() : AppCompatActivity() {

    val PREFERENCE_NAME = "SharedPreferenceExampleOne"  // this is the name of the preference file
    val PREFERENCE_LOGIN_COUNT = "LoginCount"       //
    var preference:SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        preference = this.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

        var loginCount = getLoginCount()
        loginCount++
        setLoginCount(loginCount)
        tv_count.text = loginCount.toString()
    }

    // retrieve a value from sharedPreferences
    fun getLoginCount() : Int {
        var value = preference!!.getInt(PREFERENCE_LOGIN_COUNT, 0)      //might be null
        return value
    }

    // save a value to sharedPreferences
    fun setLoginCount(count:Int) {
        val editor = preference!!.edit()        //I guess you need an editor to change it
        editor.putInt(PREFERENCE_LOGIN_COUNT, count)
        editor.apply()      //close the editor
    }
}
