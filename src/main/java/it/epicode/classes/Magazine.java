package it.epicode.classes;

import it.epicode.exceptions.AddItemException;
import it.epicode.exceptions.RemoveItemException;
import it.epicode.exceptions.ResearchISBNException;
import it.epicode.exceptions.ResearchPublishingYearException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Magazine extends CatalogueItem {

    // Creazione di un Enum per gestire le caratteristiche dell'oggetto Rivista

    public enum Periodicity {
        SETTIMANALE,
        MENSILE,
        SEMESTRALE
    }

    // Creazione di una variabile logger per la gestione delle eccezioni con LogBack e slf4j

    private static final Logger logger = LoggerFactory.getLogger(Magazine.class);


    private Periodicity periodicity;
    private List<Magazine> magazines = new ArrayList<>();

    // Costruttore

    public Magazine (long isbnCode, String title, int publishingYear, Periodicity periodicity) {
        super(isbnCode, title, publishingYear);
        this.periodicity = periodicity;
    }

    // Funzioni getter e setter

    public Periodicity getPeriodicita() {
        return periodicity;
    }
    public void setPeriodicita(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    // Override dei metodi astratti definiti in CatalogueItem con implementazione
    // di blocchi try/catch per agevolare la gestione di possibili eccezioni

    @Override
    public void addItem(CatalogueItem item) {
        try {
            if (item instanceof Magazine) {
                Magazine newMagazine = new Magazine(item.getIsbnCode(),
                        item.getTitle(),
                        item.getPublishingYear(),
                        ((Magazine) item).getPeriodicita()
                );
                magazines.add(newMagazine);
            }  else {
                throw new AddItemException("Impossibile aggiungere l'elemento.");
            }
        } catch (AddItemException e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void removeItemByIsbn (long isbnCode) {
        try {
            magazines.removeIf(magazine -> magazine.getIsbnCode() == isbnCode);
        } catch(Exception e) {
            logger.error("Errore durante la rimozione dell'elemento per ISBN: {}", e.getMessage());
            throw new RemoveItemException("Errore durante la rimozione dell'elemento per ISBN", e);
        }
    }

    @Override
    public Optional<CatalogueItem> researchByIsbn(long isbnCode) {
        try {
            Optional<CatalogueItem> researchIsbn = magazines.stream().filter(magazine -> magazine.getIsbnCode() == isbnCode)
                    .findFirst().map(m -> (CatalogueItem) m);
            return researchIsbn;
        } catch(Exception e) {
            logger.error("Errore durante la ricerca per ISBN: {}", e.getMessage());
            e.printStackTrace();
            throw new ResearchISBNException("Errore durante la ricerca per ISBN", e);
        }
    }

    @Override
    public List<CatalogueItem> researchByPublishingYear (int publishingYear) {
        try {
            List<CatalogueItem> researchPublishingYear = magazines.stream()
                    .filter(magazine -> magazine.getPublishingYear() == publishingYear)
                    .map(m -> (CatalogueItem) m)
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
        if (!(o instanceof Magazine magazine)) return false;
        if (!super.equals(o)) return false;
        return getPeriodicita() == magazine.getPeriodicita();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPeriodicita());
    }

    // Override del metodo toString()

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                '}';
    }
}

