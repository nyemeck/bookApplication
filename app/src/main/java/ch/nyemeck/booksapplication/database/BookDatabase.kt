package ch.nyemeck.booksapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [BookEntity::class], version = 1)
abstract class BookDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao
    companion object{
        val DATABASE_NAME: String = "book_ddb"
    }
}