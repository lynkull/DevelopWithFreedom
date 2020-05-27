package com.aldreduser.developwithfreedom.Level_2.Storage_Package.roomStorage;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//Dao has to be either interfaces or abstract classes (with Room)
@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);
    @Update
    void update(Note note);
    @Delete
    void delete(Note note);

    //this is optional, to delete all entries
    @Query("DELETE FROM note_table") //if there's nothing between "DELETE FROM", all entries are deleted
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC") // '*' means all columns  //'DESC' means descending
    LiveData<List<Note>> getAllNotes();
}
