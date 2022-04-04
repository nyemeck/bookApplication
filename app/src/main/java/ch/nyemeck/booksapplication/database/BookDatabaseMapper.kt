package ch.nyemeck.booksapplication.database

import ch.nyemeck.booksapplication.domain.util.DomainMapper
import ch.nyemeck.booksapplication.presentation.models.Book

class BookDatabaseMapper : DomainMapper<BookEntity, Book>{
    override fun mapToDomainModel(model: BookEntity): Book {
        return Book(
            title = model.title,
            subtitle = model.subtitle?:"No subtitle",
            thumbnail = model?.thumbnail
        )
    }

    override fun mapFromDomainModel(domainModel: Book): BookEntity {
        return BookEntity(
            id = 0,
            title = domainModel.title,
            subtitle = domainModel.subtitle?:"No subtitle",
            thumbnail = domainModel?.thumbnail
        )
    }

    fun toDomainList(list : List<BookEntity>): List<Book>{
        return list.map { bookEntity->mapToDomainModel(bookEntity) }
    }
}