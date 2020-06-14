package com.aldreduser.developwithfreedom.Level_2.Storage_Package.roomStorage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldreduser.developwithfreedom.R
import kotlinx.android.synthetic.main.level2_activity_sqlite1.*


// Using ROOM

//https://www.youtube.com/watch?v=Jwdty9jQN0E&t=289s
//the ROOM framework is an abstraction over the SQLite database
//https://developer.android.com/training/data-storage/room
//https://developer.android.com/training/data-storage/sqlite
// SQLite saves data into a text file

/*
The most common use case is to cache relevant pieces of data. That way, when the device
 cannot access the network, the user can still browse that content while they are offline.
 */
/*
Room annotations and main components:
 1   @Database — Represent a database holder
 2   @Entity — Represents a table in the database
 3   @DAO — (Data Access Object) Provide an API for reading and writing data. A DAO interface is needed for every Entity,
                contains functions to access the database.
 1 @Database: define all the entities there are in the database. Also define the version of the database.
                Has a DAO abstract function.
 2 @Entity: is a data class. Define all the variables for the columns of the table (ie. id, address, fName, lName).
 3 @DAO: contains all the functions to manipulate the database.
 */
/*
Dependencies:
(better to use androidx dependencies instead)
https://developer.android.com/topic/libraries/architecture/adding-components
 -lifecycle: def lifecycle_version...
    // ViewModel
    // LiveData
    // Annotation processor
 -room: def room_version...
    //implementation
    //annotationProcessor

implementation 'com.google.android.material:material:1.2.0-alpha06' //(this one might not work)
implementation 'androidx.cardview:cardview:1.0.0'
 */
/*
Summary of the app:
    Note taking app
        -each note has a title, description, and note number
        -stored in SQLite (Room)
        -displayed in recyclerView
    Can add new notes
    Can modify existing notes.
    Can delete notes
    Can delete all notes (in options toolbar )
 */

//note: this app feature doesn't work well bc i think i hid the toolbar at a global level and the tutorial uses it for a lot
class SQLitePt1 : AppCompatActivity() {
    val ADD_NOTE_REQUEST: Int = 1
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2_activity_sqlite1)

        //click add note and open new activity
        button_add_note.setOnClickListener{
            val intent: Intent = Intent(this, AddNoteActivity::class.java)
            startActivityForResult(intent, ADD_NOTE_REQUEST)
        }

        recycler_view_room_notes.layoutManager = LinearLayoutManager(this)
        recycler_view_room_notes.setHasFixedSize(true) //if you know the recyclerview size wont change (makes recyclerview more efficient)

        val adapter:NoteAdapter = NoteAdapter()
        recycler_view_room_notes.adapter = adapter

        //get a reference to the viewModel in the activity
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        //attach the observer to the liveData
        noteViewModel.allNotes.observe(this, Observer<List<Note>>() {
            @Override
            fun onChanged(@Nullable notes: List<Note>) {
                //this is triggered whenever the data in our liveData object changes
                //update recyclerview
                adapter.setNotes(notes)
            }
        })

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback( 0, ItemTouchHelper.LEFT ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                noteViewModel.delete(adapter.getNoteAt(viewHolder.adapterPosition))
            }
        }).attachToRecyclerView(recycler_view_room_notes)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK) {
            var title:String = data?.getStringExtra(AddNoteActivity.EXTRA_TITLE) ?: "ERROR"
            var description:String = data?.getStringExtra(AddNoteActivity.EXTRA_DESCRIPTION) ?: "ERROR"
            var priority:Int = data?.getIntExtra(AddNoteActivity.EXTRA_PRIORITY, 1) ?: 1

            var note:Note = Note(title, description, priority)
            noteViewModel.insert(note)

            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
        } else {
            // if resultCode == Activity.RESULT_CANCELED
            Toast.makeText(this, "Note not saved", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater:MenuInflater = menuInflater
        menuInflater.inflate(R.menu.main_menu, menu)
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.delete_all_notes -> {noteViewModel.deleteAllNotes();
                Toast.makeText(this,  "All notes deleted", Toast.LENGTH_SHORT).show();
                return true}
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}

/*
This room architecture:
-Activity
-ViewModel
-Repository
-(Room (SQLite entities <-> DAO))

Created Note class and annotated it @Entity
    -(Room creates an SQLite Table for it)
The repository uses the notes @Dao to retrieve all the entries from the note table (as a list wrapped into liveData)
ViewModel retrieves the same liveData object from the Repository and caches it for the activity
The activity doesn't store the data (it observes the liveData stored in the ViewModel) and is automatically updated when the database data changes.
 */