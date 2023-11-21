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

public class Services extends JFrame {

    private JPanel contentPane;
    private JTextField name;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Services frame = new Services();
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
    public Services() {
        setTitle("Services ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 625, 270);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblServices = new JLabel("Services ");
        lblServices.setFont(new Font("Poppins", Font.BOLD, 18));
        lblServices.setBounds(250, 24, 109, 16);
        contentPane.add(lblServices);

        JLabel lblAddTheSupplier = new JLabel("Add the details of the Services :");
        lblAddTheSupplier.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheSupplier.setBounds(47, 54, 331, 16);
        contentPane.add(lblAddTheSupplier);

        JLabel lblNewLabel = new JLabel("Service name:");
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel.setBounds(157, 100, 109, 14);
        contentPane.add(lblNewLabel);

        name = new JTextField();
        name.setBounds(335, 100, 109, 20);
        contentPane.add(name);
        name.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "Arsal";
                    String pwd = "Arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);

                    String query = "INSERT INTO Services (service_name) VALUES (?)";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, name.getText());
                    pst.executeUpdate();

                    String query1 = "SELECT LAST_INSERT_ID()";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query1);
                    int id = 0;
                    while (resultSet.next()) {
                        id = resultSet.getInt(1);
                    }

                    JOptionPane.showMessageDialog(null, "Values inserted successfully with ID: " + id);
                    int choose = 0;
                    if (choose == JOptionPane.OK_OPTION) {
                        AdminMenu field = new AdminMenu();
                        field.setVisible(true);
                        setVisible(false);
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnAdd.setBounds(71, 180, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                name.setText("");
            }
        });
        btnReset.setBounds(258, 180, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminAdd field = new AdminAdd();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(452, 180, 89, 23);
        contentPane.add(button);
    }
}
