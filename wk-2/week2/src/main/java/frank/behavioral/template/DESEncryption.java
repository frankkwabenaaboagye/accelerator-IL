package frank.behavioral.template;

public class DESEncryption extends DataEncryption {

    @Override
    protected String generateKey() {
        return "DES-56-Key"; // i am doing this for simplicity, applies to the rest
    }

    @Override
    protected String encrypt(String data, String key) {
        return "DES-Encrypted-" + data;
    }

    @Override
    protected void decryptData(String encryptedData, String key) {
        System.out.println("Decrypted Data (DES): " + encryptedData.replace("DES-Encrypted-", ""));
    }
}
