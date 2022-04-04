package ch.nyemeck.booksapplication.network.model

import ch.nyemeck.booksapplication.domain.util.DomainMapper
import ch.nyemeck.booksapplication.presentation.models.Book

class BookNetworkMapper : DomainMapper<BookNetwork, Book> {
    override fun mapToDomainModel(model: BookNetwork): Book {
        return Book(
            title = model.volumeInfo.title,
            subtitle = model.volumeInfo.subtitle?:"No subtitle",
            thumbnail = model.volumeInfo.imageLinks?.thumbnail
        )
    }

    override fun mapFromDomainModel(domainModel: Book): BookNetwork {
        return BookNetwork(
            id = domainModel.title,
            volumeInfo = VolumeInfo(title = domainModel.title, subtitle = domainModel.subtitle, imageLinks = null),

        )
    }

    fun toDomainList(list: List<BookNetwork>): List<Book>{
        return list.map { bookDto -> mapToDomainModel(bookDto)  }
    }


}