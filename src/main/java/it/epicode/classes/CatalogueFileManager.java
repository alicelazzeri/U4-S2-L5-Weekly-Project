package it.epicode.classes;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogueFileManager {

    public void saveCatalogue(List<CatalogueItem> catalogue, String filePath) throws IOException {

        // Creazione di una lista di stringhe rappresentanti gli oggetti del catalogo

        List<String> catalogueStrings = catalogue.stream()
                .map(CatalogueItem::toString)
                .collect(Collectors.toList());

        // Scrittura della lista nel file specificato

        FileUtils.writeLines(new File(filePath), catalogueStrings);
    }

    public List<CatalogueItem> loadCatalogue(String filePath) throws IOException {

        // Lettura delle linee dal file specificato

        List<String> catalogueStrings = FileUtils.readLines(new File(filePath));

        // Creazione di una lista di oggetti CatalogueItem dai dati letti

        return catalogueStrings.stream()
                .map(this::createCatalogueItemFromString)
                .collect(Collectors.toList());
    }

    // Metodo per creare un oggetto CatalogueItem da una stringa

    private CatalogueItem createCatalogueItemFromString(String catalogueItemString) {
        String[] data = catalogueItemString.split(";");
        String itemType = data[0];

        switch (itemType) {
            case "Book":
                long isbnCode = Long.parseLong(data[1]);
                String title = data[2];
                int publishingYear = Integer.parseInt(data[3]);
                String author = data[4];
                String genre = data[5];
                return new Book(isbnCode, title, publishingYear, author, genre);
            case "Magazine":
                long magazineIsbnCode = Long.parseLong(data[1]);
                String magazineTitle = data[2];
                int magazinePublishingYear = Integer.parseInt(data[3]);
                Magazine.Periodicity periodicity = Magazine.Periodicity.valueOf(data[4]);
                return new Magazine(magazineIsbnCode, magazineTitle, magazinePublishingYear, periodicity);
            default:
                return null;
        }
    }

}
