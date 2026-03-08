package lab4.task3.kotlin

import lab4.task3.kotlin.publications.Book
import lab4.task3.kotlin.publications.Newspaper
import lab4.task3.kotlin.publications.Publication
import lab4.task3.kotlin.publications.Search
import java.time.LocalDate

class Catalog(
    private var publications: MutableList<Publication>
) {

    constructor() : this(
        mutableListOf()
    )

    fun testInit() {
        val book1 = Book(
            title = "The Great Gatsby",
            author = "F. Scott Fitzgerald",
            genre = "Novel",
            pages = 180
        )

        val book2 = Book(
            title = "To Kill a Mockingbird",
            author = "Harper Lee",
            genre = "Novel",
            pages = 281
        )

        val newspaper = Newspaper(
            title = "The New York Times",
            releaseDate = LocalDate.of(2024, 6, 1),
            headlines = listOf("Headline 1", "Headline 2", "Headline 3")
        )

        addPublication(book1)
        addPublication(book2)
        addPublication(newspaper)
    }

    fun <T : Publication> addPublication(publication: T) {
        publications.add(publication)
    }

    fun removeByName(name: String) {
        publications.removeIf { it.title.equals(name, ignoreCase = true) }
    }

    fun <T : Search> searchByTitle(title: String, searchedClass: Class<T>): List<T> {
        return publications
            .filter { searchedClass.isInstance(it) }
            .map { searchedClass.cast(it) }
            .filter { it.searchByTitle()?.contains(title, ignoreCase = true) == true }
    }

    fun <T : Search> searchByAuthor(title: String, searchedClass: Class<T>): List<T> {
        return publications
            .filter { searchedClass.isInstance(it) }
            .map { searchedClass.cast(it) }
            .filter { it.searchByAuthor()?.contains(title, ignoreCase = true) == true }
    }

    fun printAllPublications() {
        publications.forEach { it.printInfo() }
    }
}