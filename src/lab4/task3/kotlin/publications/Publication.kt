package lab4.task3.kotlin.publications

interface Publication : Search {
    val title: String
    fun printInfo()
}