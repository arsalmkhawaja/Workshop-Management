package com.company;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

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
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Credit Card", "EasyPaisa"}));
        comboBox.setBounds(150, 80, 150, 20);
        contentPane.add(comboBox);

        JButton btnNewButton = new JButton("Continue");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String confirmation = comboBox.getSelectedItem().toString();
                if (confirmation.equals("Credit Card")) {
                    choice = 1;
                } else if (confirmation.equals("EasyPaisa")) {
                    choice = 2;
                }
                try {
                    MongoClient client = MongoClients.create("mongodb://127.0.0.1:27017/");
                    MongoDatabase db = client.getDatabase("Workshop");
                    MongoCollection pay = db.getCollection("payments");
                    Random r =new Random();
                    int id=r.nextInt(100);
                    Document sampleDoc = new Document("payment_id",id ).append("customer_id", PlaceOrder.customerId);
                    sampleDoc.append("order_id",PlaceOrder.id);
                    sampleDoc.append("payment_date",PlaceOrder.date);
                    sampleDoc.append("payment_amount",PlaceOrder.amount);
                    sampleDoc.append("payment_method_id",choice);
                    pay.insertOne(sampleDoc);
                    JOptionPane.showMessageDialog(null, "Payment done successfully");
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
        btnNewButton.setBounds(53, 202, 89, 23);
        contentPane.add(btnNewButton);
    }
    }


