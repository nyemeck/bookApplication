package ch.nyemeck.booksapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "subtitle")
    val subtitle: String,

    @ColumnInfo(name = "thumbnail")
    val thumbnail: String?,

)
