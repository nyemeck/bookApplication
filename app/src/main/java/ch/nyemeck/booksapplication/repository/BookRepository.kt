package ch.nyemeck.booksapplication.repository

import ch.nyemeck.booksapplication.presentation.models.Book

interface BookRepository {
    suspend fun search(query: String):List<Book>
    suspend fun insert(book: Book):Long
    suspend fun getBooks(): List<Book>
}