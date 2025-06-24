package Ch5JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class JdbcDemo extends JFrame implements ActionListener {
    JLabel ID, Name, Email, Password;
    JTextField id, name, email, pass;
    JButton Ok;

    JdbcDemo() {
        super("Database Form");

        // Initialize components
        ID = new JLabel("ID:");
        Name = new JLabel("Name:");
        Email = new JLabel("Email:");
        Password = new JLabel("Password:");

        id = new JTextField(20);
        name = new JTextField(20);
        email = new JTextField(20);
        pass = new JTextField(20);
        Ok = new JButton("Insert");

        setLayout(new FlowLayout());

        add(ID); add(id);
        add(Name); add(name);
        add(Email); add(email);
        add(Password); add(pass);
        add(Ok);

        Ok.addActionListener(this);

        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String idd = id.getText();
        String namee = name.getText();
        String emaill = email.getText();
        String passs = pass.getText();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db", "root", "");

            String q = "INSERT INTO user (id, name, email, password) VALUES (?, ?, ?, ?)";
            PreparedStatement pre = con.prepareStatement(q);
            pre.setString(1, idd);
            pre.setString(2, namee);
            pre.setString(3, emaill);
            pre.setString(4, passs);

            pre.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Inserted Successfully");

            pre.close();
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JdbcDemo();
    }
}

