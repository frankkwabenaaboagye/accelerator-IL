package frank.generics_in_depth.lab5;


public class PhonebookCacheDemo {
    private final boolean useConcurrent; // i made the testing simple - false for HashMap, true for ConcurrentHashMap

    public PhonebookCacheDemo(boolean useConcurrent) {
        this.useConcurrent = useConcurrent;
    }

    private PhonebookCache chooseCacheImplementation() {
        if (useConcurrent) {
            System.out.println("Using ConcurrentHashMapPhonebookCache");
            return new ConcurrentHashMapPhonebookCache();
        } else {
            System.out.println("Using HashMapPhonebookCache");
            return new HashMapPhonebookCache();
        }
    }

    public static void main(String[] args) {
        boolean useConcurrent = true;  // Set to false so that you can see the issues with HashMap (non-thread-safe)
        PhonebookCacheDemo pcd = new PhonebookCacheDemo(useConcurrent);

        PhonebookCache cache = pcd.chooseCacheImplementation();

        // Simulate writing to the phonebook (file) concurrently
        Runnable addContactsTask = () -> {
            cache.addOrUpdateContact("Frank", "123-456-7890");
            cache.addOrUpdateContact("Ruth", "987-654-3210");
            cache.addOrUpdateContact("Spencer", "555-555-5555");
        };

        Runnable updateContactsTask = () -> {
            cache.addOrUpdateContact("Frank", "111-222-3333"); // i am simultaneously updating Frank's number
            cache.addOrUpdateContact("Ruth", "444-555-6666"); // the same thing here, I am simultaneously update Ruth's number
        };

        Runnable removeContactsTask = () -> {
            cache.removeContact("Spencer");
        };

        Thread addThread = new Thread(addContactsTask);
        Thread updateThread = new Thread(updateContactsTask);
        Thread removeThread = new Thread(removeContactsTask);

        addThread.start();
        updateThread.start();
        removeThread.start();

        try {
            addThread.join();
            updateThread.join();
            removeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal state of the phonebook:");
        cache.printAllContacts();
    }
}
