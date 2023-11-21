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
import java.awt.event.ActionEvent;
import java.util.Random;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Branches extends JFrame {

    private JPanel contentPane;
    private JTextField phoneNumber;
    private JTextField city;
    private JTextField location;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Branches frame = new Branches();
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
    public Branches() {
        setTitle("Branches");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 625, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblBranches = new JLabel("Branches");
        lblBranches.setFont(new Font("Poppins", Font.BOLD, 18));
        lblBranches.setBounds(250, 24, 109, 16);
        contentPane.add(lblBranches);

        JLabel lblAddTheSupplier = new JLabel("Add the details of the branches:");
        lblAddTheSupplier.setFont(new Font("Poppins", Font.BOLD, 12));
        lblAddTheSupplier.setBounds(47, 54, 331, 16);
        contentPane.add(lblAddTheSupplier);

        JLabel lblNewLabel = new JLabel("Location:");
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel.setBounds(157, 95, 98, 14);
        contentPane.add(lblNewLabel);

        JLabel lblPhoneNumber = new JLabel("Phone number:");
        lblPhoneNumber.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblPhoneNumber.setBounds(157, 155, 109, 14);
        contentPane.add(lblPhoneNumber);

        JLabel lblCity = new JLabel("City:");
        lblCity.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblCity.setBounds(157, 215, 84, 17);
        contentPane.add(lblCity);

        location = new JTextField();
        location.setBounds(335, 95, 109, 20);
        contentPane.add(location);
        location.setColumns(10);

        phoneNumber = new JTextField();
        phoneNumber.setBounds(335, 155, 109, 20);
        contentPane.add(phoneNumber);
        phoneNumber.setColumns(10);

        city = new JTextField();
        city.setBounds(335, 215, 109, 20);
        contentPane.add(city);
        city.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MongoClient client = MongoClients.create("mongodb://127.0.0.1:27017/");
                    MongoDatabase db = client.getDatabase("Workshop");
                    MongoCollection bran = db.getCollection("branch");
                    Random r =new Random();
                    int id=r.nextInt(10);
                    Document sampleDoc = new Document("branch_id",id ).append("location", location.getText());
                    sampleDoc.append("city",city.getText());
                    sampleDoc.append("phone_number",phoneNumber.getText());
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
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnAdd.setBounds(71, 280, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                phoneNumber.setText("");
                city.setText("");
                location.setText("");
            }
        });
        btnReset.setBounds(258, 280, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminAdd field = new AdminAdd();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(452, 280, 89, 23);
        contentPane.add(button);
    }
}

