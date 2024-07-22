import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFrame extends JFrame {
    Container c;
    JButton btnSave, btnBack;
    JLabel lblId, lblFname, lblLname, lblAge, lblWeight, lblDaysSinceLastDonation, lblPulse, lblSP, lblDP, lblBG, lblTemp, lblPhone, lblEmail;
    JTextField txtId, txtFname, txtLname, txtAge, txtWeight, txtDaysSinceLastDonation, txtPulse, txtSP, txtDP, txtBG, txtTemp, txtPhone, txtEmail;
    JPanel p1, p2, p3, p4, p5, p6, p7;

    UpdateFrame() {
        c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();
        p6 = new JPanel();
        p7 = new JPanel();

        lblId = new JLabel("Id");
        txtId = new JTextField(5);

        lblFname = new JLabel("First Name");
        txtFname = new JTextField(10);

        lblLname = new JLabel("Last Name");
        txtLname = new JTextField(10);

        lblAge = new JLabel("Age");
        txtAge = new JTextField(5);

        lblWeight = new JLabel("Weight");
        txtWeight = new JTextField(5);

        lblDaysSinceLastDonation = new JLabel("Days Since Last Donation");
        txtDaysSinceLastDonation = new JTextField(5);

        lblPulse = new JLabel("Pulse");
        txtPulse = new JTextField(5);

        lblSP = new JLabel("Systolic Pressure");
        txtSP = new JTextField(5);

        lblDP = new JLabel("Dystolic Pressure");
        txtDP = new JTextField(5);

        lblBG = new JLabel("Blood Group");
        txtBG = new JTextField(5);

        lblTemp = new JLabel("Temperature");
        txtTemp = new JTextField(5);

        lblPhone = new JLabel("Phone");
        txtPhone = new JTextField(10);

        lblEmail = new JLabel("Email");
        txtEmail = new JTextField(10);

        p1.add(lblId);
        p1.add(txtId);

        p1.add(lblFname);
        p1.add(txtFname);

        p1.add(lblLname);
        p1.add(txtLname);

        p2.add(lblAge);
        p2.add(txtAge);

        p2.add(lblWeight);
        p2.add(txtWeight);

        p3.add(lblDaysSinceLastDonation);
        p3.add(txtDaysSinceLastDonation);

        p3.add(lblPulse);
        p3.add(txtPulse);

        p4.add(lblSP);
        p4.add(txtSP);

        p4.add(lblDP);
        p4.add(txtDP);

        p5.add(lblBG);
        p5.add(txtBG);

        p5.add(lblTemp);
        p5.add(txtTemp);

        p6.add(lblPhone);
        p6.add(txtPhone);

        p6.add(lblEmail);
        p6.add(txtEmail);

        btnSave = new JButton("Update");
        btnBack = new JButton("Back");
        p7.add(btnSave);
        p7.add(btnBack);

        c.add(p1);
        c.add(p6);
        c.add(p2);
        c.add(p3);
        c.add(p4);
        c.add(p5);
        c.add(p7);

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    Integer id = Integer.parseInt(txtId.getText());
                    String fname = txtFname.getText();
                    String lname = txtLname.getText();
                    Integer age = Integer.parseInt(txtAge.getText());
                    Double weight = Double.parseDouble(txtWeight.getText());
                    Integer daysSinceLastDonation = Integer.parseInt(txtDaysSinceLastDonation.getText());
                    Integer pulse = Integer.parseInt(txtPulse.getText());
                    Integer sp = Integer.parseInt(txtSP.getText());
                    Integer dp = Integer.parseInt(txtDP.getText());
                    String bg = txtBG.getText();
                    Integer temp = Integer.parseInt(txtTemp.getText());
                    String phone = txtPhone.getText();
                    String email = txtEmail.getText();

                    if (fname.length() == 0) {
                        JOptionPane.showMessageDialog(c, "First Name is empty");
                        txtFname.requestFocus();
                    }

                    if (lname.length() == 0) {
                        JOptionPane.showMessageDialog(c, "Last Name is empty");
                        txtLname.requestFocus();
                    }

                    if (age == null) {
                        JOptionPane.showMessageDialog(c, "Age is empty");
                        txtAge.requestFocus();
                    }

                    if (weight == null) {
                        JOptionPane.showMessageDialog(c, "Weight is empty");
                        txtWeight.requestFocus();
                    }

                    if (daysSinceLastDonation == null) {
                        JOptionPane.showMessageDialog(c, "Days Since Last Donation is empty");
                        txtDaysSinceLastDonation.requestFocus();
                    }

                    if (pulse == null) {
                        JOptionPane.showMessageDialog(c, "Pulse is empty");
                        txtPulse.requestFocus();
                    }

                    if (sp == null) {
                        JOptionPane.showMessageDialog(c, "Systolic Pressure is empty");
                        txtSP.requestFocus();
                    }

                    if (dp == null) {
                        JOptionPane.showMessageDialog(c, "Dystolic Pressure is empty");
                        txtDP.requestFocus();
                    }

                    if (bg.length() == 0) {
                        JOptionPane.showMessageDialog(c, "Blood Group is empty");
                        txtBG.requestFocus();
                    }

                    if (temp == null) {
                        JOptionPane.showMessageDialog(c, "Temperature is empty");
                        txtTemp.requestFocus();
                    }

                    if (phone.length() == 0) {
                        JOptionPane.showMessageDialog(c, "Phone is empty");
                        txtPhone.requestFocus();
                    }

                    if (email.length() == 0) {
                        JOptionPane.showMessageDialog(c, "Email is empty");
                        txtEmail.requestFocus();
                    }

                    // Update the donor information in the database
                    new Db().updateDonor(id, fname, lname, age, weight, daysSinceLastDonation, pulse, sp, dp, bg, temp, phone, email);

                    // Clear text fields after updating
                    txtId.setText("");
                    txtFname.setText("");
                    txtLname.setText("");
                    txtAge.setText("");
                    txtWeight.setText("");
                    txtDaysSinceLastDonation.setText("");
                    txtPulse.setText("");
                    txtSP.setText("");
                    txtDP.setText("");
                    txtBG.setText("");
                    txtTemp.setText("");
                    txtPhone.setText("");
                    txtEmail.setText("");

                } catch (NumberFormatException | ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(c, "Please enter a number");
                    txtAge.setText("");
                    txtAge.requestFocus();
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                HomeFrame h = new HomeFrame();
                dispose();
            }
        });

        setSize(500, 400);
        setTitle("Update Donor");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
