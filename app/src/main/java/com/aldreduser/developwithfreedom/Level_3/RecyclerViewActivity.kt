package com.aldreduser.developwithfreedom.Level_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level3_activity_recycler_view.*

// made a drawable xml, and level3_recyclerview_item1.xml

class RecyclerViewActivity : AppCompatActivity() {
    var textx:ArrayList<String> = ArrayList()
    var images:ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level3_activity_recycler_view)

        loadData()
        val adapter = Adapter(this, textx, images)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

    private fun loadData() {
        textx.add("Text 1")
        images.add(R.drawable.ic_launcher_background)
        textx.add("Text 2")
        images.add(R.drawable.ic_launcher_background)
        textx.add("Text 3")
        images.add(R.drawable.ic_launcher_background)
        textx.add("Text 4")
        images.add(R.drawable.ic_launcher_background)
        textx.add("Text 5")
        images.add(R.drawable.ic_launcher_background)
        textx.add("Text 6")
        images.add(R.drawable.ic_launcher_background)
        textx.add("Text 7")
        images.add(R.drawable.ic_launcher_background)
        textx.add("Text 8")
        images.add(R.drawable.ic_launcher_background)
    }


}
