package ch.nyemeck.booksapplication.network.response

import ch.nyemeck.booksapplication.network.model.BookNetwork
import com.google.gson.annotations.SerializedName

data class BookSearchResponse(
    @SerializedName("totalItems")
    var numberOfBooks: Int,

    @SerializedName("items")
    var books: List<BookNetwork>


)
