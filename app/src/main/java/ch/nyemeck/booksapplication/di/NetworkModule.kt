package ch.nyemeck.booksapplication.di

import ch.nyemeck.booksapplication.network.BookService
import ch.nyemeck.booksapplication.network.model.BookNetworkMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{
    @Singleton
    @Provides
    fun provideBookMapper():BookNetworkMapper{
        return BookNetworkMapper()
    }

    @Singleton
    @Provides
    fun provideBookService():BookService{
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient)
            .build()
            .create(BookService::class.java)
    }
}