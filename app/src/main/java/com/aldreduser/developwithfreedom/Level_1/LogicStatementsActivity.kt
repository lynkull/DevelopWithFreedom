package com.aldreduser.developwithfreedom.Level_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldreduser.developwithfreedom.R
import java.util.*

class LogicStatementsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level1_activity_logic_statements)
        Thread.sleep(1000) // one second pause
    }

    fun ifStatement() {
        var a = 4; var b = 7
        var max1: Int

        // if else statement
        if (a > b) {
            max1 = a
        } else if (a < b) {
            max1 = b
        } else {
            println("a == b")
        }

        // as expression
        val max2 = if (a > b) a else b
    }

    fun whenStatement () {
        // similar to switch statements
        var rnd = Random()
        var x = rnd.nextInt(20) + 1
        when (x) {
            1 -> println(" x == 1")
            2 -> println(" x == 2")
            3,4,5 -> println("3, 4, or 5")
            in 10..20 -> println("10 to 20")
            else -> {
                println("x is neither 1 nor 2")
            }
        }
    }

    fun forLoop() {
        for (i in 1..5){
            println(i)
        }
        for (i in 6 downTo 0 step 2) {
            // can skip numbers
            // can descend
            println(i)
        }

        var numGroup = arrayOf(2, 6, 9, 95, 4, 23)
        // prints every item in a collection
        for (item in numGroup) println(item)

        for (item in  numGroup) {

        }
    }

    fun whileLoop() {
        var x = 8
        while ( x > 0) {
            x --
        }

        var y = 45
        do {
            y --
        } while (y > 10)
    }
}
