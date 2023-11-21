package com.company;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchShippersTable extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchShippersTable frame = new SearchShippersTable();
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
    public SearchShippersTable() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 562, 248);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 526, 146);
        contentPane.add(scrollPane);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchConfirm field = new SearchConfirm();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(392, 175, 89, 23);
        contentPane.add(button);

        JTable table = new JTable();
        scrollPane.setViewportView(table);
        try {
            String url = "jdbc:mysql://localhost:3306/workshop";
            String uname = "arsal";
            String pwd = "arsal";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, uname, pwd);
            String query = "SELECT * FROM Shippers WHERE shipper_id='"+(SearchShippers.p_id)+"';";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, e2);
        }
    }
}

