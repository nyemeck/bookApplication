package ch.nyemeck.booksapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ch.nyemeck.booksapplication.databinding.BookLayoutItemBinding
import ch.nyemeck.booksapplication.models.BookModel

class BookRecyclerViewAdapter(private val books: List<BookModel>):RecyclerView.Adapter<BookRecyclerViewAdapter.BookViewHolder>(){

    inner class BookViewHolder(private val bookLayoutItem: BookLayoutItemBinding): RecyclerView.ViewHolder(bookLayoutItem.root){
        fun bind(myBookItem : BookModel){
            bookLayoutItem.bookItem = myBookItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bookItemLayoutBinding = BookLayoutItemBinding.inflate(inflater, parent, false)
        return BookViewHolder(bookItemLayoutBinding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }
}