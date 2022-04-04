package ch.nyemeck.booksapplication.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.nyemeck.booksapplication.presentation.adapters.BookRecyclerViewAdapter
import ch.nyemeck.booksapplication.presentation.adapters.EXTRA_BOOK_SUBTITLE
import ch.nyemeck.booksapplication.presentation.adapters.EXTRA_BOOK_THUMBNAIL
import ch.nyemeck.booksapplication.presentation.adapters.EXTRA_BOOK_TITLE
import ch.nyemeck.booksapplication.databinding.ActivitySearchBookBinding
import ch.nyemeck.booksapplication.presentation.view_model.SearchBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchBookActivity : AppCompatActivity() {

    private lateinit var searchBookActivityBinding: ActivitySearchBookBinding
    private lateinit var recyclerViewLayoutManager: RecyclerView.LayoutManager
    private val searchBookViewModel: SearchBookViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bookRecyclerViewAdapter = BookRecyclerViewAdapter(listOf()){
            book ->
            searchBookViewModel.insert(book)
            val intent = Intent(this, DetailsActivity::class.java).apply{
                putExtra(EXTRA_BOOK_TITLE,book.title)
                putExtra(EXTRA_BOOK_SUBTITLE,book.subtitle)
                putExtra(EXTRA_BOOK_THUMBNAIL,book.thumbnail)
            }
            this.startActivity(intent)
        }
        searchBookActivityBinding = ActivitySearchBookBinding.inflate(layoutInflater)
        setContentView(searchBookActivityBinding.root)
        recyclerViewLayoutManager = LinearLayoutManager(this)
        searchBookActivityBinding.recyclerViewBookList.apply {
            adapter = bookRecyclerViewAdapter
            layoutManager = recyclerViewLayoutManager
        }
        searchBookViewModel.booksMutableLiveData.observe(this, Observer {
            bookList -> bookRecyclerViewAdapter.swapDataSet(bookList)
        })

        searchBookActivityBinding.imageButtonBookSearchId.setOnClickListener { _->
            val text = searchBookActivityBinding.editTextBookSearchId.text.toString()
            if(text.isNotEmpty()){
                searchBookViewModel.search(text)
            }
        }
        searchBookActivityBinding.buttonHistory.setOnClickListener {
            val intent = Intent(this, HistoryBookActivity::class.java)
            this.startActivity(intent)
        }
    }
}