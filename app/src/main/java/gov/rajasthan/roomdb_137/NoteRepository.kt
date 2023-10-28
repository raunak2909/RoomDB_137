package gov.rajasthan.roomdb_137

import androidx.lifecycle.LiveData

class NoteRepository(val db: MyRoomDatabase) {

    fun addNewNote(noteTable: NoteTable){
        db.NoteDao().addNote(noteTable)
    }

    fun getAllNotes(): LiveData<List<NoteTable>>{
        return db.NoteDao().getAllNotes()
    }

    fun deleteNote(noteTable: NoteTable){
        db.NoteDao().deleteNote(noteTable)
    }

}