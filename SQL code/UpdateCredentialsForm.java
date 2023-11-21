package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class UpdateCredentialsForm extends JFrame {

    private JPanel contentPane;
    private JTextField name;
    private JPasswordField phone;
    private static String worker_id;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateCredentialsForm frame = new UpdateCredentialsForm();
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
    public UpdateCredentialsForm() {
        setTitle("UPDATE CREDENTIALS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 625, 380);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblSuppliers = new JLabel("UPDATE CREDENTIALS");
        lblSuppliers.setFont(new Font("Poppins", Font.BOLD, 18));
        lblSuppliers.setBounds(200, 24, 259, 16);
        contentPane.add(lblSuppliers);

        JLabel lblAddTheSupplier = new JLabel("Update your credentials");
        lblAddTheSupplier.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheSupplier.setBounds(47, 60, 331, 16);
        contentPane.add(lblAddTheSupplier);

        JLabel lblNewLabel = new JLabel("New Username:");
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel.setBounds(157, 125, 189, 14);
        contentPane.add(lblNewLabel);

        JLabel lblPhoneNumber = new JLabel("New Password:");
        lblPhoneNumber.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblPhoneNumber.setBounds(157, 185, 159, 14);
        contentPane.add(lblPhoneNumber);

        name = new JTextField();
        name.setBounds(335, 125, 109, 20);
        contentPane.add(name);
        name.setColumns(10);

        phone = new JPasswordField();
        phone.setBounds(335, 185, 109, 20);
        contentPane.add(phone);
        phone.setColumns(10);

        JButton btnAdd = new JButton("Update");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "Arsal";
                    String pwd = "Arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);

                    String query1 = "SELECT worker_id FROM worker WHERE username='" + (WorkerLogin.login) + "';";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query1);
                    while (resultSet.next()) {
                        worker_id = resultSet.getString(1);
                    }

                    String query = "UPDATE worker SET username=?, password=? WHERE worker_id='" + (worker_id) + "';";

                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, name.getText());
                    pst.setString(2, phone.getText());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Values updated successfully!");
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
        btnAdd.setBounds(71, 290, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                name.setText("");
                phone.setText("");
            }
        });
        btnReset.setBounds(258, 290, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkerMenu field = new WorkerMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(452, 290, 89, 23);
        contentPane.add(button);
    }
}
