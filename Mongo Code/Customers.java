package com.company;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.util.Random;

public class Customers extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JTextField password;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField phoneNumber;
    private JTextField address;
    static String branchId;
    private JTextField points;
    private JTextField carNumber;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Customers frame = new Customers();
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
    public Customers() {
        setTitle("CUSTOMERS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblCustomers = new JLabel("CUSTOMERS");
        lblCustomers.setFont(new Font("Poppins", Font.BOLD, 18));
        lblCustomers.setBounds(280, 25, 140, 17);
        contentPane.add(lblCustomers);

        JLabel lblAddTheDetails = new JLabel("Add the details of the Customers:");
        lblAddTheDetails.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheDetails.setBounds(56, 64, 284, 14);
        contentPane.add(lblAddTheDetails);

        JLabel lblNewLabel_1 = new JLabel("Username:");
        lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(79, 105, 96, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Password:");
        lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(79, 162, 96, 17);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("First Name:");
        lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(79, 219, 96, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Last Name:");
        lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(79, 276, 96, 17);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Phone Number:");
        lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(375, 105, 126, 17);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Address:");
        lblNewLabel_6.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(375, 162, 115, 14);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Car Number:");
        lblNewLabel_7.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_7.setBounds(375, 219, 120, 17);
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Points:");
        lblNewLabel_8.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_8.setBounds(375, 276, 46, 14);
        contentPane.add(lblNewLabel_8);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MongoClient client = MongoClients.create("mongodb://127.0.0.1:27017/");
                    MongoDatabase db = client.getDatabase("Workshop");
                    MongoCollection bran = db.getCollection("customer");
                    Random r =new Random();
                    int id=r.nextInt(100);
                    Document sampleDoc = new Document("customer_id",id ).append("username", username.getText());
                    sampleDoc.append("password",password.getText());
                    sampleDoc.append("first_name",firstName.getText());
                    sampleDoc.append("last_name",lastName.getText());
                    sampleDoc.append("phone_number",phoneNumber.getText());
                    sampleDoc.append("address",address.getText());
                    sampleDoc.append("car_number",carNumber.getText());
                    sampleDoc.append("points",points.getText());
                    bran.insertOne(sampleDoc);
                    JOptionPane.showMessageDialog(null, "Values inserted successfully with ID: " + id);
                    int choose=0;
                    if(choose==JOptionPane.OK_OPTION)
                    {
                        AdminMenu field = new AdminMenu();
                        field.setVisible(true);
                        setVisible(false);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnAdd.setBounds(499, 360, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                password.setText("");
                firstName.setText("");
                lastName.setText("");
                phoneNumber.setText("");
                address.setText("");
                carNumber.setText("");
                points.setText("");
            }
        });
        btnReset.setBounds(291, 360, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkerAdd field = new WorkerAdd();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(96, 360, 89, 23);
        contentPane.add(button);

        username = new JTextField();
        username.setBounds(219, 103, 103, 20);
        contentPane.add(username);
        username.setColumns(10);

        password = new JTextField();
        password.setBounds(219, 160, 103, 20);
        contentPane.add(password);
        password.setColumns(10);

        firstName = new JTextField();
        firstName.setBounds(219, 215, 103, 20);
        contentPane.add(firstName);
        firstName.setColumns(10);

        lastName = new JTextField();
        lastName.setBounds(219, 271, 103, 20);
        contentPane.add(lastName);
        lastName.setColumns(10);

        phoneNumber = new JTextField();
        phoneNumber.setBounds(499, 103, 103, 20);
        contentPane.add(phoneNumber);
        phoneNumber.setColumns(10);

        address = new JTextField();
        address.setBounds(499, 160, 103, 20);
        contentPane.add(address);
        address.setColumns(10);

        carNumber = new JTextField();
        carNumber.setBounds(499, 215, 103, 20);
        contentPane.add(carNumber);
        carNumber.setColumns(10);

        points = new JTextField();
        points.setBounds(499, 271, 103, 20);
        contentPane.add(points);
        points.setColumns(10);
    }

}
