package com.company;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Reservations extends JFrame {

    private JPanel contentPane;
    private JTextField date;
    static String customer_id = "";
    static String branch_id = "";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reservations frame = new Reservations();
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
    public Reservations() {
        setTitle("RESERVATIONS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 625, 330);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblSuppliers = new JLabel("RESERVATIONS");
        lblSuppliers.setFont(new Font("Poppins", Font.BOLD, 18));
        lblSuppliers.setBounds(220, 24, 149, 16);
        contentPane.add(lblSuppliers);

        JLabel lblAddTheSupplier = new JLabel("Add the details of the reservation:");
        lblAddTheSupplier.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheSupplier.setBounds(47, 54, 331, 16);
        contentPane.add(lblAddTheSupplier);

        JLabel lblNewLabel = new JLabel("Date (YYYY-MM-DD):");
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel.setBounds(157, 125, 148, 14);
        contentPane.add(lblNewLabel);

        date = new JTextField();
        date.setBounds(335, 125, 109, 20);
        contentPane.add(date);
        date.setColumns(10);

        JButton btnAdd = new JButton("Reserve");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "arsal";
                    String pwd = "arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);

                    String query2 = "SELECT customer_id, branch_id FROM customer WHERE username='"+(CustomerLogin.login)+"';";
                    Statement statement2 = connection.createStatement();
                    ResultSet resultSet2 = statement2.executeQuery(query2);
                    while (resultSet2.next()){
                        customer_id =  resultSet2.getString(1);
                        branch_id = resultSet2.getString(2);
                    }

                    String query = "INSERT INTO reservations (customer_id, branch_id, date) VALUES (?, ?, ?)";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, customer_id);
                    pst.setString(2, branch_id);
                    pst.setString(3, date.getText());
                    pst.executeUpdate();

                    String query1 = "SELECT LAST_INSERT_ID()";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query1);
                    int id = 0;
                    while (resultSet.next()){
                        id = resultSet.getInt(1);
                    }

                    JOptionPane.showMessageDialog(null, "Your reservation is successfully booked!");
                    int choose=0;
                    if(choose==JOptionPane.OK_OPTION)
                    {
                        CustomerMenu field = new CustomerMenu();
                        field.setVisible(true);
                        setVisible(false);
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnAdd.setBounds(71, 230, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                date.setText("");
            }
        });
        btnReset.setBounds(258, 230, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerMenu field = new CustomerMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(452, 230, 89, 23);
        contentPane.add(button);
    }
}

