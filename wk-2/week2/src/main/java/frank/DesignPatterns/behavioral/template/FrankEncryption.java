package frank.DesignPatterns.behavioral.template;

public class FrankEncryption extends DataEncryption {

    @Override
    protected String generateKey() {
        return "FrankKey";
    }

    @Override
    protected String encrypt(String data, String key) {
        StringBuilder reversedData = new StringBuilder(data);
        return "Frank-Encrypted-" + reversedData.reverse();
    }

    @Override
    protected void decryptData(String encryptedData, String key) {
        String reversedData = encryptedData.replace("Frank-Encrypted-", "");
        StringBuilder originalData = new StringBuilder(reversedData);
        System.out.println("Decrypted Data (Frank): " + originalData.reverse().toString());
    }
}
