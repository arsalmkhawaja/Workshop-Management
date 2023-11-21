package com.company;
import com.mongodb.client.*;
import org.bson.*;

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
import javax.xml.crypto.Data;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JPasswordField password;
    static String login="";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminLogin frame = new AdminLogin();
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
    public AdminLogin() {
        setTitle("ADMIN LOGIN");
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

        JLabel lblLogin = new JLabel("ADMIN LOGIN");
        lblLogin.setFont(new Font("Poppins", Font.BOLD, 14));
        lblLogin.setBounds(187, 56, 106, 14);
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
                    MongoClient client = MongoClients.create("mongodb://127.0.0.1:27017/");

                    MongoDatabase db = client.getDatabase("Workshop");

                    MongoCollection<Document> adm = db.getCollection("admin");

                    FindIterable<Document> iterable = adm.find();

                    MongoCursor<Document> cursor = iterable.iterator();
                    while (cursor.hasNext()) {
                        Document doc = cursor.next();
                        if(doc.getString("username").equals(username.getText()) & doc.getString("password").equals(password.getText())){
                            JOptionPane.showMessageDialog(null, "Login Successful!");
                            AdminMenu field = new AdminMenu();
                            field.setVisible(true);
                            setVisible(false);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Username or Password not correct!", "ERROR", JOptionPane.ERROR_MESSAGE);
                            username.setText("");
                            password.setText("");
                        }
                    }
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

