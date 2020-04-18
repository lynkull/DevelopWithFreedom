package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler2.Adapter2.OnImageListener
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level3_activity_recycler_view2.*
import java.util.*

// https://www.youtube.com/watch?v=Vyqz_-sJGFk
// onClickListener https://www.youtube.com/watch?v=69C1ljfDvl0&t=82s
// this is the recyclerview with clickListener of only one widget each recyclerView item.

class RecyclerView2 : AppCompatActivity(), OnImageListener {
    private val mTexts = ArrayList<String>()
    private val mImages = ArrayList<Int>()
    private val mOnImageListener: OnImageListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level3_activity_recycler_view2)

        loadData()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = recycler_view2
        val adapter = Adapter2(mTexts, mImages, this)    //image names, image urls, listener interface
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onImageClick(position: Int) {
        //what happens when clicked
        val imagePosition = mImages.get(position)
        Toast.makeText(this, "Image was clicked at position $position", Toast.LENGTH_LONG).show()
//        //if you were to make it open a new activity on click
//        val intent = Intent(this, <name of other activity>::class.java)
//        startActivity(intent)
//
//        //<name of array widget declared as a variable in an array in this class>.get(position)    //if want to access the widget that was selected
    }

    private fun loadData() {
        mTexts.add("Text 1")
        mImages.add(R.drawable.ic_launcher_background)
        mTexts.add("Text 2")
        mImages.add(R.drawable.ic_launcher_background)
        mTexts.add("Text 3")
        mImages.add(R.drawable.ic_launcher_background)
        mTexts.add("Text 4")
        mImages.add(R.drawable.ic_launcher_background)
        mTexts.add("Text 5")
        mImages.add(R.drawable.ic_launcher_background)
        mTexts.add("Text 6")
        mImages.add(R.drawable.ic_launcher_background)
        mTexts.add("Text 7")
        mImages.add(R.drawable.ic_launcher_background)
        mTexts.add("Text 8")
        mImages.add(R.drawable.ic_launcher_background)
    }
}
