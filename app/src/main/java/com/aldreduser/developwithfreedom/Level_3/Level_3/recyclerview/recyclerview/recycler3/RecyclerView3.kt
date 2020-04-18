package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level3_activity_recycler_view3.*

//this recyclerview listens to clicks on two widgets in each recyclerView item

class RecyclerView3 : AppCompatActivity() {
    private val mTexts = ArrayList<String>()
    private val mImages = ArrayList<Int>()
//    private val mOnImageClickListener: Adapter3.OnImageListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level3_activity_recycler_view3)

        loadData()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val recyclerView = recycler_view3
        val adapter = Adapter3(mTexts, mImages)    //image names, image urls, listener interface (this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

//    override fun onImageClick(position: Int) {
//        //what happens when clicked
//        val imagePosition = mImages.get(position)
//        Toast.makeText(this, "Image was clicked at position $position", Toast.LENGTH_LONG).show()
////        //if you were to make it open a new activity on click
////        val intent = Intent(this, <name of other activity>::class.java)
////        startActivity(intent)
////
////        //<name of array widget declared as a variable in an array in this class>.get(position)    //if want to access the widget that was selected
//    }

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
