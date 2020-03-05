package com.aldreduser.developwithfreedom.Level_3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level3_recyclerview_item.view.*

class Adapter(val nContext:Context,
              val textx:ArrayList<String>,
              val images:ArrayList<Int>): RecyclerView.Adapter<Adapter.viewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val callForRow = inflater.inflate(R.layout.level3_recyclerview_item, parent, false)
        return viewHolder(callForRow)
    }

    //this method is binding the data on the list
    override fun getItemCount(): Int {
        return textx.size
    }

    //this method is giving the size of the list
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.itemView.texts.text = textx.get(position)
        holder.itemView.images.setImageResource(images.get(position))
    }

    public class viewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}