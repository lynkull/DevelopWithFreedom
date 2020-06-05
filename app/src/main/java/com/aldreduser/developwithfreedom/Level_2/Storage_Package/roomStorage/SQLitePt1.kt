package com.aldreduser.developwithfreedom.Level_2.Storage_Package.roomStorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldreduser.developwithfreedom.R
import com.aldreduser.developwithfreedom.Level_2.Storage_Package.roomStorage.NoteViewModel
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

class SQLitePt1 : AppCompatActivity() {
    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2_activity_sqlite1)

        recycler_view_room_notes.layoutManager = LinearLayoutManager(this)
        recycler_view_room_notes.setHasFixedSize(true) //if you know the recyclerview size wont change

        val adapter:NoteAdapter
        recycler_view_room_notes.adapter = adapter

        //get a reference to the viewModel in the activity
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        //attach the observer to the liveData
        noteViewModel.allNotes.observe(this, Observer<List<Note>>() {
            @Override
            fun onChanged(@Nullable notes: List<Note>) {
                //this is triggered whenever the data in our liveData object changes
                //todo: update recyclerview
            }
        })
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