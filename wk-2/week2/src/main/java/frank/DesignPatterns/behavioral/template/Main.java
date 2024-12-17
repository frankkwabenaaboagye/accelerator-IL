package frank.DesignPatterns.behavioral.template;

public class Main {
    public static void main(String[] args) {
        // Encrypt and decrypt data using AES encryption
        DataEncryption aes = new AESEncryption();
        aes.encryptData("HelloWorld");

        System.out.println();

        // Encrypt and decrypt data using DES encryption
        DataEncryption des = new DESEncryption();
        des.encryptData("HelloWorld");

        System.out.println();


        // Encrypt and decrypt data using Frank encryption
        DataEncryption frank = new FrankEncryption();
        frank.encryptData("HelloWorld");
    }
}