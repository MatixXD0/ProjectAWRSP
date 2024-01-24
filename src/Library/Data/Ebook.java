package Library.Data;

import Library.Data.Book;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Ebook extends Book {
    private long size;
    @Override
    public double calculateRentalCost(int numberOfDays) {
        return super.calculateRentalCost(numberOfDays) -5.0;
    }

    @Override
    public String toString() {
        return "Ebook{" +
                ", size=" + size +
                "} " + super.toString();
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Size " + size + "bytes");
    }
}
