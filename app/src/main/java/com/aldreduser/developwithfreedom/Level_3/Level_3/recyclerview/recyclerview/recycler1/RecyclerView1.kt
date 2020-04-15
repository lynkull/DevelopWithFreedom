package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler1.Adapter1
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level3_activity_recycler_view1.*

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

class RecyclerView1 : AppCompatActivity() {
    private var textx:ArrayList<String> = ArrayList()
    private var images:ArrayList<Int> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level3_activity_recycler_view1)

        loadData()
        val adapter =
            Adapter1(
                this,
                textx,
                images
            )

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
