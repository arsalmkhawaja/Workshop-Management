package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class CustomerLogin extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JPasswordField password;
    static String login = "";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerLogin frame = new CustomerLogin();
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
    public CustomerLogin() {
        setTitle("CUSTOMER LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 487, 399);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblStockManagementSystem = new JLabel("DREAM WORKSHOP");
        lblStockManagementSystem.setFont(new Font("Poppins", Font.BOLD, 18));
        lblStockManagementSystem.setBounds(147, 20, 300, 34);
        contentPane.add(lblStockManagementSystem);

        JLabel lblLogin = new JLabel("CUSTOMER LOGIN");
        lblLogin.setFont(new Font("Poppins", Font.BOLD, 14));
        lblLogin.setBounds(170, 56, 146, 14);
        contentPane.add(lblLogin);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblUsername.setBounds(115, 115, 75, 14);
        contentPane.add(lblUsername);

        JLabel lblNewLabel = new JLabel("Password:");
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel.setBounds(115, 183, 75, 14);
        contentPane.add(lblNewLabel);

        username = new JTextField();
        username.setBounds(230, 114, 104, 20);
        contentPane.add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setBounds(230, 182, 104, 20);
        contentPane.add(password);

        JButton btnNewButton = new JButton("Sign In");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "Arsal";
                    String pwd = "Arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);
                    String sql = "SELECT username, password FROM customer where username=? and password=?";
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.setString(1, username.getText());
                    pst.setString(2, password.getText());
                    login = username.getText();
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successful!");
                        CustomerMenu field = new CustomerMenu();
                        field.setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username or Password not correct!", "ERROR",
                                JOptionPane.ERROR_MESSAGE);
                        username.setText("");
                        password.setText("");
                    }
                    connection.close();
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnNewButton.setBounds(312, 278, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                password.setText("");
            }
        });
        btnReset.setBounds(190, 278, 89, 23);
        contentPane.add(btnReset);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu field = new Menu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnBack.setBounds(68, 278, 89, 23);
        contentPane.add(btnBack);
    }
}
