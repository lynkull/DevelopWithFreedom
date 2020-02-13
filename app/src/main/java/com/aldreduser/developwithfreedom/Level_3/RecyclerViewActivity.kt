package com.aldreduser.developwithfreedom.Level_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aldreduser.developwithfreedom.R

// made a drawable xml, and level3_recyclerview_item1.xml

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level3_activity_recycler_view)
    }

    fun recycler2ButtonClicked(view: View) {
        val intent = Intent(this, BetterRecyclerView2::class.java)
        startActivity(intent)
    }
}
