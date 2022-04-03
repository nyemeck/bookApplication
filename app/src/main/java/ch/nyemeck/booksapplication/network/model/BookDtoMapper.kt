package ch.nyemeck.booksapplication.network.model

import android.util.Log
import ch.nyemeck.booksapplication.domain.util.DomainMapper
import ch.nyemeck.booksapplication.models.Book

class BookDtoMapper : DomainMapper<BookDto, Book> {
    override fun mapToDomainModel(model: BookDto): Book {
        Log.d("BookDtoMapper", "mapToDomainModel model: $model")
        return Book(
            title = model.volumeInfo.title,
            subtitle = model.volumeInfo.subtitle?:"No subtitle",
            thumbnail = model.volumeInfo.imageLinks?.thumbnail
        )
    }

    override fun mapFromDomainModel(domainModel: Book): BookDto {
        return BookDto(
            id = domainModel.title,
            volumeInfo = VolumeInfo(title = domainModel.title, subtitle = domainModel.subtitle, imageLinks = null),

        )
    }

    fun toDomainList(list: List<BookDto>): List<Book>{
        return list.map { bookDto -> mapToDomainModel(bookDto)  }
    }


}