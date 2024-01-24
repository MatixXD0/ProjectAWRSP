package Library.Data;

import lombok.*;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Library {
    private ArrayList<Book> bookList;
    private ArrayList<Client> clientList;

    public Library() {
        bookList = new ArrayList<>();
        clientList = new ArrayList<>();
    }

    public void addBookToBookList (Book book) {
        bookList.add(book);
    }
    public void addBookToBookList(List<Book> books) {
        books.forEach(book -> bookList.add(book));
    }


    public void removeBookFromBookList (Book book) {
        bookList.remove(book);
    }

    public void removeBookToBookList(List<Book> books) {
        books.forEach(book -> bookList.remove(book));
    }

    public void addClientToClietnList(Client client) {
        clientList.add(client);
    }

    public void addClientToClietnList(List<Client> clients) {
        clients.forEach(client -> clientList.add(client));
    }

    public void removeClientFromClientList(Client client) {
        clientList.remove(client);
    }
    public void removeClientToClietnList(List<Client> clients) {
        clients.forEach(client -> clientList.remove(client));
    }
}
