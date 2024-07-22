import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WelcomeFrame extends JFrame {

    WelcomeFrame() {
        setTitle("Welcome to Blood Donor System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        setLayout(new BorderLayout());

        // Empty label as a placeholder for three lines above the Welcome message
        JLabel lblEmpty1 = new JLabel();
        add(lblEmpty1, BorderLayout.NORTH);
        JLabel lblEmpty2 = new JLabel();
        add(lblEmpty2, BorderLayout.NORTH);
        JLabel lblEmpty3 = new JLabel();
        add(lblEmpty3, BorderLayout.NORTH);

        // Welcome message button (to open HomeFrame)
        JButton btnWelcome = new JButton("Welcome to Blood Donor System");
        btnWelcome.setFont(new Font("Arial", Font.BOLD, 24));
        btnWelcome.setBorderPainted(false);
        btnWelcome.setFocusPainted(false);
        btnWelcome.setContentAreaFilled(false);
        btnWelcome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnWelcome, BorderLayout.CENTER);

        btnWelcome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeFrame();
                dispose();
            }
        });

        // Empty label as a placeholder for three lines below the Welcome message
        JLabel lblEmpty4 = new JLabel();
        add(lblEmpty4, BorderLayout.SOUTH);
        JLabel lblEmpty5 = new JLabel();
        add(lblEmpty5, BorderLayout.SOUTH);
        JLabel lblEmpty6 = new JLabel();
        add(lblEmpty6, BorderLayout.SOUTH);

        // Date and Time labels
        JLabel lblDateTime = new JLabel();
        lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
        add(lblDateTime, BorderLayout.SOUTH);

        // Update date and time every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                Date now = new Date();
                lblDateTime.setText(dateFormat.format(now) + "   " + timeFormat.format(now));
            }
        });
        timer.start();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WelcomeFrame();
            }
        });
    }
}
