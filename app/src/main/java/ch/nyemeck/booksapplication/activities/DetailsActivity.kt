package ch.nyemeck.booksapplication.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.nyemeck.booksapplication.adapters.EXTRA_BOOK_SUBTITLE
import ch.nyemeck.booksapplication.adapters.EXTRA_BOOK_THUMBNAIL
import ch.nyemeck.booksapplication.adapters.EXTRA_BOOK_TITLE
import ch.nyemeck.booksapplication.databinding.ActivityDetailsBinding
import ch.nyemeck.booksapplication.models.Book

class DetailsActivity : AppCompatActivity() {
    private lateinit var activityDetailsBinding: ActivityDetailsBinding
    private lateinit var book : Book
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailsBinding = ActivityDetailsBinding.inflate(layoutInflater)

        setContentView(activityDetailsBinding.root)

        book = Book(
            intent.getStringExtra(EXTRA_BOOK_TITLE)?:"No title",
            intent.getStringExtra(EXTRA_BOOK_SUBTITLE)?:"No subtitle",
            intent.getStringExtra(EXTRA_BOOK_THUMBNAIL)?:""
        )
        activityDetailsBinding.bookDetailsItem = book

    }

}