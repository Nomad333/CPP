package lab4.task3.kotlin

import lab4.task3.kotlin.publications.Book
import lab4.task3.kotlin.publications.Publication

fun main() {

    val catalog = Catalog()
    catalog.testInit()

    println("Search by title 'The Great Gatsby':")
    val allResults = catalog.searchByTitle("The Great Gatsby", Publication::class.java)

    val booksOnly = catalog.searchByTitle("The Great Gatsby", Book::class.java)

    println("All results:$allResults}")
    println("Books only:$booksOnly")

    catalog.printAllPublications()
}