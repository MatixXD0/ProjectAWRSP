package Library.Helpers.StatisticHelpers;

import Library.Data.Book;
import Library.Data.Client;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClientStatisticHelper {

    public static void calculateGenderDistribution(List<Client> clientsList) {
        long maleCount = clientsList.stream().filter(p -> p.getSex().equals("Mężczyzna")).count();
        long femaleCount = clientsList.size() - maleCount;

        System.out.println("Gender Distribution:");
        System.out.println("Male count: " + maleCount);
        System.out.println("Female count: " + femaleCount);
    }

    public static void calculateAverageAge(List<Client> clientList) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        double averageAge = clientList.stream()
                .mapToInt(p -> currentYear - p.getBornYear())
                .average()
                .orElse(0.0);

        System.out.println("Average Age: " + averageAge);
    }


    public static Map<Book, Long> mostBorrowedBooks(List<Client> clients) {
        return clients.stream()
                .flatMap(client -> client.getLoanHistory().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Book, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }


    public static double averageNumberOfLoans(List<Client> clients) {
        return clients.stream()
                .mapToInt(client -> client.getLoanHistory().size())
                .average()
                .orElse(0.0);
    }


    public static void clientLoanHistoryAnalysis(List<Client> clients) {
        clients.forEach(client -> {
            System.out.println("Client: " + client.getName() + " " + client.getSurname());
            System.out.println("Total Loans: " + client.getLoanHistory().size());
            // Further analysis can be added here
        });
    }
}
