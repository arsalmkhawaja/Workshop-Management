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

public class UpdateShippers extends JFrame {

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
                    UpdateShippers frame = new UpdateShippers();
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
    public UpdateShippers() {
        setTitle("UPDATE SHIPPERS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 588, 297);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("UPDATE SHIPPERS");
        lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 18));
        lblNewLabel.setBounds(188, 11, 196, 16);
        contentPane.add(lblNewLabel);

        JLabel lblEnterShippersId = new JLabel("Enter Shipper's ID you want to update");
        lblEnterShippersId.setFont(new Font("Poppins", Font.BOLD, 12));
        lblEnterShippersId.setBounds(46, 49, 401, 14);
        contentPane.add(lblEnterShippersId);

        JLabel lblShippersId = new JLabel("Shipper's ID:");
        lblShippersId.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblShippersId.setBounds(155, 120, 90, 14);
        contentPane.add(lblShippersId);

        pid = new JTextField();
        pid.setBounds(298, 119, 110, 20);
        contentPane.add(pid);
        pid.setColumns(10);

        JButton btnNewButton = new JButton("Update");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                p_id = pid.getText();
                UpdateShippersForm field = new UpdateShippersForm();
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
                AdminMenu field = new AdminMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton_2.setBounds(420, 202, 89, 23);
        contentPane.add(btnNewButton_2);
    }
}

