package Library.Data;

import Library.Helpers.ClientHelper;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Client {
    private String name;
    private String surname;
    private String sex;
    private int bornYear;
    private Address address;
    private List<Book> currentLoans;
    private List<Book> loanHistory;

    public Client() {
        address = new Address();
        currentLoans = new ArrayList<>();
        loanHistory = new ArrayList<>();
    }

    public void rentBook(Book book){
        book.setAvailable(false);
        currentLoans.add(book);
        loanHistory.add(book);
    }

    public void returnBook(Book book){
        book.setAvailable(true);
        currentLoans.remove(book);
    }


    public int getCurrentLoanCount() {
        return currentLoans.size();
    }

    public int getTotalLoanCount() {
        return loanHistory.size();
    }

    public boolean isBookCurrentlyLoaned(Book book) {
        return currentLoans.contains(book);
    }

    public void displayLoanedBooks() {
        currentLoans.forEach(System.out::println);
    }

    public void printInvoice(Book book, int rentalDays) {
        String invoiceContent = ClientHelper.createInvoiceContent(this, book, rentalDays);
        System.out.println(invoiceContent);
    }


    public void printInfo() {
        System.out.println("Client Information:");
        System.out.println("Name: " + name + " " + surname);
        System.out.println("Sex: " + sex);
        System.out.println("Year of Birth: " + bornYear);
        address.printInfo();

        System.out.println("Current Loans: " + currentLoans.size());
        currentLoans.forEach(book -> System.out.println(" - " + book.getTitle()));

        System.out.println("Loan History: " + loanHistory.size());
        loanHistory.forEach(book -> System.out.println(" - " + book.getTitle()));
    }
}
