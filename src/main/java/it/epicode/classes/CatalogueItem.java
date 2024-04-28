package it.epicode.classes;

import java.util.Objects;

public abstract class CatalogueItem {
    private long isbnCode;
    private String title;
    private int publishingYear;

    //Costruttore

    public CatalogueItem(long isbnCode, String title, int publishingYear) {
        this.isbnCode = isbnCode;
        this.title = title;
        this.publishingYear = publishingYear;
    }

    // Funzioni getter e setter

    public long getIsbnCode() {
        return isbnCode;
    }
    public void setIsbnCode(long isbnCode) {
        this.isbnCode = isbnCode;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishingYear() {
        return publishingYear;
    }
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    // Creazione dei metodi astratti per l'aggiunta di un elemento, rimozione di un elemento
    // in base al codice ISBN e di ricerca per ISBN o per anno di pubblicazione,
    // che verranno poi implementati e "overridden" nelle singole classi concrete


    // Override dei metodi equals() e hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatalogueItem that)) return false;
        return getIsbnCode() == that.getIsbnCode() && getPublishingYear() == that.getPublishingYear() && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbnCode(), getTitle(), getPublishingYear());
    }

    // Override del metodo toString()

    @Override
    public String toString() {
        return "CatalogueItem{" +
                "isbnCode=" + isbnCode +
                ", title='" + title + '\'' +
                ", publishingYear=" + publishingYear +
                '}';
    }
}
