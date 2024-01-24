package Library.Helpers;

import Library.Data.Book;
import Library.Data.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientHelper {

    public static List<Client> convertListOfStringsToListOfClients(List<String> list) {
        List<Client> objectList = new ArrayList<>();

        for (String string : list) {
            objectList.add(convertStringToClient(string));
        }

        return objectList;
    }


    public static Client convertStringToClient(String data) {
        Client client = new Client();

        String[] split = data.split(";");

        client.setName(split[0]);
        client.setSurname(split[1]);
        client.setSex(split[2]);
        client.setBornYear((Integer.parseInt(split[3])));
        client.getAddress().setStreet(split[4]);
        client.getAddress().setFlatNo(split[5]);
        client.getAddress().setHouseNo(split[6]);
        client.getAddress().setPostalCode(split[7]);
        client.getAddress().setCity(split[8]);
        client.getAddress().setCountry(split[9]);

        return client;
    }

    public static String createInvoiceContent(Client client, Book book, int rentalDays) {
        double rentalCost = book.calculateRentalCost(rentalDays);
        return "Invoice Details:\n" +
                "Client Name: " + client.getName() + " " + client.getSurname() + "\n" +
                "Book Title: " + book.getTitle() + "\n" +
                "Rental Days: " + rentalDays + "\n" +
                "Total Cost: $" + rentalCost + "\n";
    }
}
