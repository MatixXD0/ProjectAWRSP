package Library.Helpers.StatisticHelpers;

import Library.Data.Book;
import Library.Helpers.FileHelpers.BookFileHelpers;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookStatisticHelper {

    public static String returnContent(Book book) {
        return BookFileHelpers.readContent(book.getFilePath());
    }

    public static int calculateThisWord(Book book, String word) {
        String content = returnContent(book);
        return Arrays.stream(content.split("\\s+"))
                .filter(w -> w.equalsIgnoreCase(word))
                .mapToInt(w -> 1)
                .sum();
    }

    public static void calculateAverageBookAge(List<Book> BookList) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        double averageAge = BookList.stream()
                .mapToInt(b -> currentYear - b.getPublicationYear())
                .average()
                .orElse(0.0);
        System.out.println("Average Book Age: " + averageAge);
    }

    public static int wordsNumber(Book book) {
        String content = returnContent(book);
        return Arrays.stream(content.split("\\s+"))
                .mapToInt(w -> 1)
                .sum();
    }

    public static String theMostPopularWord(Book book) {
        String content = returnContent(book);
        return Arrays.stream(content.split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static Map<String, Long> wordFrequencyDistribution(Book book) {
        String content = returnContent(book);
        return Arrays.stream(content.split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static int uniqueWordsCount(Book book) {
        String content = returnContent(book);
        return (int) Arrays.stream(content.split("\\s+"))
                .map(String::toLowerCase)
                .distinct()
                .count();
    }

    public static String findLongestWord(Book book) {
        String content = returnContent(book);
        return Arrays.stream(content.split("\\s+"))
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    public static int chapterCount(Book book) {
        String content = returnContent(book);
        return (int) Arrays.stream(content.split("\\s+"))
                .filter(word -> word.equalsIgnoreCase("Chapter"))
                .count();
    }

    public static List<Integer> wordOccurrences(Book book, String targetWord) {
        String content = returnContent(book);
        String[] words = content.split("\\s+");
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(targetWord)) {
                positions.add(i);
            }
        }
        return positions;
    }


    public static double estimatedReadingTime(Book book) {
        int totalWords = wordsNumber(book);
        double averageReadingSpeedWordsPerMinute = 250;
        return totalWords / averageReadingSpeedWordsPerMinute;
    }

    public static double averageSentenceLength(Book book) {
        String content = returnContent(book);
        String[] sentences = content.split("\\.\\s*");
        int totalWords = Arrays.stream(sentences)
                .mapToInt(sentence -> sentence.split("\\s+").length)
                .sum();
        return (double) totalWords / sentences.length;
    }

    public static Map<String, Long> topNFrequentWords(Book book, int n) {
        String content = returnContent(book);
        return Arrays.stream(content.split("\\s+"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
