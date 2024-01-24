package Library.Helpers.FileHelpers;

import Library.Data.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClientFileHelpers {
    public static void saveClientListToFile(List<Client> list, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)))) {
            for (Client member : list) {
                StringBuilder builder = new StringBuilder();
                builder
                        .append(member.getName()).append(";")
                        .append(member.getSurname()).append(";")
                        .append(member.getSex()).append(";")
                        .append(member.getBornYear()).append(";")
                        .append(member.getAddress().getStreet()).append(";")
                        .append(member.getAddress().getFlatNo()).append(";")
                        .append(member.getAddress().getHouseNo()).append(";")
                        .append(member.getAddress().getPostalCode()).append(";")
                        .append(member.getAddress().getCity()).append(";")
                        .append(member.getAddress().getCountry()).append(";");

                writer.write(builder.toString());
                writer.newLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<String> readFromFile(String filePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void saveInvoiceToFile(String content){
        String fileName = "Invoice_" + System.currentTimeMillis() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
