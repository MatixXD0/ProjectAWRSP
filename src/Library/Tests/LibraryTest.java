package Library.Tests;


import Library.Data.Library;
import Library.Data.Address;
import Library.Data.Book;
import Library.Data.Client;
import Library.Data.Languages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryTest {

    private Library library;
    private Book book1, book2;
    private Client client1, client2;

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("Book 1", "Author 1", "Surname 1", 2000, "ISBN1", Languages.ENGLISH, true, 300, "/path/to/book1", "PDF");
        book2 = new Book("Book 2", "Author 2", "Surname 2", 2001, "ISBN2", Languages.POLISH, true, 350, "/path/to/book2", "EPUB");
        client1 = new Client("Jan", "Kowalski", "M", 1980, new Address(), new ArrayList<>(), new ArrayList<>());
        client2 = new Client("Anna", "Nowak", "F", 1985, new Address(), new ArrayList<>(), new ArrayList<>());
    }

    @Test
    void testAddAndRemoveBook() {
        library.addBookToBookList(book1);
        assertTrue(library.getBookList().contains(book1), "Książka powinna być dodana do listy książek");

        library.removeBookFromBookList(book1);
        assertFalse(library.getBookList().contains(book1), "Książka powinna być usunięta z listy książek");
    }

    @Test
    void testAddAndRemoveMultipleBooks() {
        List<Book> books = Arrays.asList(book1, book2);
        library.addBookToBookList(books);
        assertTrue(library.getBookList().containsAll(books), "Wszystkie książki powinny być dodane do listy książek");

        library.removeBookToBookList(books);
        assertFalse(books.stream().anyMatch(book -> library.getBookList().contains(book)), "Wszystkie książki powinny być usunięte z listy książek");
    }

    @Test
    void testAddAndRemoveClient() {
        library.addClientToClietnList(client1);
        assertTrue(library.getClientList().contains(client1), "Klient powinien być dodany do listy klientów");

        library.removeClientFromClientList(client1);
        assertFalse(library.getClientList().contains(client1), "Klient powinien być usunięty z listy klientów");
    }

    @Test
    void testAddAndRemoveMultipleClients() {
        List<Client> clients = Arrays.asList(client1, client2);
        library.addClientToClietnList(clients);
        assertTrue(library.getClientList().containsAll(clients), "Wszyscy klienci powinni być dodani do listy klientów");

        library.removeClientToClietnList(clients);
        assertFalse(clients.stream().anyMatch(client -> library.getClientList().contains(client)), "Wszyscy klienci powinni być usunięci z listy klientów");
    }
}
