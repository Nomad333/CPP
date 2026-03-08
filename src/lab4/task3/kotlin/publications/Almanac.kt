package lab4.task3.kotlin.publications

class Almanac(
    override val title: String,
    val books: List<Book>,
) : Publication {

    override fun printInfo() {
        println(this)
    }

    override fun searchByTitle(): String? = title

    override fun searchByAuthor(): String? = null

    override fun toString(): String {
        return "Almanac(title='$title', books=$books)"
    }
}