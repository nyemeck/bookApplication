package ch.nyemeck.booksapplication.repository

import android.util.Log
import ch.nyemeck.booksapplication.database.BookDao
import ch.nyemeck.booksapplication.database.BookDatabaseMapper
import ch.nyemeck.booksapplication.presentation.models.Book
import ch.nyemeck.booksapplication.network.BookService
import ch.nyemeck.booksapplication.network.model.BookNetworkMapper

class BookRepositoryImpl (
    private val bookService: BookService,
    private val bookDao: BookDao,
    private val networkMapper: BookNetworkMapper,
    private val bookDatabaseMapper: BookDatabaseMapper
        ):  BookRepository{

    override suspend fun search(query: String): List<Book> {
        val bookSearchResponse = bookService.searchBooks(query)
        Log.d("BookRepositoryImpl", "search: $bookSearchResponse")
        return networkMapper.toDomainList(bookSearchResponse.books)
    }

    override suspend fun insert(book: Book):Long {
        return bookDao.insert(bookDatabaseMapper.mapFromDomainModel(book))
    }

    override suspend fun getBooks(): List<Book> {
        return bookDatabaseMapper.toDomainList(bookDao.get())
    }
}