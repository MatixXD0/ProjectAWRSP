package Library.Tests;


import Library.Data.Book;
import Library.Data.Languages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("Sample Title", "Jan", "Kowalski", 2020, "123-456-789", Languages.ENGLISH, true, 250, "/path/to/book", "PDF");
    }

    @Test
    void testCalculateRentalCost() {
        assertEquals(12.0, book.calculateRentalCost(10), "Koszt powinien być równy 12 dla 10 dni");

        assertEquals(42.0, book.calculateRentalCost(90), "Koszt powinien wzrosnąć dla okresu dłuższego niż 30 dni");

        assertThrows(IllegalArgumentException.class, () -> book.calculateRentalCost(0), "Powinien zostać rzucony wyjątek dla dni <= 0");
    }

    @Test
    void testPrintBookDetails() {
        assertDoesNotThrow(() -> book.printBookDetails(), "Metoda printBookDetails nie powinna rzucać wyjątków");
    }

    @Test
    void testPrintInfo() {
        assertDoesNotThrow(() -> book.printInfo(), "Metoda printInfo nie powinna rzucać wyjątków");
    }
}
