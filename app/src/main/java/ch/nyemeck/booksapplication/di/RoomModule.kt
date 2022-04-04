package ch.nyemeck.booksapplication.di

import android.content.Context
import androidx.room.Room
import ch.nyemeck.booksapplication.database.BookDao
import ch.nyemeck.booksapplication.database.BookDatabase
import ch.nyemeck.booksapplication.database.BookDatabaseMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule  {

    @Singleton
    @Provides
    fun provideDatabaseBookMapper(): BookDatabaseMapper{
        return BookDatabaseMapper()
    }

    @Singleton
    @Provides
    fun provideBookDatabase(@ApplicationContext context: Context):BookDatabase{
        return Room.databaseBuilder(
            context,
            BookDatabase::class.java,
            BookDatabase.DATABASE_NAME,
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBookDao(bookDatabase: BookDatabase):BookDao{
        return bookDatabase.bookDao()
    }
}