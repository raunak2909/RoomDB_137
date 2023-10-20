package gov.rajasthan.roomdb_137

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {

    @Insert
    fun addNote(newNote: NoteTable)

    @Query("select * from note")
    fun getAllNotes() : List<NoteTable>

    @Update
    fun updateNote(updateNote: NoteTable)

    @Delete
    fun deleteNote(note: NoteTable)

}