package Library.Data;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    private String street;
    private String flatNo;
    private String houseNo;
    private String postalCode;
    private String city;
    private String country;

    public void printInfo() {
        System.out.println("Address Information:");
        System.out.println("Street: " + street);
        System.out.println("Flat No: " + flatNo);
        System.out.println("House No: " + houseNo);
        System.out.println("Postal Code: " + postalCode);
        System.out.println("City: " + city);
        System.out.println("Country: " + country);
    }
}


