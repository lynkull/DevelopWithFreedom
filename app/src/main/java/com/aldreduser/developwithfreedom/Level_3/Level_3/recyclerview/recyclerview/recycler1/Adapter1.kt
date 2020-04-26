package com.aldreduser.developwithfreedom.Level_3.Level_3.recyclerview.recyclerview.recycler1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level3_recyclerview_item1.view.*

class Adapter1(val nContext:Context, val textx:ArrayList<String>, val images:ArrayList<Int>): RecyclerView.Adapter<Adapter1.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val callForRow = inflater.inflate(R.layout.level3_recyclerview_item1, parent, false)
        return ViewHolder(callForRow)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //it might be more efficient to have this inside the ViewHolder
        holder.itemView.texts.text = textx.get(position)
        holder.itemView.images.setImageResource(images.get(position))
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return textx.size
    }

    public class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}