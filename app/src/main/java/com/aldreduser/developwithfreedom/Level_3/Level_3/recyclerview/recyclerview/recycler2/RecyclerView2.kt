package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level3_activity_recycler_view2.*
import java.util.ArrayList

//https://www.youtube.com/watch?v=Vyqz_-sJGFk
// onclicklistener https://www.youtube.com/watch?v=69C1ljfDvl0&t=82s
//this is the second recyclerview. THE ONCLICKLISTENER IS NOT OPTIMIZED HERE. Also, adapter is in java.

class RecyclerView2 : AppCompatActivity() {
    private val mNames = ArrayList<String>()
    private val mImageUrls = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level3_activity_recycler_view2)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = recycler_view2
        val adapter = Adapter2(this, mNames, mImageUrls)    //context, image names, image urls
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
