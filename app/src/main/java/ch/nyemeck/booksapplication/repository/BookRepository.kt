package ch.nyemeck.booksapplication.repository

import ch.nyemeck.booksapplication.models.Book

interface BookRepository {
    suspend fun search(query: String):List<Book>
}