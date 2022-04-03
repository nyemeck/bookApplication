package ch.nyemeck.booksapplication.repository

import android.util.Log
import ch.nyemeck.booksapplication.models.Book
import ch.nyemeck.booksapplication.network.BookService
import ch.nyemeck.booksapplication.network.model.BookDtoMapper

class BookRepositoryImpl (
    private val bookService: BookService,
    private val mapper: BookDtoMapper
        ):  BookRepository{

    override suspend fun search(query: String): List<Book> {
        val bookSearchResponse = bookService.searchBooks(query)
        Log.d("BookRepositoryImpl", "search: $bookSearchResponse")
        return mapper.toDomainList(bookSearchResponse.books)
    }
}