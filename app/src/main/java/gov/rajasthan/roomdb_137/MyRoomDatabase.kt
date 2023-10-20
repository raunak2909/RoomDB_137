package gov.rajasthan.roomdb_137

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteTable::class], exportSchema = false, version = 1)
abstract class MyRoomDatabase : RoomDatabase() {

    abstract fun NoteDao(): NoteDao

    companion object {

        const val DB_NAME = "noteDB"
        var DB_INSTANCE: MyRoomDatabase? = null

        fun getInstance(context: Context): MyRoomDatabase {

            //initialize ROOM DB
            if (DB_INSTANCE == null) {
                DB_INSTANCE = Room.databaseBuilder(
                    context,
                    MyRoomDatabase::class.java,
                    DB_NAME
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return DB_INSTANCE!!

        }


    }

}