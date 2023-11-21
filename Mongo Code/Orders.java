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

public class Orders  extends JFrame {

    private JPanel contentPane;
    private JTextField name;
    static String pName;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Orders  frame = new Orders ();
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
    public Orders () {
        setTitle("ORDERS ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 625, 270);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblServices  = new JLabel("Orders ");
        lblServices .setFont(new Font("Poppins", Font.BOLD, 18));
        lblServices .setBounds(270, 24, 109, 16);
        contentPane.add(lblServices );

        JLabel lblAddTheSupplier = new JLabel("Search the name of the Product :");
        lblAddTheSupplier.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheSupplier.setBounds(47, 54, 331, 16);
        contentPane.add(lblAddTheSupplier);

        JLabel lblNewLabel = new JLabel("Product name:");
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel.setBounds(157, 100, 109, 14);
        contentPane.add(lblNewLabel);

        name = new JTextField();
        name.setBounds(335, 100, 109, 20);
        contentPane.add(name);
        name.setColumns(10);

        JButton btnAdd = new JButton("Search");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    pName = name.getText();
                    ProductsDisplay field = new ProductsDisplay();
                    field.setVisible(true);
                    setVisible(false);
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

