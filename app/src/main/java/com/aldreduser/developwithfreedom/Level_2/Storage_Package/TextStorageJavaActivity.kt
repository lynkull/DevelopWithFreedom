package com.aldreduser.developwithfreedom.Level_2.Storage_Package

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.activity_text_storage_java.*
import java.io.*
import java.lang.StringBuilder

// this is the java style of saving an ediitext

//there's a problem loading
//https://www.youtube.com/watch?v=EcfUkjlL9RI&t=222s

class TextStorageJavaActivity : AppCompatActivity() {
    private val FILE_NAME = "javaExample.txt"
    var mEditText:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_storage_java)

        mEditText = edit_text
    }

    fun save(view: View) {
        var text = mEditText!!.text.toString()
        var fos:FileOutputStream? = null       // ignore this  to do()

        try {
            fos = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
            fos.write(text.toByteArray())

            mEditText!!.text.clear()
            Toast.makeText(this, "Save to $filesDir/$FILE_NAME", Toast.LENGTH_LONG).show() //filesDir might not work
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } finally {
            if (fos != null) {
                fos.close()
            }
        }

    }
    fun load(view: View) {
        var fis:FileInputStream = openFileInput(FILE_NAME)        // ignore this  to do()

        try {
            var isr:InputStreamReader = InputStreamReader(fis)
            var br:BufferedReader = BufferedReader(isr)
            var sb:StringBuilder = StringBuilder()
            var text:String? = null

            while ((text == br.readLine()) != null) {
                sb.append(text).append("\n")
            }

            mEditText!!.setText(sb.toString())

        } catch (e:FileNotFoundException) {
            e.printStackTrace()
        } finally {
            if (fis != null){
                fis.close()
            }
        }
    }
}
