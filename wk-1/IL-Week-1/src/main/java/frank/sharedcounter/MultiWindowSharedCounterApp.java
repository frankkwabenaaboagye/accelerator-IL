package frank.sharedcounter;

import javax.swing.*;
import java.awt.*;

public class MultiWindowSharedCounterApp {

    private int counter = 0; // Shared counter variable
    private boolean runningWindow1 = false; // Flag for window 1 timer
    private boolean runningWindow2 = false; // Flag for window 2 timer

    // Method to increment the counter safely
    public void increment() {
        synchronized (this) { // Synchronized block to ensure thread safety
            counter++; // Increment the shared counter
        }
    }

    // Method to get the current counter value
    public synchronized int getCounter() {
        return counter; // Return the current counter value
    }


    private void createWindow1() {
        JFrame frame = new JFrame("Window 1: Counter Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel counterLabel1 = new JLabel("0");
        counterLabel1.setFont(new Font("Arial", Font.BOLD, 40));
        counterLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(counterLabel1, BorderLayout.CENTER);

        JButton startButton1 = new JButton("Start");
        JButton stopButton1 = new JButton("Stop");
        stopButton1.setEnabled(false);

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.add(startButton1);
        buttonPanel1.add(stopButton1);
        panel1.add(buttonPanel1, BorderLayout.SOUTH);

        // Create a timer thread for Window 1
        Thread timerThread1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (runningWindow1) {
                        increment(); // Increment the shared counter
                        SwingUtilities.invokeLater(() -> counterLabel1.setText(String.valueOf(getCounter()))); // Update display 1
                    }
                    Thread.sleep(1000); // Update every 1 second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        startButton1.addActionListener(e -> {
            runningWindow1 = true; // Start the timer for window 1
            timerThread1.start();
            startButton1.setEnabled(false);
            stopButton1.setEnabled(true);
        });

        stopButton1.addActionListener(e -> {
            runningWindow1 = false; // Stop the timer for window 1
            startButton1.setEnabled(true);
            stopButton1.setEnabled(false);
        });

        frame.add(panel1);
        frame.setVisible(true);
    }

    private void createWindow2() {
        JFrame frame = new JFrame("Window 2: Counter Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel counterLabel2 = new JLabel("0");
        counterLabel2.setFont(new Font("Arial", Font.BOLD, 40));
        counterLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(counterLabel2, BorderLayout.CENTER);

        JButton startButton2 = new JButton("Start");
        JButton stopButton2 = new JButton("Stop");
        stopButton2.setEnabled(false);

        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.add(startButton2);
        buttonPanel2.add(stopButton2);
        panel2.add(buttonPanel2, BorderLayout.SOUTH);

        Thread timerThread2 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    if (runningWindow2) {
                        increment();
                        SwingUtilities.invokeLater(() -> counterLabel2.setText(String.valueOf(getCounter())));
                    }
                    Thread.sleep(800); // Update every 0.8 seconds
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        startButton2.addActionListener(e -> {
            runningWindow2 = true;
            timerThread2.start();
            startButton2.setEnabled(false);
            stopButton2.setEnabled(true);
        });

        stopButton2.addActionListener(e -> {
            runningWindow2 = false;
            startButton2.setEnabled(true);
            stopButton2.setEnabled(false);
        });

        frame.add(panel2);
        frame.setVisible(true);
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MultiWindowSharedCounterApp app = new MultiWindowSharedCounterApp();
            app.createWindow1();
            app.createWindow2();
        });
    }
}
