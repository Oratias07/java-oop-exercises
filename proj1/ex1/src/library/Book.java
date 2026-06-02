package library;

public class Book {
    private String title;
    private Author author;

    public Book(String title, Author auth) {
        this.title = title;
        this.author = auth;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthorName() {
        return this.author.getName();
    }

    public int getAuthorBirthYear() {
        return this.author.getBirthYear();
    }

    public String toString() {
        return this.title + " written by " + this.author;
    }
}