package ch.nyemeck.booksapplication.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.nyemeck.booksapplication.adapters.BookRecyclerViewAdapter
import ch.nyemeck.booksapplication.databinding.ActivitySearchBookBinding
import ch.nyemeck.booksapplication.view_model.SearchBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchBookActivity : AppCompatActivity() {

    private lateinit var searchBookActivityBinding: ActivitySearchBookBinding
    private lateinit var recyclerViewLayoutManager: RecyclerView.LayoutManager
    private val searchBookViewModel: SearchBookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bookRecyclerViewAdapter = BookRecyclerViewAdapter(listOf())
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
    }
}