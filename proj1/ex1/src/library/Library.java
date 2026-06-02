package library;

public class Library {
    private Book[] books;

    public Library(int size) {
        this.books = new Book[size];
    }

    public void setBook(int bookNum, String title, Author auth) {
        this.books[bookNum] = new Book(title, auth);
    }

    public Book getBook(int bookNum) {
        if (bookNum < 0 || bookNum >= this.books.length) {
            throw new IllegalArgumentException("Invalid book number: " + bookNum);
        }
        else if (this.books[bookNum] == null) {
            throw new IllegalStateException("null");
        }
        else {
            return this.books[bookNum];
        }
    }
}
