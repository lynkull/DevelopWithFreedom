package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler1.RecyclerView1
import com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler2.RecyclerView2
import com.aldreduser.developwithfreedom.R

/*
recyclerview has:
-mainFile
-Main xml layout
-item xml layout
-adapter file
 */
/*
with onclicklistener (best practice):
-there should be an interface inside ViewHolder in the Adapter
 */

class RecyclerHomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level3_activity_recycler_home_screen)
    }

    fun recyclerOneClicked(view: View){
        val intent = Intent(this, RecyclerView1::class.java)
        startActivity(intent)
    }
    fun recyclerTwoClicked(view: View){
        val intent = Intent(this, RecyclerView2::class.java)
        startActivity(intent)
    }
}
