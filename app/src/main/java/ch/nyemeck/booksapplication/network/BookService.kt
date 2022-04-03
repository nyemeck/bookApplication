package ch.nyemeck.booksapplication.network
import ch.nyemeck.booksapplication.network.response.BookSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {

    @GET("volumes")
    suspend fun searchBooks(@Query("q") searchBook: String):BookSearchResponse
}