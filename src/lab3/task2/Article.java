package lab3.task2;

public class Article {
    private Person author;
    private String title;
    private int rating;

    public Article(Person author, String title, int rating) {
        this.author = author;
        this.title = title;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Article: " + title + ", author: " + author + ", rating: " + rating;
    }
}