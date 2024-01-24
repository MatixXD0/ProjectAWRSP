package Library;

import Library.Data.Book;
import Library.Data.Library;
import Library.Data.Client;
import Library.Helpers.ClientHelper;
import Library.Helpers.DataGenerators.BookGenerator;
import Library.Helpers.DataGenerators.ClientGenerator;
import Library.Helpers.FileHelpers.BookFileHelpers;
import Library.Helpers.FileHelpers.ClientFileHelpers;
import Library.Helpers.StatisticHelpers.BookStatisticHelper;
import Library.Helpers.StatisticHelpers.ClientStatisticHelper;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Book book = BookGenerator.generateBoook();
        Client client = ClientGenerator.generateClient();

        book.printInfo();
        System.out.println();
        client.printInfo();

        List<Book> bookList = BookGenerator.generateBookList(5);
        List<Client> clientList = ClientGenerator.generateClientList(5);


        Library library = new Library();
        library.addBookToBookList(bookList);
        library.addClientToClietnList(clientList);

        client.rentBook(book);
        client.printInvoice(book, 25);
        System.out.println("Liczba obecnie wypożyczonych książek " + client.getCurrentLoanCount());
        System.out.println("Liczba ogólnie wypożyczonych książek " + client.getTotalLoanCount());
        client.rentBook(bookList.get(4));
        client.returnBook(bookList.get(4));
        System.out.println("Liczba obecnie wypożyczonych książek " + client.getCurrentLoanCount());
        System.out.println("Liczba ogólnej wypożyczonych książek " + client.getTotalLoanCount());
        System.out.println("Czy książka jest dostępna " + book.isAvailable());
        System.out.println("Czy książka jest dostępna " + bookList.get(4).isAvailable());
        clientList.get(3).rentBook(bookList.get(3));
        System.out.println();


        BookStatisticHelper.calculateAverageBookAge(bookList);
        System.out.println("Ilość wystąpień słowa Lorem " + BookStatisticHelper.calculateThisWord(book, "lorem"));
        System.out.println("Najdłuższe słowo w książce: " + BookStatisticHelper.findLongestWord(book));
        System.out.println("Liczba unikalnych słów: " + BookStatisticHelper.uniqueWordsCount(book));


        System.out.println("Średnia ilość wypożyczeń: " + ClientStatisticHelper.averageNumberOfLoans(clientList));
        System.out.println("Najczęściej wypożyczane książki: " +ClientStatisticHelper.mostBorrowedBooks(clientList));
        ClientStatisticHelper.calculateAverageAge(clientList);

//        System.out.println();
//        BookFileHelpers.saveBookToFile(book);
//        Book book2 = BookFileHelpers.createBookFromFile("./src/Ostatni Lot Feniksa Tomasz Zieliński.mobi");
//        book2.printInfo();


        ClientFileHelpers.saveClientListToFile(clientList, "./src/clients.txt");
        ClientHelper.convertListOfStringsToListOfClients(ClientFileHelpers.readFromFile("./src/clients.txt"));
        ClientFileHelpers.saveInvoiceToFile(ClientHelper.createInvoiceContent(client, book, 20));

    }

}
