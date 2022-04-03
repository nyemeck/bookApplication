package ch.nyemeck.booksapplication.di

import ch.nyemeck.booksapplication.network.BookService
import ch.nyemeck.booksapplication.network.model.BookDtoMapper
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
        bookDtoMapper: BookDtoMapper
    ) : BookRepository{
        return BookRepositoryImpl(
            bookService, bookDtoMapper
        )
    }
}