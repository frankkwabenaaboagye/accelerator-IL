package frank.behavioral.template;

public abstract class DataEncryption {

    public final void encryptData(String data) {
        String key = generateKey();
        String encryptedData = encrypt(data, key);
        System.out.println("Encrypted Data: " + encryptedData);
        decryptData(encryptedData, key);
    }

    abstract String generateKey();
    abstract String encrypt(String data, String key);
    abstract void decryptData(String encryptedData, String key);
}