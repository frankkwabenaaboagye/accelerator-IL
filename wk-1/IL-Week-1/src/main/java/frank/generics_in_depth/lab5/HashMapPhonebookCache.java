package frank.generics_in_depth.lab5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HashMapPhonebookCache implements PhonebookCache {
    private final Map<String, String> phonebook;
    private final String fileName = "phonebook.txt";

    public HashMapPhonebookCache() {
        phonebook = new HashMap<>();
    }

    @Override
    public void addOrUpdateContact(String name, String phoneNumber) {
        phonebook.put(name, phoneNumber);
        writeToFile();
    }

    @Override
    public String getContact(String name) {
        return phonebook.get(name);
    }

    @Override
    public void removeContact(String name) {
        phonebook.remove(name);
        writeToFile();
    }

    @Override
    public void printAllContacts() {
        readFromFile();
        phonebook.forEach((name, phoneNumber) -> {
            System.out.println("Name: " + name + ", Phone Number: " + phoneNumber);
        });
    }

    private void writeToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            phonebook.forEach((name, phoneNumber) -> {
                try {
                    writer.write(name + ": " + phoneNumber);
                    writer.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                phonebook.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
