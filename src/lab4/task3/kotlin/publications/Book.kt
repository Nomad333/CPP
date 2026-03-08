package lab4.task3.kotlin.publications

class Book(
    override val title: String,
    val author: String,
    val genre: String,
    val pages: Int,
) : Publication {

    override fun printInfo() {
        println(this)
    }

    override fun searchByTitle(): String? = title

    override fun searchByAuthor(): String? = author

    override fun toString(): String {
        return "Book(title='$title', author='$author', genre='$genre', pages=$pages)"
    }

}