package ch.nyemeck.booksapplication.di

import ch.nyemeck.booksapplication.database.BookDao
import ch.nyemeck.booksapplication.database.BookDatabaseMapper
import ch.nyemeck.booksapplication.network.BookService
import ch.nyemeck.booksapplication.network.model.BookNetworkMapper
import ch.nyemeck.booksapplication.repository.BookRepository
import ch.nyemeck.booksapplication.repository.BookRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideBookRepository(
        bookService: BookService,
        bookDao: BookDao,
        bookNetworkMapper: BookNetworkMapper,
        bookDatabaseMapper: BookDatabaseMapper
    ) : BookRepository{
        return BookRepositoryImpl(
            bookService,
            bookDao,
            bookNetworkMapper,
            bookDatabaseMapper
        )
    }
}