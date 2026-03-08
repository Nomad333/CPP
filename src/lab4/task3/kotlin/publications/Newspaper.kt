package lab4.task3.kotlin.publications

import java.time.LocalDate

class Newspaper(
    override val title: String,
    val releaseDate: LocalDate,
    val headlines: List<String>,
) : Publication {

    override fun printInfo() {
        println(this)
    }

    override fun searchByTitle(): String? = title

    override fun searchByAuthor(): String? = null

    override fun toString(): String {
        return "Newspaper(title='$title', releaseDate=$releaseDate, headlines=$headlines)"
    }
}