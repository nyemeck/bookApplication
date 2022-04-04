package ch.nyemeck.booksapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bookEntity: BookEntity):Long

    @Query("SELECT * FROM book_table")
    suspend fun get(): List<BookEntity>
}