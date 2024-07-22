import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HomeFrame extends JFrame {
    Container c;
    JButton btnAdd, btnView, btnUpdate, btnDelete, btnBack;

    HomeFrame() {
        c = getContentPane();
        c.setLayout(new FlowLayout());

        btnAdd = new JButton("Add Donor");
        btnView = new JButton("View Donor");
        btnUpdate = new JButton("Update Donor");
        btnDelete = new JButton("Delete Donor");
        btnBack = new JButton("Back to WelcomeFrame");

        c.add(btnAdd);
        c.add(btnView);
        c.add(btnUpdate);
        c.add(btnDelete);
        c.add(btnBack);

        setSize(550, 550);
        setTitle("Blood Donor System");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new AddFrame();
                dispose();
            }
        });

        btnView.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new ViewFrame();
                dispose();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new UpdateFrame();
                dispose();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new DeleteFrame();
                dispose();
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new WelcomeFrame();
                dispose();
            }
        });
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame();
            }
        });
    }
}
