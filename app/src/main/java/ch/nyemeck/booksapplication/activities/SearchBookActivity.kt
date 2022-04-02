package ch.nyemeck.booksapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.nyemeck.booksapplication.R
import ch.nyemeck.booksapplication.adapters.BookRecyclerViewAdapter
import ch.nyemeck.booksapplication.databinding.ActivitySearchBookBinding
import ch.nyemeck.booksapplication.models.BookModel

class SearchBookActivity : AppCompatActivity() {

    private lateinit var searchBookActivityBinding: ActivitySearchBookBinding
    private lateinit var recyclerViewLayoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var books = listOf<BookModel>(BookModel("moi", "toi"), BookModel("Lui", "Elle"), BookModel("Vous", "Nous"))
        searchBookActivityBinding = ActivitySearchBookBinding.inflate(layoutInflater)
        setContentView(searchBookActivityBinding.root)
        recyclerViewLayoutManager = LinearLayoutManager(this)
        searchBookActivityBinding.recyclerViewBookList.apply {
            adapter = BookRecyclerViewAdapter(books)
            layoutManager = recyclerViewLayoutManager
        }
    }
}