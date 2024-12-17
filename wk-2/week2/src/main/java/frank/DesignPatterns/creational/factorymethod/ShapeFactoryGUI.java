package frank.DesignPatterns.creational.factorymethod;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeFactoryGUI {

    private static Shape currentShape = null; // Keeps track of the currently selected shape

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shape Factory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.SOUTH);
        placeComponents(panel);

        // Custom panel to draw the shapes
        DrawingPanel drawingPanel = new DrawingPanel();
        frame.add(drawingPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Choose a shape:");
        panel.add(label);

        JButton circleButton = new JButton("Circle");
        panel.add(circleButton);

        JButton squareButton = new JButton("Square");
        panel.add(squareButton);

        ShapeFactory shapeFactory = new ShapeFactory();

        // Action Listener for Circle Button
        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = shapeFactory.getShape("CIRCLE");
                panel.repaint(); // Request the panel to repaint and show the shape
            }
        });

        // Action Listener for Square Button
        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentShape = shapeFactory.getShape("SQUARE");
                panel.repaint(); // Request the panel to repaint and show the shape
            }
        });
    }

    // Custom JPanel to handle drawing
    static class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Calls the parent class' paintComponent to ensure correct rendering
            if (currentShape != null) {
                // Draw the shape in the center of the panel
                int x = getWidth() / 2 - 50; // Center the shape
                int y = getHeight() / 2 - 50;
                currentShape.draw(g, x, y); // Draw the selected shape
            }
        }
    }
}
