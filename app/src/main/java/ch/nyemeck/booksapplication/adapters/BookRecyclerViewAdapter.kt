package ch.nyemeck.booksapplication.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ch.nyemeck.booksapplication.activities.DetailsActivity
import ch.nyemeck.booksapplication.databinding.BookLayoutItemBinding
import ch.nyemeck.booksapplication.models.Book

const val EXTRA_BOOK_TITLE = "book_title"
const val EXTRA_BOOK_SUBTITLE = "book_subtitle"
const val EXTRA_BOOK_THUMBNAIL = "book_thumbnail"
class BookRecyclerViewAdapter(private var books: List<Book>):RecyclerView.Adapter<BookRecyclerViewAdapter.BookViewHolder>(){

    inner class BookViewHolder(private val bookLayoutItem: BookLayoutItemBinding): RecyclerView.ViewHolder(bookLayoutItem.root){
        fun bind(myBookItem : Book){
            bookLayoutItem.bookItem = myBookItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bookItemLayoutBinding = BookLayoutItemBinding.inflate(inflater, parent, false)
        return BookViewHolder(bookItemLayoutBinding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val myBook = books[position]
        holder.bind(myBook)
        holder.itemView.setOnClickListener {view->
            val context = view.context
            val intent = Intent(context, DetailsActivity::class.java).apply{
                putExtra(EXTRA_BOOK_TITLE,myBook.title)
                putExtra(EXTRA_BOOK_SUBTITLE,myBook.subtitle)
                putExtra(EXTRA_BOOK_THUMBNAIL,myBook.thumbnail)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return books.size
    }

    public fun swapDataSet(newBooks: List<Book>) {
        books = newBooks
        notifyDataSetChanged()
    }
}