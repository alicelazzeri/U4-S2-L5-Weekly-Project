package it.epicode.classes;

import java.util.Objects;

public class Book extends CatalogueItem {
    private String author;
    private String genre;

    // Costruttore

    public Book(long isbnCode, String title, int publishingYear, String author, String genre) {
        super(isbnCode, title, publishingYear);
        this.author = author;
        this.genre = genre;
    }

    // Funzioni getter e setter

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Override dei metodi equals() e hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getAuthor(), book.getAuthor()) && Objects.equals(getGenre(), book.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAuthor(), getGenre());
    }

    // Override del metodo toString()

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}