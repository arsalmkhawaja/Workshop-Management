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

public class CustomerMenu extends JFrame {

    private JPanel contentPane;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerMenu frame = new CustomerMenu();
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
    public CustomerMenu() {
        setTitle("MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 349, 468);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblMenu = new JLabel("MENU");
        lblMenu.setFont(new Font("Poppins", Font.BOLD, 18));
        lblMenu.setBounds(139, 23, 76, 16);
        contentPane.add(lblMenu);

        JLabel lblWelcome = new JLabel("Welcome:  " + CustomerLogin.login);
        lblWelcome.setFont(new Font("Poppins", Font.BOLD, 13));
        lblWelcome.setBounds(30, 56, 139, 14);
        contentPane.add(lblWelcome);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setForeground(Color.WHITE);
        panel.setBounds(10, 81, 314, 287);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblActions = new JLabel("ACTIONS");
        lblActions.setFont(new Font("Poppins", Font.BOLD, 14));
        lblActions.setBounds(125, 9, 80, 14);
        panel.add(lblActions);

        JButton btnAdd = new JButton("Reserve a Slot");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reservations field = new Reservations();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnAdd.setBounds(72, 58, 165, 23);
        panel.add(btnAdd);

        JButton btnSearch = new JButton("Place an order");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Orders field = new Orders();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnSearch.setBounds(72, 105, 165, 23);
        panel.add(btnSearch);

        JButton btnSale = new JButton("Feedback");
        btnSale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Feedback field = new Feedback();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnSale.setBounds(72, 155, 161, 23);
        panel.add(btnSale);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Menu field  = new Menu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnLogout.setBounds(215, 388, 89, 23);
        contentPane.add(btnLogout);
    }
}

