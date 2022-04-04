package ch.nyemeck.booksapplication.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ch.nyemeck.booksapplication.presentation.models.Book
import ch.nyemeck.booksapplication.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryBookViewModel
@Inject
constructor(
    private val repository: BookRepository
): ViewModel(){
    val booksMutableLiveData : MutableLiveData<List<Book>> = MutableLiveData(ArrayList())
    private var viewModelJob = Job()
    private val scope = CoroutineScope(Dispatchers.IO + viewModelJob)
    fun getBooks(){
        scope.launch {
            val resultBooks = repository.getBooks()
            booksMutableLiveData.postValue(resultBooks)
        }
    }

}