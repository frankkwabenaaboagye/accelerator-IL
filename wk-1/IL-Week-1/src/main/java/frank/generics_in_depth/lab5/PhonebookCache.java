package frank.generics_in_depth.lab5;

public interface PhonebookCache {
    void addOrUpdateContact(String name, String phoneNumber);
    String getContact(String name);
    void removeContact(String name);
    void printAllContacts();
}
