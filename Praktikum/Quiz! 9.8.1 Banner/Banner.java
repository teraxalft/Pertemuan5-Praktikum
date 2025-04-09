import javax.swing.*;
import java.awt.*;

public class Banner extends JFrame implements Runnable {
    private String message = " Your name here! ";
    private JLabel label;

    public Banner() {
        // Setup JFrame
        setTitle("Banner");
        setSize(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center the window

        // Setup JLabel
        label = new JLabel(message, JLabel.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 20));
        label.setForeground(Color.RED);
        label.setBackground(Color.CYAN);
        label.setOpaque(true);
        add(label);

        setVisible(true);

        // Mulai thread
        Thread thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (true) {
            // Geser string ke kiri
            message = message.substring(1) + message.charAt(0);
            label.setText(message);

            try {
                Thread.sleep(300); // jeda 300 milidetik
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Banner();
    }
}
