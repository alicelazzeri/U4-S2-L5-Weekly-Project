package it.epicode;

import it.epicode.classes.Book;
import it.epicode.classes.CatalogueItem;
import it.epicode.classes.Magazine;
import it.epicode.exceptions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<CatalogueItem> libraryCatalogue = new ArrayList<>();

        // creazione di nuove istanze di Book e Magazine

        Book book1 = new Book(9783161484100L, "The Lord of the Rings - The Fellowship of the Ring", 1954, "J.R.R. Tolkien", "Fantasy");
        Book book2 = new Book(9781408855652L, "Harry Potter and the Philosopher's Stone", 1997, "J.K. Rowling", "Fantasy");
        Book book3 = new Book(9781408828652L, "Harry Potter and the Chamber of Secrets", 1998, "J.K. Rowling", "Fantasy");
        Book book4 = new Book(9780439136365L, "Harry Potter and the Prisoner of Azkaban", 1999, "J.K. Rowling", "Fantasy");
        Book book5 = new Book(9780439139595L, "Harry Potter and the Goblet of Fire", 2000, "J.K. Rowling", "Fantasy");
        Book book6 = new Book(9780439358071L, "Harry Potter and the Order of the Phoenix", 2003, "J.K. Rowling", "Fantasy");
        Book book7 = new Book(9780439785969L, "Harry Potter and the Half-Blood Prince", 2005, "J.K. Rowling", "Fantasy");
        Book book8 = new Book(9780545010221L, "Harry Potter and the Deathly Hallows", 2007, "J.K. Rowling", "Fantasy");
        Book book9 = new Book(9780395489314L, "The Lord of the Rings - The Two Towers", 1954, "J.R.R. Tolkien", "Fantasy");
        Book book10 = new Book(9780395489307L, "The Lord of the Rings - The Return of the King", 1955, "J.R.R. Tolkien", "Fantasy");
        Book book11 = new Book(9781582872919L, "Tess of the d'Urbervilles", 1891, "Thomas Hardy", "Novel");
        Book book12 = new Book(9781569786729L, "The Castle of Otranto", 1764, "Horace Walpole", "Gothic Novel");


        Magazine magazine1 = new Magazine(9781419704406L, "Vogue", 2024, Magazine.Periodicity.MENSILE);
        Magazine magazine2 = new Magazine(9783161484100L, "National Geographic", 2023, Magazine.Periodicity.MENSILE);
        Magazine magazine3 = new Magazine(9780321965516L, "Time", 2022, Magazine.Periodicity.SETTIMANALE);
        Magazine magazine4 = new Magazine(9780670020553L, "The New Yorker", 2023, Magazine.Periodicity.MENSILE);
        Magazine magazine5 = new Magazine(9780679641635L, "Science", 2024, Magazine.Periodicity.SEMESTRALE);
        Magazine magazine6 = new Magazine(9780195153445L, "Nature", 2022, Magazine.Periodicity.MENSILE);
        Magazine magazine7 = new Magazine(9781408128761L, "National Geographic Traveler", 2023, Magazine.Periodicity.MENSILE);
        Magazine magazine8 = new Magazine(9780749477500L, "Harvard Business Review", 2024, Magazine.Periodicity.MENSILE);
        Magazine magazine9 = new Magazine(9781510726189L, "Smithsonian", 2022, Magazine.Periodicity.MENSILE);
        Magazine magazine10 = new Magazine(9781546076572L, "New Scientist", 2023, Magazine.Periodicity.SETTIMANALE);
        Magazine magazine11 = new Magazine(9781785417693L, "Discover", 2024, Magazine.Periodicity.MENSILE);
        Magazine magazine12 = new Magazine(9781734625182L, "Popular Science", 2023, Magazine.Periodicity.MENSILE);

        // aggiunta degli items a libraryCatalogue

        libraryCatalogue.add(book1);
        libraryCatalogue.add(book2);
        libraryCatalogue.add(book3);
        libraryCatalogue.add(book4);
        libraryCatalogue.add(book5);
        libraryCatalogue.add(book6);
        libraryCatalogue.add(book7);
        libraryCatalogue.add(book8);
        libraryCatalogue.add(book9);
        libraryCatalogue.add(book10);
        libraryCatalogue.add(book11);
        libraryCatalogue.add(book12);

        libraryCatalogue.add(magazine1);
        libraryCatalogue.add(magazine2);
        libraryCatalogue.add(magazine3);
        libraryCatalogue.add(magazine4);
        libraryCatalogue.add(magazine5);
        libraryCatalogue.add(magazine6);
        libraryCatalogue.add(magazine7);
        libraryCatalogue.add(magazine8);
        libraryCatalogue.add(magazine9);
        libraryCatalogue.add(magazine10);
        libraryCatalogue.add(magazine11);
        libraryCatalogue.add(magazine12);

        // stampa del catalogo aggiornato con tutti i parametri

        System.out.println("Catalogo della biblioteca iniziale:");
        for (CatalogueItem item : libraryCatalogue) {
            if (item instanceof Book) {

                Book book = (Book) item;
                System.out.println("Book: ISBN=" + book.getIsbnCode() +
                        ", Title='" + book.getTitle() +
                        "', Publishing Year=" + book.getPublishingYear() +
                        ", Author='" + book.getAuthor() +
                        "', Genre='" + book.getGenre() + "'");
            } else if (item instanceof Magazine) {

                Magazine magazine = (Magazine) item;
                System.out.println("Magazine: ISBN=" + magazine.getIsbnCode() +
                        ", Title '" + magazine.getTitle() +
                        "', Publishing Year: " + magazine.getPublishingYear() +
                        ", Periodicità: " + magazine.getPeriodicita());
            }
        }

        // rimozione di items al libraryCatalogue (book1, book10, magazine7, magazine12)

        try {
            book1.removeItemByIsbn(9783161484100L);
        } catch (RemoveItemException e) {
            System.out.println("Errore durante la rimozione dell'elemento: " + e.getMessage());
        }
        try {
            book10.removeItemByIsbn(9780395489307L);
        } catch (RemoveItemException e) {
            System.out.println("Errore durante la rimozione dell'elemento: " + e.getMessage());
        }

        try {
            magazine7.removeItemByIsbn(9781408128761L);
        } catch (RemoveItemException e) {
            System.out.println("Errore durante la rimozione dell'elemento: " + e.getMessage());
        }
        try {
            magazine12.removeItemByIsbn(9781734625182L);
        } catch (RemoveItemException e) {
            System.out.println("Errore durante la rimozione dell'elemento: " + e.getMessage());
        }


        System.out.println("Catalogo della biblioteca aggiornato:");
        for (CatalogueItem item : libraryCatalogue) {
            if (item instanceof Book) {

                Book book = (Book) item;
                System.out.println("Book: ISBN=" + book.getIsbnCode() +
                        ", Title='" + book.getTitle() +
                        "', Publishing Year=" + book.getPublishingYear() +
                        ", Author='" + book.getAuthor() +
                        "', Genre='" + book.getGenre() + "'");
            } else if (item instanceof Magazine) {

                Magazine magazine = (Magazine) item;
                System.out.println("Magazine: ISBN=" + magazine.getIsbnCode() +
                        ", Title '" + magazine.getTitle() +
                        "', Publishing Year: " + magazine.getPublishingYear() +
                        ", Periodicità: " + magazine.getPeriodicita());
            }
        }

        // Ricerca per codice ISBN

        long isbnToSearch = 9780545010221L;
        boolean found = false;

        try {
            for (CatalogueItem item : libraryCatalogue) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    if (book.getIsbnCode() == isbnToSearch) {
                        System.out.println("Libro trovato: " + book.getTitle() + " - " + book.getAuthor());
                        found = true;
                        break;
                    }
                } else if (item instanceof Magazine) {
                    Magazine magazine = (Magazine) item;
                    if (magazine.getIsbnCode() == isbnToSearch) {
                        System.out.println("Rivista trovata: " + magazine.getTitle());
                        found = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Si è verificato un errore durante la ricerca dell'ISBN: " + e.getMessage());
        }

        if (!found) {
            System.out.println("Nessun libro o rivista trovato con il codice ISBN " + isbnToSearch);
        }

        // Ricerca per anno di pubblicazione

        int yearToSearch = 2022;
        boolean isFound = false;

        try {
            for (CatalogueItem item : libraryCatalogue) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    if (book.getPublishingYear() == yearToSearch) {
                        System.out.println("Libro trovato: " + book.getTitle() + " - " + book.getAuthor());
                        isFound = true;
                        break;
                    }
                } else if (item instanceof Magazine) {
                    Magazine magazine = (Magazine) item;
                    if (magazine.getPublishingYear() == yearToSearch) {
                        System.out.println("Rivista trovata: " + magazine.getTitle());
                        isFound = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Si è verificato un errore durante la ricerca dell'anno di pubblicazione: " + e.getMessage());
        }

        if (!isFound) {
            System.out.println("Nessun libro o rivista trovato con anno di pubblicazione " + yearToSearch);
        }

        // Ricerca per autore (applicabile solo ai libri)

        String authorToSearch = "J.K. Rowling";
        boolean isAuthorFound = false;

        try {
            for (CatalogueItem item : libraryCatalogue) {
                if (item instanceof Book) {
                    Book book = (Book) item;
                    if (book.getAuthor().equalsIgnoreCase(authorToSearch)) {
                        System.out.println("Libro trovato: " + book.getTitle() + " - " + book.getAuthor());
                        isAuthorFound = true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Si è verificato un errore durante la ricerca per autore: " + e.getMessage());
        }

        if (!isAuthorFound) {
            System.out.println("Nessun libro trovato dell'autore " + authorToSearch);
        }



    }











}
