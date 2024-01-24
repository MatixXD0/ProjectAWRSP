package Library.Helpers.FileHelpers;

import Library.Data.Book;
import Library.Data.Ebook;
import Library.Data.Languages;
import Library.Helpers.DataGenerators.BookGenerator;

import java.io.*;
import java.util.Random;

public class BookFileHelpers {
    public static String readContent(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }


    public static Book createBookFromFile(String filePath) {
        if (filePath.endsWith(".txt")) {
            Book book = new Book();
            book.setFilePath(filePath);
            book.setFormat(".txt");
            createBookFromFileHelper(book);
            return book;
        } else {
            Ebook book = new Ebook();
            book.setFormat(".mobi");
            book.setSize(chceckFileSize(filePath));
            book.setFilePath(filePath);
            book.setFormat(".mobi");
            createBookFromFileHelper(book);
            return book;
        }
    }

    private static void createBookFromFileHelper(Book book) {
        try (BufferedReader reader = new BufferedReader(new FileReader(book.getFilePath()))) {
            String line;
            line=reader.readLine();
            String[] data = line.split(";");
            System.out.println(data.length);
            book.setTitle(data[0]);
            book.setAuthorName(data[1]);
            book.setAuthorSurname(data[2]);
            book.setPublicationYear(Integer.parseInt(data[3]));
            book.setIsbn(data[4]);
            book.setLanguage(Languages.valueOf(data[5]));
            book.setPagesNumber(Integer.parseInt(data[6]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void saveBookToFile(Book book) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(book.getFilePath()))) {
            StringBuilder builder = new StringBuilder();
            Random random = new Random();

            builder.append(book.getTitle()).append(";")
                    .append(book.getAuthorName()).append(";")
                    .append(book.getAuthorSurname()).append(";")
                    .append(book.getPublicationYear()).append(";")
                    .append(book.getIsbn()).append(";")
                    .append(book.getLanguage()).append(";")
                    .append(book.getPagesNumber()).append(";");

            writer.write(builder.toString());
            writer.newLine();
            writer.write(BookGenerator.generateLoremIpsum(random.nextInt(0,10000)));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long chceckFileSize(String filePath) {
        File file = new File(filePath);
        return file.length();
    }

}
