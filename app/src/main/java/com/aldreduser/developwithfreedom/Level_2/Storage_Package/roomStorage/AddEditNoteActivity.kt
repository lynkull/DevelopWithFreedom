package com.aldreduser.developwithfreedom.Level_2.Storage_Package.roomStorage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.activity_add_note.*

class AddEditNoteActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        public val EXTRA_ID =
            "com.aldreduser.developwithfreedom.Level_2.Storage_Package.roomStorage.EXTRA_ID"
        //key for intent extra (best practice is to use the package name + '.somethingElse')
        @JvmStatic
        public val EXTRA_TITLE =
            "com.aldreduser.developwithfreedom.Level_2.Storage_Package.roomStorage.EXTRA_TITLE"
        @JvmStatic
        public val EXTRA_DESCRIPTION =
            "com.aldreduser.developwithfreedom.Level_2.Storage_Package.roomStorage.EXTRA_DESCRIPTION"
        @JvmStatic
        public val EXTRA_PRIORITY =
            "com.aldreduser.developwithfreedom.Level_2.Storage_Package.roomStorage.EXTRA_PRIORITY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        edit_text_title
        edit_text_description
        number_picker_priority

        number_picker_priority.minValue = 1
        number_picker_priority.maxValue = 10

        //todo: make this work. Maybe i don't really care thb, not hte point if this SQLite feature.
        //  probably bc i did something with the toolbar at a globa; ;evel (like hid it or something)
        //supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_close)
        val intent = intent

        //if the intent contains this id
        if (intent.hasExtra(EXTRA_ID)) {
            title = "Edit Note"
            edit_text_title.setText(intent.getStringExtra(EXTRA_TITLE))
            edit_text_description.setText(intent.getStringExtra(EXTRA_DESCRIPTION))
            number_picker_priority.value = intent.getIntExtra(EXTRA_PRIORITY, 1)
        } else {
            title = "Add Note"
        }
    }

    public fun getExtraTitle(): String {
        return EXTRA_TITLE
    }

    private fun saveNote() {
        var title: String = edit_text_title.text.toString()
        var description: String = edit_text_description.text.toString()
        var priority: Int = number_picker_priority.value

        //title.trim() removes empty spaces at beginning and end of an input
        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT)
            return
        }

        //send data back to the activity tht started this one
        //then send data to the database from that activity
        var data: Intent = Intent()
        data.putExtra(EXTRA_TITLE, title)
        data.putExtra(EXTRA_DESCRIPTION, description)
        data.putExtra(EXTRA_PRIORITY, priority)

        val id:Int = intent.getIntExtra(EXTRA_ID, -1)
        if (id != -1) {
            //if id exists
            data.putExtra(EXTRA_ID, id)
        }

        setResult(Activity.RESULT_OK, data)  //maybe take out 'Activity.' from 'Activity.RESULT_OK'
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.add_note_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //when the save note icon is clicked, saveNote Method is called
        when (item?.itemId) {
            R.id.save_note -> {saveNote(); return true}
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
