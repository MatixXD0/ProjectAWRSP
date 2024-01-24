package Library.Data;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Book {
    private String title;
    private String authorName;
    private String authorSurname;
    private int publicationYear;
    private String isbn;
    private Languages language;
    private boolean available;
    private int pagesNumber;
    private String filePath;
    private String format;

    public double calculateRentalCost(int numberOfDays){
        if (numberOfDays<=0)
            throw new IllegalArgumentException("numberOfDays must be positive");
        double totalCost = 10.0;
        if (numberOfDays>30)
            totalCost+=(numberOfDays-30)*0.5;
        if (this.getPagesNumber()>100 && this.getPagesNumber()<=500)
            totalCost+=2.0;
        if (this.getPagesNumber()>500)
            totalCost+=(this.pagesNumber -500)*0.1;
        return totalCost;
    }

    public void printBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + authorName + " " + authorSurname);
    }


    public void printInfo() {
        System.out.println("Book Information:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + authorName + " " + authorSurname);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("ISBN: " + isbn);
        System.out.println("Language: " + language);
        System.out.println("Available: " + available);
        System.out.println("Number of Pages: " + pagesNumber);
        System.out.println("File Path: " + filePath);
        System.out.println("Format: " + format);
    }
}
