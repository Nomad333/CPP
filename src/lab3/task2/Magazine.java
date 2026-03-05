package lab3.task2;

import java.time.LocalDate;

public class Magazine {

    private String name;
    private Frequency frequency;
    private LocalDate releaseDate;
    private int circulation;
    private Article[] articles;

    public Magazine(String name, Frequency frequency, LocalDate releaseDate, int circulation, Article[] articles) {
        this.name = name;
        this.frequency = frequency;
        this.releaseDate = releaseDate;
        this.circulation = circulation;
        this.articles = articles;
    }

    public Article[] getArticles() {
        return articles;
    }
}