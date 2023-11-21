package com.company;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

    private JPanel contentPane;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
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
    public Menu() {
        setTitle("MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 549, 468);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblMenu = new JLabel("WELCOME TO DREAM WORKSHOP");
        lblMenu.setFont(new Font("Poppins", Font.BOLD, 20));
        lblMenu.setBounds(100, 29, 400, 24);
        contentPane.add(lblMenu);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setForeground(Color.WHITE);
        panel.setBounds(10, 81, 516, 287);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblLog = new JLabel("LOG IN AS");
        lblLog.setFont(new Font("Poppins", Font.BOLD, 14));
        lblLog.setBounds(34, 9, 80, 14);
        panel.add(lblLog);

        JButton btnAdmin = new JButton("Admin");
        btnAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminLogin field = new AdminLogin();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnAdmin.setBounds(190, 55, 130, 30);
        panel.add(btnAdmin);

        JButton btnWorker = new JButton("Worker");
        btnWorker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkerLogin field = new WorkerLogin();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnWorker.setBounds(190, 130, 130, 30);
        panel.add(btnWorker);

        JButton btnCustomer = new JButton("Customer");
        btnCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CustomerLogin field = new CustomerLogin();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnCustomer.setBounds(190, 205, 130, 30);
        panel.add(btnCustomer);

    }
}