package ch.nyemeck.booksapplication.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ch.nyemeck.booksapplication.models.Book
import ch.nyemeck.booksapplication.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchBookViewModel
@Inject
constructor(
    private val repository: BookRepository
): ViewModel() {
    val booksMutableLiveData : MutableLiveData<List<Book>> = MutableLiveData(ArrayList())
    private var viewModelJob = Job()
    private val scope = CoroutineScope(Dispatchers.IO + viewModelJob)
    fun search(bookToSearch: String){
        scope.launch {
            val resultBooks = repository.search(bookToSearch)
            Log.d("SearchBookViewModel", "search: ${resultBooks.toString()}")
            booksMutableLiveData.postValue(resultBooks)
        }

    }
}