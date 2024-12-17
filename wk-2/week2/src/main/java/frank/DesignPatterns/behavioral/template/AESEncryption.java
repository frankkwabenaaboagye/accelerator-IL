package frank.DesignPatterns.behavioral.template;

public class AESEncryption extends DataEncryption {

    @Override
    protected String generateKey() {
        return "AES-128-Key";  // doing this for simplicity
    }

    @Override
    protected String encrypt(String data, String key) {
        return "AES-Encrypted-" + data;
    }

    @Override
    protected void decryptData(String encryptedData, String key) {
        System.out.println("Decrypted Data (AES): " + encryptedData.replace("AES-Encrypted-", ""));
    }
}