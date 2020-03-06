package com.aldreduser.developwithfreedom.Level_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level1_activity_programatic_layout.*

/*some ViewGroup Methods:
-addView(view)      -adds a view to the container-
-bringChildToFront(view)        -move view to top of Z-folder-
-getChildAt(index)          -return a view-
-childCount          -return number of children-
-removeAllViews()       -remove all children-
-removeView(view)       -remove a particular child-
-removeViewAt(index)        -remove child at given index-
 */

class ProgramaticLayoutActivity : AppCompatActivity() {
    private val countries = listOf("Australia",
        "Brazil",
        "China",
        "Egypt",
        "France",
        "Germany",
        "Ghana",
        "Italy",
        "Japan",
        "Mexico",
        "Nepal",
        "Nigeria",
        "Spain",
        "United Kingdom",
        "United States")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level1_activity_programatic_layout)

        /*
        val tv = TextView(this)
        tv.text = "Hello Larry!"
        tv.textSize = 3 as Float
        grid_of_flags.addView(tv)
         */

        for (country in countries){
            createFlag(country)
        }
    }

    fun createFlag(countryName: String) {
        val flag = layoutInflater.inflate(R.layout.level1_flag, null)
        val image = flag.findViewById<TextView>(R.id.flag_image)
        image.setOnClickListener {

        }
        val countryNameView = flag.findViewById<TextView>(R.id.country_name)
        val visitedBox = flag.findViewById<CheckBox>(R.id.visited_box)

        val theFlagNonImage = "$countryName's flag"
        image.text = theFlagNonImage
        countryNameView.text = countryName

        grid_of_flags.addView(flag)
    }
}
