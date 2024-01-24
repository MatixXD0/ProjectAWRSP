package Library.Helpers.DataGenerators;

import Library.Data.Address;
import Library.Data.Client;
import Library.Helpers.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientGenerator {
    public static List<Client> generateClientList(int n) {
        List<Client> ClientsList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            ClientsList.add(generateClient());
        return ClientsList;
    }

    public static Client generateClient() {
        Client client = new Client();
        Random random = new Random();
        String[] data = generateSexNameAndSurname();
        client.setSex(data[0]);
        client.setName(data[1]);
        client.setSurname(data[2]);
        client.setBornYear(random.nextInt(1960, 2002));
        client.setAddress(generateAddress());
        return client;
    }


    public static String[] generateSexNameAndSurname() {
        Random random = new Random();
        String[] data = new String[3];
        data[0] = Constants.SEXES[random.nextInt(Constants.SEXES.length)];
        if (data[0].equals("Mężczyzna")) {
            data[1] = Constants.MALE_NAMES[random.nextInt(Constants.MALE_NAMES.length)];
            data[2] = Constants.MALE_SURNAMES[random.nextInt(Constants.MALE_SURNAMES.length)];
        } else {
            data[1] = Constants.FEMALE_NAMES[random.nextInt(Constants.FEMALE_NAMES.length)];
            data[2] = Constants.FEMALE_SURNAMES[random.nextInt(Constants.FEMALE_SURNAMES.length)];
        }
        return data;
    }


    private static Address generateAddress() {
        Address address = new Address();
        Random random = new Random();
        address.setStreet(Constants.STREETS[random.nextInt(Constants.STREETS.length)]);
        address.setFlatNo(generateAddressNumber());
        address.setHouseNo(generateAddressNumber());
        address.setPostalCode(genratePostalCode());
        address.setCity(Constants.CITIES[random.nextInt(Constants.CITIES.length)]);
        address.setCountry(Constants.COUNTRIES[random.nextInt(Constants.COUNTRIES.length)]);
        return address;
    }

    private static String generateAddressNumber() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(random.nextInt(1, 1000));
        if (random.nextBoolean()) stringBuilder.append((char) random.nextInt(65, 91));
        return stringBuilder.toString();
    }

    private static String genratePostalCode() {
        Random random = new Random();
        return new StringBuilder().append(random.nextInt(10)).append(random.nextInt(10)).append("-").append(random.nextInt(10)).append(random.nextInt(10)).append(random.nextInt(10)).toString();
    }


}
