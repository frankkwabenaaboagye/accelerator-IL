package frank.exceptionhandlinginjava.ex3_releaseingresources;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GifDisplay {

    public static void openAndDisplayGif(String filePath) {
        FileInputStream fis = null;

        try{

            File file = new File(filePath);
            fis = new FileInputStream(file);

            // Image image = javax.imageio.ImageIO.read(fis);
            ImageIcon gifIcon = new ImageIcon(fis.readAllBytes());

            JFrame frame  = new JFrame("Frank Gif Displayer");
            // JLabel label = new JLabel(new ImageIcon(image));
            JLabel label = new JLabel(gifIcon);
            frame.add(label);
            frame.setSize(gifIcon.getIconWidth(), gifIcon.getIconHeight());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }catch (IOException e){
            System.err.println("Error reading the gif file: " + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.err.println("Error closing the file: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        openAndDisplayGif("frank.gif");
    }
}
