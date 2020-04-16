package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler2.Adapter2.OnNoteListener
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level3_activity_recycler_view2.*
import java.util.*

//https://www.youtube.com/watch?v=Vyqz_-sJGFk
// onclicklistener https://www.youtube.com/watch?v=69C1ljfDvl0&t=82s
//this is the second recyclerview.

//todo: maybe declare that this activity implements OnNoteClicked interface
class RecyclerView2 : AppCompatActivity(), Adapter2.OnNoteListener {
    private val mNames = ArrayList<String>()
    private val mImageUrls = ArrayList<String>()
    private val mOnNoteListener: OnNoteListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level3_activity_recycler_view2)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = recycler_view2
        val adapter = Adapter2(this, mNames, mImageUrls, mOnNoteListener)    //context, image names, image urls
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onNoteClick(position: Int) {
//        //if you were to make it open a new activity on click
//        val intent = Intent(this, <name of other activity>::class.java)
//        startActivity(intent)
//
//        //<name of array widget declared as a variable in an array in this class>.get(position)    //if want to access the widget that was selected
    }
}
