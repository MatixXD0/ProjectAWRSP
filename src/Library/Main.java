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

import java.util.ArrayList;
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
        System.out.println(client.getCurrentLoanCount());
        System.out.println(client.getTotalLoanCount());
        client.rentBook(bookList.get(4));
        client.returnBook(bookList.get(4));
        System.out.println(client.getCurrentLoanCount());
        System.out.println(client.getTotalLoanCount());
        System.out.println(book.isAvailable());
        System.out.println(bookList.get(4).isAvailable());
        clientList.get(3).rentBook(bookList.get(3));


        System.out.println(BookStatisticHelper.averageSentenceLength(book));//nie ma kropek XD
        BookStatisticHelper.calculateAverageBookAge(bookList);
        System.out.println(BookStatisticHelper.calculateThisWord(book, "lorem"));
        System.out.println(BookStatisticHelper.findLongestWord(book));
        System.out.println(BookStatisticHelper.uniqueWordsCount(book));


        System.out.println(ClientStatisticHelper.averageNumberOfLoans(clientList));
        System.out.println(ClientStatisticHelper.mostBorrowedBooks(clientList));
        ClientStatisticHelper.calculateAverageAge(clientList);

        BookFileHelpers.saveBookToFile(book);//warunki nie zapiswyania jeszcze raz
        Book book2 = new Book();
        //BookFileHelpers.createBookFromFile("aa");


        ClientFileHelpers.saveClientListToFile(clientList, "./src/clients.txt");
        ClientHelper.convertListOfStringsToListOfClients(ClientFileHelpers.readFromFile("./src/clients.txt"));

        ClientFileHelpers.saveInvoiceToFile(ClientHelper.createInvoiceContent(client, book, 20));

    }

}
