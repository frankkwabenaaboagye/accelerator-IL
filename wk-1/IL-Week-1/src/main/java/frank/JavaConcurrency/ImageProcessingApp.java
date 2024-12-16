package frank.JavaConcurrency;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageProcessingApp {

    private final ExecutorService executorService;
    private final JFrame frame;
    private final DefaultListModel<String> logModel;

    public ImageProcessingApp() {

        executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        frame = new JFrame("Image Processing Thread Pool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JButton selectImagesButton = new JButton("Select Images");
        selectImagesButton.addActionListener(e -> selectAndProcessImages());

        logModel = new DefaultListModel<>();
        JList<String> logList = new JList<>(logModel);
        JScrollPane logScrollPane = new JScrollPane(logList);

        frame.setLayout(new BorderLayout());
        frame.add(selectImagesButton, BorderLayout.NORTH);
        frame.add(logScrollPane, BorderLayout.CENTER);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void selectAndProcessImages() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "bmp", "jpeg"));

        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();

            for (File file : selectedFiles) {
                executorService.submit(() -> processImage(file));
            }
        }
    }

    private void processImage(File file) {
        try {
            BufferedImage originalImage = ImageIO.read(file);

            if (originalImage == null) {
                log("Failed to load image: " + file.getName());
                return;
            }

            BufferedImage bwImage = convertToBlackAndWhite(originalImage);

            // Save the processed image
            File output = new File(file.getParent(), "BW_" + file.getName());
            ImageIO.write(bwImage, "jpg", output);

            log("Processed and saved: " + output.getAbsolutePath());
        } catch (IOException e) {
            log("Error processing image: " + file.getName() + " - " + e.getMessage());
        }
    }

    private BufferedImage convertToBlackAndWhite(BufferedImage original) {
        BufferedImage bwImage = new BufferedImage(original.getWidth(), original.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        Graphics g = bwImage.getGraphics();
        g.drawImage(original, 0, 0, null);
        g.dispose();
        return bwImage;
    }

    private void log(String message) {
        SwingUtilities.invokeLater(() -> logModel.addElement(message));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ImageProcessingApp app = new ImageProcessingApp();
            app.show();
        });
    }
}
