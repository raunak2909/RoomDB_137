package gov.rajasthan.roomdb_137

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "note_title")
    val title: String,

    val desc: String
)
