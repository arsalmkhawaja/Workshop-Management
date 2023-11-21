package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Payment extends JFrame {

    private JPanel contentPane;
    static int choice = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Payment frame = new Payment();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Payment() {
        setTitle("PAYMENT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 377, 275);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblSearchFrom = new JLabel("Payment Type:");
        lblSearchFrom.setFont(new Font("Poppins", Font.BOLD, 12));
        lblSearchFrom.setBounds(55, 83, 151, 14);
        contentPane.add(lblSearchFrom);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerMenu field = new CustomerMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(233, 202, 89, 23);
        contentPane.add(button);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(
                new DefaultComboBoxModel(new String[] { "Credit Card", "Cash", "JazzCash", "Wire Transfer" }));
        comboBox.setBounds(150, 80, 150, 20);
        contentPane.add(comboBox);

        JButton btnNewButton = new JButton("Continue");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String confirmation = comboBox.getSelectedItem().toString();
                if (confirmation.equals("Credit Card")) {
                    choice = 1;
                } else if (confirmation.equals("Cash")) {
                    choice = 2;
                } else if (confirmation.equals("JazzCash")) {
                    choice = 3;
                } else if (confirmation.equals("Wire Transfer")) {
                    choice = 4;
                }
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "Arsal";
                    String pwd = "Arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);

                    String query = "INSERT INTO payments (customer_id, order_id, payment_date, payment_amount, payment_method_id) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, PlaceOrder.customerId);
                    pst.setString(2, String.valueOf(PlaceOrder.id));
                    pst.setString(3, PlaceOrder.date);
                    pst.setString(4, String.valueOf(PlaceOrder.amount));
                    pst.setString(5, String.valueOf(choice));
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Payment done successfully");
                    int choose = 0;
                    if (choose == JOptionPane.OK_OPTION) {
                        CustomerMenu field = new CustomerMenu();
                        field.setVisible(true);
                        setVisible(false);
                    }
                    connection.close();

                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnNewButton.setBounds(53, 202, 89, 23);
        contentPane.add(btnNewButton);
    }
}
