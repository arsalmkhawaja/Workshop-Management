package com.company;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchSuppliers extends JFrame {

    private JPanel contentPane;
    private JTextField pid;
    static String p_id="";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchSuppliers frame = new SearchSuppliers();
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
    public SearchSuppliers() {
        setTitle("SEARCH SUPPLIERS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 297);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("SEARCH SUPPLIERS");
        lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        lblNewLabel.setBounds(188, 11, 196, 16);
        contentPane.add(lblNewLabel);

        JLabel lblEnterProductId = new JLabel("Enter supplier ID of the supplier you want to search");
        lblEnterProductId.setFont(new Font("Poppins", Font.BOLD, 12));
        lblEnterProductId.setBounds(46, 49, 401, 14);
        contentPane.add(lblEnterProductId);

        JLabel lblProductId = new JLabel("Supplier ID:");
        lblProductId.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblProductId.setBounds(155, 120, 90, 14);
        contentPane.add(lblProductId);

        pid = new JTextField();
        pid.setBounds(298, 119, 110, 20);
        contentPane.add(pid);
        pid.setColumns(10);

        JButton btnNewButton = new JButton("Search");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p_id = pid.getText();
                SearchSuppliersTable field = new SearchSuppliersTable();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton.setBounds(58, 202, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Reset");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                pid.setText("");
            }
        });
        btnNewButton_1.setBounds(238, 202, 89, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("<Back");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchConfirm field = new SearchConfirm();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton_2.setBounds(420, 202, 89, 23);
        contentPane.add(btnNewButton_2);
    }
}

