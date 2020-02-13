package com.aldreduser.developwithfreedom.Level_3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level3_better_recyclerview_country_child.view.*

//level3_activity_better_recycler_view2
//level3_activity_better_recyclerview_country_child

/*
have:
-recyclerview file
-RecyclerAdapter file
    -3 required functions
    -viewholder class (has views in variables, ie TextView)
-one xml layout for all the views

 */

class BetterRecyclerView2 : AppCompatActivity() {

    lateinit var country_list : RecyclerView
    var countries:MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level3_activity_better_recycler_view2)
        loadData()

        country_list = findViewById(R.id.country_list) as RecyclerView
        country_list.layoutManager = LinearLayoutManager(this)
   //     country_list.layoutManager = GridLayoutManager(this, 2) //num of columns
        country_list.adapter =
            CountryAdapter(
                countries,
                this
            ) //populate the recyclerview
    }

    class CountryAdapter(items : List<String>, ctx:Context) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

        var list = items
        var contex = ctx

        override fun getItemCount(): Int {
            return list.size
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder?.name?.text = list.get(position)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(contex).inflate(
                    R.layout.level3_better_recyclerview_country_child,
                    parent,
                    false
                )
            )
        }

        class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
            val name = v.country_name
        }
    }

    fun loadData(){
        countries.add("India")
        countries.add("USA")
        countries.add("Cuba")
        countries.add("Uganda")
        countries.add("Canada")
        countries.add("Spain")
        countries.add("Brazil")
        countries.add("China")
        countries.add("Japan")
        countries.add("Indonesia")
        countries.add("Russia")
        countries.add("Mexico")
        countries.add("Sweden")
        countries.add("Finland")
        countries.add("England")
        countries.add("France")
        countries.add("Norway")
        countries.add("Morocco")
        countries.add("Greenland")
        countries.add("Iceland")
        countries.add("Argentina")
        countries.add("Iran")
        countries.add("Iraq")
        countries.add("Colombia")
        countries.add("Zimbawee")
        countries.add("Italy")
        countries.add("Venezuela")
        countries.add("Peru")
    }
}
