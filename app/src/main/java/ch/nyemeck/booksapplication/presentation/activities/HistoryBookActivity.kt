package ch.nyemeck.booksapplication.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.nyemeck.booksapplication.presentation.adapters.BookRecyclerViewAdapter
import ch.nyemeck.booksapplication.presentation.adapters.EXTRA_BOOK_SUBTITLE
import ch.nyemeck.booksapplication.presentation.adapters.EXTRA_BOOK_THUMBNAIL
import ch.nyemeck.booksapplication.presentation.adapters.EXTRA_BOOK_TITLE
import ch.nyemeck.booksapplication.databinding.ActivityHistoryBookBinding
import ch.nyemeck.booksapplication.presentation.view_model.HistoryBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryBookActivity : AppCompatActivity() {
    private lateinit var historyBookActivityBinding: ActivityHistoryBookBinding
    private lateinit var recyclerViewLayoutManager: RecyclerView.LayoutManager
    private val historyBookViewModel: HistoryBookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        historyBookActivityBinding = ActivityHistoryBookBinding.inflate(layoutInflater)
        setContentView(historyBookActivityBinding.root)
        val bookAdapter = BookRecyclerViewAdapter(listOf()){
                book ->
            val intent = Intent(this, DetailsActivity::class.java).apply{
                putExtra(EXTRA_BOOK_TITLE,book.title)
                putExtra(EXTRA_BOOK_SUBTITLE,book.subtitle)
                putExtra(EXTRA_BOOK_THUMBNAIL,book.thumbnail)
            }
            this.startActivity(intent)
        }
        recyclerViewLayoutManager = LinearLayoutManager(this)
        historyBookActivityBinding.recyclerHistoryBookList.apply {
            adapter = bookAdapter
            layoutManager = recyclerViewLayoutManager
        }
        historyBookViewModel.getBooks()
        historyBookViewModel.booksMutableLiveData.observe(this, Observer {
            bookList ->
            if(bookList.isNotEmpty()){
                bookAdapter.swapDataSet(bookList)
            }
        })
    }
}