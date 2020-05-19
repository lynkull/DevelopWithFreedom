package com.aldreduser.developwithfreedom.Level_2.Storage_Package

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aldreduser.developwithfreedom.R

// using ROOM

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
Summary of the app:
    Note taking app
        -each note has a title, description, and note number
        -stored in SQLite
        -displayed in recyclerView
    Can add new notes
    Can modify existing notes.
    Can delete notes
    Can delete all notes (in options toolbar )
 */

class SQLitePt1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.level2_activity_sqlite1)
    }
}
