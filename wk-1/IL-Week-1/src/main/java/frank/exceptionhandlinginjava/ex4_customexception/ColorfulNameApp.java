package frank.exceptionhandlinginjava.ex4_customexception;

import javax.swing.*;
import java.awt.*;

public class ColorfulNameApp {

    private JFrame frame;
    private JTextField textField;
    private JLabel label;

    public ColorfulNameApp() {
        frame = new JFrame("Frank Color App");
        textField = new JTextField(20);
        label = new JLabel("Your colorful name will appear here!");

        JButton submitButton = new JButton("Display Name");

        frame.setLayout(new FlowLayout());
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JLabel("Enter your name:"));
        frame.add(textField);
        frame.add(submitButton);
        frame.add(label);

        submitButton.addActionListener(e -> {
            try {
                String name = textField.getText();
                // my custom exception
                if (name.isEmpty()) {
                    throw new FrankCustomException("Please your name cannot be empty");
                }
                displayColorfulName(name);
            } catch (FrankCustomException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);

    }

    private void displayColorfulName(String name) {
        // Set random colors for the name
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.MAGENTA};
        label.setText(name);
        label.setForeground(colors[(int) (Math.random() * colors.length)]);
    }

    public static void main(String[] args) {
        new ColorfulNameApp();
    }
}
