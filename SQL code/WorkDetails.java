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

public class WorkDetails extends JFrame {

    private JPanel contentPane;
    private JTextField customerId;
    private JTextField date;
    private JTextField amount;
    static String worker_id = "";
    static String branch_id = "";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WorkDetails frame = new WorkDetails();
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
    public WorkDetails() {
        setTitle("WORK DETAILS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 625, 380);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblSuppliers = new JLabel("WORK DETAILS");
        lblSuppliers.setFont(new Font("Poppins", Font.BOLD, 18));
        lblSuppliers.setBounds(240, 24, 149, 16);
        contentPane.add(lblSuppliers);

        JLabel lblAddTheSupplier = new JLabel("Add work details:");
        lblAddTheSupplier.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheSupplier.setBounds(47, 54, 331, 16);
        contentPane.add(lblAddTheSupplier);

        JLabel lblNewLabel = new JLabel("Customer ID:");
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel.setBounds(157, 95, 98, 14);
        contentPane.add(lblNewLabel);

        JLabel lblDate = new JLabel("Date (YYYY-MM-DD):");
        lblDate.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblDate.setBounds(157, 155, 149, 14);
        contentPane.add(lblDate);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblAmount.setBounds(157, 215, 84, 17);
        contentPane.add(lblAmount);

        customerId = new JTextField();
        customerId.setBounds(335, 95, 109, 20);
        contentPane.add(customerId);
        customerId.setColumns(10);

        date = new JTextField();
        date.setBounds(335, 155, 109, 20);
        contentPane.add(date);
        date.setColumns(10);

        amount = new JTextField();
        amount.setBounds(335, 215, 109, 20);
        contentPane.add(amount);
        amount.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "Arsal";
                    String pwd = "Arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);

                    String query1 = "SELECT worker_id, branch_id FROM worker WHERE username='" + (WorkerLogin.login)
                            + "';";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query1);
                    while (resultSet.next()) {
                        worker_id = resultSet.getString(1);
                        branch_id = resultSet.getString(2);
                    }

                    String query = "INSERT INTO works (worker_id, customer_id, branch_id, date, amount) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, worker_id);
                    pst.setString(2, customerId.getText());
                    pst.setString(3, branch_id);
                    pst.setString(4, date.getText());
                    pst.setString(5, amount.getText());
                    pst.executeUpdate();

                    String query2 = "SELECT LAST_INSERT_ID()";
                    Statement statement1 = connection.createStatement();
                    ResultSet resultSet1 = statement1.executeQuery(query2);
                    int id = 0;
                    while (resultSet1.next()) {
                        id = resultSet1.getInt(1);
                    }

                    JOptionPane.showMessageDialog(null, "Values inserted successfully with ID: " + id);
                    int choose = 0;
                    if (choose == JOptionPane.OK_OPTION) {
                        WorkerMenu field = new WorkerMenu();
                        field.setVisible(true);
                        setVisible(false);
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnAdd.setBounds(452, 290, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                customerId.setText("");
                date.setText("");
                amount.setText("");
            }
        });
        btnReset.setBounds(258, 290, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkerAdd field = new WorkerAdd();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(71, 290, 89, 23);
        contentPane.add(button);
    }
}
