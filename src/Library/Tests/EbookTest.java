package Library.Tests;

import Library.Data.Ebook;
import Library.Data.Languages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EbookTest {

    private Ebook ebook;

    @BeforeEach
    void setUp() {
        ebook = new Ebook();
        ebook.setTitle("Sample Ebook");
        ebook.setAuthorName("Jan");
        ebook.setAuthorSurname("Kowalski");
        ebook.setPublicationYear(2020);
        ebook.setIsbn("123-456-789");
        ebook.setLanguage(Languages.ENGLISH);
        ebook.setAvailable(true);
        ebook.setPagesNumber(250);
        ebook.setFilePath("/path/to/ebook");
        ebook.setFormat("PDF");
        ebook.setSize(500000);
    }

    @Test
    void testCalculateRentalCost() {
        assertEquals(7.0, ebook.calculateRentalCost(10), "Koszt wypożyczenia ebooka powinien być zmniejszony o 5.0");
    }

    @Test
    void testPrintInfo() {
        assertDoesNotThrow(() -> ebook.printInfo(), "Metoda printInfo nie powinna rzucać wyjątków");
    }

}