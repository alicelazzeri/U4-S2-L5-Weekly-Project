package it.epicode.classes;

import java.util.Objects;

public class Magazine extends CatalogueItem {

    // Creazione di un Enum per gestire le caratteristiche dell'oggetto Rivista

    public enum Periodicita {
        SETTIMANALE,
        MENSILE,
        SEMESTRALE
    }

    private Periodicita periodicita;

    // Costruttore

    public Magazine (long isbnCode, String title, int publishingYear, Periodicita periodicita) {
        super(isbnCode, title, publishingYear);
        this.periodicita = periodicita;
    }

    // Funzioni getter e setter

    public Periodicita getPeriodicita() {
        return periodicita;
    }
    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
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
                "periodicita=" + periodicita +
                '}';
    }
}

