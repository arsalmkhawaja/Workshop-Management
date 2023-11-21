package com.company;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class DeleteWorkers extends JFrame {

    private JPanel contentPane;
    private JTextField sid;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteWorkers frame = new DeleteWorkers();
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
    public DeleteWorkers() {
        setTitle("DELETE WORKERS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 671, 296);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblDeleteFromSuppliers = new JLabel("DELETE FROM WORKERS");
        lblDeleteFromSuppliers.setFont(new Font("Poppins", Font.BOLD, 18));
        lblDeleteFromSuppliers.setBounds(199, 11, 257, 16);
        contentPane.add(lblDeleteFromSuppliers);

        JLabel lblEnterTheSupplier = new JLabel("Enter the Worker ID of the worker you want to delete from the worker list");
        lblEnterTheSupplier.setFont(new Font("Poppins", Font.BOLD, 12));
        lblEnterTheSupplier.setBounds(10, 44, 597, 14);
        contentPane.add(lblEnterTheSupplier);

        JLabel lblSupplierId = new JLabel("Worker ID:");
        lblSupplierId.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblSupplierId.setBounds(199, 103, 90, 17);
        contentPane.add(lblSupplierId);

        sid = new JTextField();
        sid.setBounds(338, 103, 118, 20);
        contentPane.add(sid);
        sid.setColumns(10);

        JButton btnNewButton = new JButton("Delete");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    MongoClient client = MongoClients.create("mongodb://127.0.0.1:27017/");
                    MongoDatabase db = client.getDatabase("Workshop");
                    MongoCollection workers = db.getCollection("worker");
                    Document sampleDoc = new Document("worker_id",Integer.parseInt(sid.getText()));
                    workers.deleteOne(sampleDoc);
                    JOptionPane.showMessageDialog(null, "ID: " + (sid.getText()) +" Deleted from the worker list!");
                    int choose=0;
                    if(choose == JOptionPane.OK_OPTION)
                    {
                        DeleteConfirm field = new DeleteConfirm();
                        field.setVisible(true);
                        setVisible(false);
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnNewButton.setBounds(43, 203, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Reset");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sid.setText("");
            }
        });
        btnNewButton_1.setBounds(283, 203, 89, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("<Back");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteConfirm field = new DeleteConfirm();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton_2.setBounds(518, 203, 89, 23);
        contentPane.add(btnNewButton_2);
    }
}
