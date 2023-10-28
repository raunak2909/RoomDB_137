package gov.rajasthan.roomdb_137

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(val repository: NoteRepository) : ViewModel(){

    fun addNewNote(noteTable: NoteTable){
        repository.addNewNote(noteTable)
    }

    fun getAllNotes(): LiveData<List<NoteTable>>{
        return repository.getAllNotes()
    }

    fun deleteNote(noteTable: NoteTable){
        repository.deleteNote(noteTable)
    }



}