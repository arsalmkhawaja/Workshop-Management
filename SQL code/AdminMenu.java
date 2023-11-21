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

public class AdminMenu extends JFrame {

    private JPanel contentPane;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminMenu frame = new AdminMenu();
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
    public AdminMenu() {
        setTitle("MENU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 749, 468);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblMenu = new JLabel("MENU");
        lblMenu.setFont(new Font("Poppins", Font.BOLD, 18));
        lblMenu.setBounds(336, 23, 76, 16);
        contentPane.add(lblMenu);

        JLabel lblWelcome = new JLabel("Welcome:  " + AdminLogin.login);
        lblWelcome.setFont(new Font("Poppins", Font.BOLD, 13));
        lblWelcome.setBounds(42, 56, 159, 14);
        contentPane.add(lblWelcome);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setForeground(Color.WHITE);
        panel.setBounds(10, 81, 714, 287);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblActions = new JLabel("ACTIONS");
        lblActions.setFont(new Font("Poppins", Font.BOLD, 14));
        lblActions.setBounds(89, 9, 80, 14);
        panel.add(lblActions);

        JLabel lblDisplay = new JLabel("DISPLAY TABLES");
        lblDisplay.setFont(new Font("Poppins", Font.BOLD, 14));
        lblDisplay.setBounds(417, 9, 121, 14);
        panel.add(lblDisplay);

        JSeparator separator = new JSeparator();
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(242, 11, 2, 265);
        panel.add(separator);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminAdd field=new AdminAdd();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnAdd.setBounds(62, 58, 121, 23);
        panel.add(btnAdd);

        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchConfirm field = new SearchConfirm();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnSearch.setBounds(62, 105, 121, 23);
        panel.add(btnSearch);

        JButton btnSale = new JButton("Update");
        btnSale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                UpdateConfirm field = new UpdateConfirm();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnSale.setBounds(62, 155, 121, 23);
        panel.add(btnSale);

        JButton btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteConfirm field=new DeleteConfirm();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnDelete.setBounds(62, 209, 121, 23);
        panel.add(btnDelete);

        JButton btnShippers = new JButton("Shippers");
        btnShippers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                ShippersTable field = new ShippersTable();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnShippers.setBounds(317, 58, 121, 23);
        panel.add(btnShippers);

        JButton btnSuppliers = new JButton("Suppliers");
        btnSuppliers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SuppliersTable field = new SuppliersTable();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnSuppliers.setBounds(317, 105, 121, 23);
        panel.add(btnSuppliers);

        JButton btnProducts = new JButton("Products");
        btnProducts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductsTable field = new ProductsTable();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnProducts.setBounds(317, 155, 121, 23);
        panel.add(btnProducts);

        JButton btnWorkers = new JButton("Workers");
        btnWorkers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkersTable field = new WorkersTable();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnWorkers.setBounds(317, 205, 121, 23);
        panel.add(btnWorkers);

        JButton btnCustomers = new JButton("Customers");
        btnCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                CustomersTable field=new CustomersTable();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnCustomers.setBounds(517, 58, 121, 23);
        panel.add(btnCustomers);

        JButton btnReservations = new JButton("Reservations");
        btnReservations.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReservationsTable field = new ReservationsTable();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnReservations.setBounds(517, 105, 121, 23);
        panel.add(btnReservations);

        JButton btnBranches = new JButton("Branches");
        btnBranches.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BranchTable field=new BranchTable();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnBranches.setBounds(517, 155, 121, 23);
        panel.add(btnBranches);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Menu field  = new Menu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnLogout.setBounds(585, 388, 89, 23);
        contentPane.add(btnLogout);
    }
}

