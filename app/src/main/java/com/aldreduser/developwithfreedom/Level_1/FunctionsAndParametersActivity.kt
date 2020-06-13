package com.aldreduser.developwithfreedom.Level_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.activity_functions_and_parameters.*

// include recursion

class FunctionsAndParametersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_functions_and_parameters)

        average(4.6, 9.0)
        betterAverage(7.0, 20.0)

        var numbersToAdd = listOf<Int>(34, 5, 48, 1, 31, 2423, 535, 3)
        addAllNumbers(numbersToAdd)

        foo(::bar)
    }

    fun average(a: Double, b: Double): Double {
        return (a+b)/2
    }

    fun betterAverage(a: Double, b: Double) = (a+b)/2

    fun addAllNumbers(numbers: List<Int>) {
        var sum:Int = 0

        for(item in numbers){
            sum += item
        }
        textView15.text = "$sum"
    }

    // pass functions as parameters
    fun foo(function: () -> (Unit)) {
        function()
    }
    fun bar() {
        println("Hello World")
    }

    //companion object
    class companionObjectClass {
        companion object {

            private val companionObjectValue = "kfenekfnke"

            @JvmStatic
            fun showHello() {
                println("Hello")
            }
        }
    }
    fun compObjectOutput() {
        companionObjectClass.showHello()
    }
    /* @JvmStatic: On the JVM you can have members of companion objects generated as real static methods and fields, if you use the @JvmStatic annotation.
    and then it will exist as a real Java static function, accessible from both Java and Kotlin as ClassName.functionName()
    Can have a name for the companion object:    companion object {}       or        companion object Blah {}                Foo.Blah.a()
    */

    //i didn't understand this one
    /*fun foo(m: String, bar: (m: String) -> Unit) {
        bar(m)
    }
    fun buz(m: String) {
        println("another message: $m")
    }
    fun something() {
        foo("hi", ::buz)
    }*/
}
