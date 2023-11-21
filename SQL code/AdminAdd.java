package com.company;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAdd extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminAdd frame = new AdminAdd();
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
    public AdminAdd() {
        setTitle("ADD CONFIRMATION");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 393);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblAddConfirmation = new JLabel("ADD CONFIRMATION");
        lblAddConfirmation.setFont(new Font("Poppins", Font.BOLD, 18));
        lblAddConfirmation.setBounds(118, 17, 218, 16);
        contentPane.add(lblAddConfirmation);

        JButton btnSuppliers = new JButton("Suppliers");
        btnSuppliers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Suppliers field= new Suppliers();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnSuppliers.setBounds(92, 90, 89, 23);
        contentPane.add(btnSuppliers);

        JButton btnProducts = new JButton("Products");
        btnProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Products field= new Products();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnProducts.setBounds(92, 150, 89, 23);
        contentPane.add(btnProducts);

        JButton btnWorkers = new JButton("Workers");
        btnWorkers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Workers field= new Workers();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnWorkers.setBounds(252, 90, 89, 23);
        contentPane.add(btnWorkers);

        JButton btnShippers = new JButton("Shippers");
        btnShippers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Shippers field = new Shippers();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnShippers.setBounds(252, 150, 89, 23);
        contentPane.add(btnShippers);

        JButton btnServices = new JButton("Services");
        btnServices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Services field= new Services();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnServices.setBounds(92, 210, 89, 23);
        contentPane.add(btnServices);

        JButton btnBranches = new JButton("Branches");
        btnBranches.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Branches field = new Branches();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnBranches.setBounds(252, 210, 89, 23);
        contentPane.add(btnBranches);

        JButton buttonBack  = new JButton("<Back");
        buttonBack .addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                AdminMenu field = new AdminMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        buttonBack .setBounds(323, 320, 89, 23);
        contentPane.add(buttonBack );
    }
}
