package com.aldreduser.developwithfreedom.Level_2.Storage_Package.roomStorage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

/*
Our activity will only have a reference to the viewmodel, not to the repository

when running Asynchronous operations:
ViewModel is useful in stopping memory leaks by avoiding to hold needless objects in memory
By putting the data into a viewModel it doesn't get lost and don't have to interrupt anything when a configuration change happens

the viewModel is only removed from memory when the lifecycle of the current activity is over (when an activity is finished or a fragment is detached)
 */
//(avoid memory leak) you should never store a context of an activity or a view that references an activity in the viewmodel bc the viewmodel is designed to outlive an activity

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }

    public void insert(Note note) {
        repository.insert(note);
    }
    public void update(Note note) {
        repository.update(note);
    }
    public void delete(Note note) {
        repository.delete(note);
    }
//    public void deleteAllNotes(Note note) { repository.deleteAllNotes(); }
    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }
    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
