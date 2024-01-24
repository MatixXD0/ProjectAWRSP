package Library.Helpers.DataGenerators;

import Library.Data.Book;
import Library.Data.Client;
import Library.Data.Ebook;
import Library.Data.Languages;
import Library.Helpers.Constants;
import Library.Helpers.FileHelpers.BookFileHelpers;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookGenerator {

    public static List<Book> generateBookList(int n) {
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            bookList.add(generateBoook());
        return bookList;
    }

    public static Book generateBoook() {
        Random random = new Random();
        String type = Constants.BOOK_TYPES[random.nextInt(Constants.BOOK_TYPES.length)];
        if (type.equals(".txt")) {
            Book book = new Book();
            book.setFormat(".txt");
            generateRandomBookHelper(book);
            return book;
        } else {
            Ebook book = new Ebook();
            book.setFormat(type);
            book.setSize(random.nextInt(0, 1000));
            book.setFormat(".mobi");
            generateRandomBookHelper(book);
            book.setSize(BookFileHelpers.chceckFileSize(book.getFilePath()));
            return book;
        }
    }

    private static void generateRandomBookHelper(Book book) {
        Random random = new Random();

        book.setTitle(Constants.BOOK_TITLES[random.nextInt(Constants.BOOK_TITLES.length)]);
        String[] data = ClientGenerator.generateSexNameAndSurname();
        book.setAuthorName(data[1]);
        book.setAuthorSurname(data[2]);
        book.setPublicationYear(random.nextInt(1800, 2025));
        book.setIsbn(String.valueOf(random.nextLong(1000000, 999999999)));
        book.setLanguage(Languages.values()[random.nextInt(Languages.values().length)]);
        book.setPagesNumber(random.nextInt(0, 1000));
        book.setAvailable(true);
        book.setFilePath("./src/" + genreateFileName(book));
        BookFileHelpers.saveBookToFile(book);

    }

    public static String generateLoremIpsum(int wordCount) {
        Random random = new Random();
        StringBuilder loremIpsum = new StringBuilder();

        for (int i = 0; i < wordCount; i++) {
            loremIpsum.append(Constants.WORDS[random.nextInt(Constants.WORDS.length)]);
            if (i < wordCount - 1) {
                loremIpsum.append(" ");
            }
        }

        return loremIpsum.toString();
    }

    private static String genreateFileName(Book book) {
        StringBuilder builder = new StringBuilder();
        builder.append(book.getTitle()).append(" ").append(book.getAuthorName()).append(" ").append(book.getAuthorSurname());
        if (book.getFormat() == ".txt") {
            builder.append(".txt");
        } else builder.append(".mobi");
        return builder.toString();
    }
}
