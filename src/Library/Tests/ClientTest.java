package Library.Tests;

import Library.Data.Address;
import Library.Data.Book;
import Library.Data.Client;
import Library.Data.Languages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    private Client client;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        client = new Client("Jan", "Kowalski", "M", 1980, new Address(), new ArrayList<>(), new ArrayList<>());
        book1 = new Book("Sample Title 1", "Autor 1", "Nazwisko 1", 2020, "123-456-789", Languages.ENGLISH, true, 250, "/path/to/book1", "PDF");
        book2 = new Book("Sample Title 2", "Autor 2", "Nazwisko 2", 2021, "987-654-321", Languages.POLISH, true, 300, "/path/to/book2", "EPUB");
    }

    @Test
    void testRentBook() {
        client.rentBook(book1);
        assertFalse(book1.isAvailable(), "Książka powinna być niedostępna po wypożyczeniu");
        assertTrue(client.isBookCurrentlyLoaned(book1), "Książka powinna znajdować się na liście wypożyczonych");
    }

    @Test
    void testReturnBook() {
        client.rentBook(book1);
        client.returnBook(book1);
        assertTrue(book1.isAvailable(), "Książka powinna być dostępna po zwrocie");
        assertFalse(client.isBookCurrentlyLoaned(book1), "Książka nie powinna znajdować się na liście wypożyczonych");
    }

    @Test
    void testGetCurrentLoanCount() {
        client.rentBook(book1);
        client.rentBook(book2);
        assertEquals(2, client.getCurrentLoanCount(), "Licznik wypożyczeń powinien wynosić 2");
    }

    @Test
    void testGetTotalLoanCount() {
        client.rentBook(book1);
        client.returnBook(book1);
        client.rentBook(book2);
        assertEquals(2, client.getTotalLoanCount(), "Łączna liczba wypożyczeń powinna wynosić 2");
    }

    @Test
    void testIsBookCurrentlyLoaned() {
        client.rentBook(book1);
        assertTrue(client.isBookCurrentlyLoaned(book1), "Metoda powinna zwrócić true dla wypożyczonej książki");
        client.returnBook(book1);
        assertFalse(client.isBookCurrentlyLoaned(book1), "Metoda powinna zwrócić false dla zwróconej książki");
    }
}