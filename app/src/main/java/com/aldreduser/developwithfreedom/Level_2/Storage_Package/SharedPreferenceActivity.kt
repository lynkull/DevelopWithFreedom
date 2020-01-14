package com.aldreduser.developwithfreedom.Level_2.Storage_Package

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldreduser.developwithfreedom.R

// shared preference
/*
uses key value pairs to store data

works for primitive data

- getPreferences()      use if you need only one sharedPreference file for the activity. Works with a default file that belongs to the activity.
- getSharedPreferences()    for multiple shared preference files identified by name, specified with the first parameter. Can call this from any context in the app

get and put files from sharedPreferences

 */

class SharedPreferenceActivity(context: Context) : AppCompatActivity() {

    val PREFERENCE_NAME = "SharedPreferenceExampleOne"  // this is the key
    val PREFERENCE_LOGIN_COUNT = "LoginCount"
    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)
    }

    /*fun multiplePreferences() {
        val PREFERENCE_NAME = "SharedPreferenceExampleOne"  // this is the key
        val PREFERENCE_LOGIN_COUNT = "LoginCount"
    }*/

    fun getLoginCount() : Int {
        return preference.getInt(PREFERENCE_LOGIN_COUNT, 0)
    }
    fun setLoginCount(count:Int) {
        val editor = 
    }
}
