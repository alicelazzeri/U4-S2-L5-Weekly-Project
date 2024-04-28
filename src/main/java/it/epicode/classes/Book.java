package it.epicode.classes;

import it.epicode.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Book extends CatalogueItem {

    // Creazione di una variabile logger per la gestione delle eccezioni con LogBack e slf4j

    private static final Logger logger = LoggerFactory.getLogger(Book.class);

    private String author;
    private String genre;
    private List<Book> books = new ArrayList<>();

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

    // Creazione del metodo researchByAuthor, proprio solo
    // della classe Book, essendo author uno dei suoi attrinuti
    // non ereditati da CatalogueItem

    public List<CatalogueItem> researchByAuthor(String author) {
        try {
            List<CatalogueItem> researchAuthor = books.stream()
                    .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                    .map(b -> (CatalogueItem) b)
                    .collect(Collectors.toList());
            return researchAuthor;
        } catch (Exception e) {
            logger.error("Errore durante la ricerca per autore: {}", e.getMessage());
            throw new ResearchAuthorException("Errore durante la ricerca per autore", e);
        }
    }

    // Override dei metodi astratti definiti in CatalogueItem con implementazione
    // di blocchi try/catch per agevolare la gestione di possibili eccezioni

    @Override
    public void addItem(CatalogueItem item) {
        try {
            if (item instanceof Book) {
                Book newBook = new Book(item.getIsbnCode(),
                        item.getTitle(),
                        item.getPublishingYear(),
                        ((Book) item).getAuthor(),
                        ((Book) item).getGenre()
                );
                books.add(newBook);
            } else {
                throw new AddItemException("Impossibile aggiungere l'elemento.");
            }
        } catch (AddItemException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void removeItemByIsbn(long isbnCode) {
        try {
            books.removeIf(book -> book.getIsbnCode() == isbnCode);
        } catch (Exception e) {
            logger.error("Errore durante la rimozione dell'elemento per ISBN: {}", e.getMessage());
            throw new RemoveItemException("Errore durante la rimozione dell'elemento per ISBN", e);
        }
    }

    @Override
    public Optional<CatalogueItem> researchByIsbn(long isbnCode) {
        try {
            Optional<CatalogueItem> researchIsbn = books.stream()
                    .filter(book -> book.getIsbnCode() == isbnCode)
                    .findFirst()
                    .map(b -> (CatalogueItem) b);
            return researchIsbn;
        } catch (Exception e) {
            logger.error("Errore durante la ricerca per ISBN: {}", e.getMessage());
            throw new ResearchISBNException("Errore durante la ricerca per ISBN", e);
        }
    }

    @Override
    public List<CatalogueItem> researchByPublishingYear(int publishingYear) {
        try {
            List<CatalogueItem> researchPublishingYear = books.stream()
                    .filter(book -> book.getPublishingYear() == publishingYear)
                    .map(b -> (CatalogueItem) b)
                    .collect(Collectors.toList());
            return researchPublishingYear;
        } catch (Exception e) {
            logger.error("Errore durante la ricerca per anno di pubblicazione: {}", e.getMessage());
            throw new ResearchPublishingYearException("Errore durante la ricerca per anno di pubblicazione", e);
        }
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