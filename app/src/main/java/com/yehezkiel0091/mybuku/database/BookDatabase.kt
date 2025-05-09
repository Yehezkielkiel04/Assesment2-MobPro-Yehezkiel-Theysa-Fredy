package com.yehezkiel0091.mybuku.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yehezkiel0091.mybuku.model.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDatabase : RoomDatabase() {

    abstract val dao: BookDao

    companion object {
        @Volatile
        private var INSTANCE: BookDatabase? = null

        fun getInstance(context: Context): BookDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BookDatabase::class.java,
                        "books.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
