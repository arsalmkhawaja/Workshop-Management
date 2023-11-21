package com.company;

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

public class DeleteShippers extends JFrame {

    private JPanel contentPane;
    private JTextField sid;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteShippers frame = new DeleteShippers();
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
    public DeleteShippers() {
        setTitle("DELETE SHIPPERS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 671, 296);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblDeleteFromSuppliers = new JLabel("DELETE FROM SHIPPERS");
        lblDeleteFromSuppliers.setFont(new Font("Poppins", Font.BOLD, 18));
        lblDeleteFromSuppliers.setBounds(199, 11, 257, 16);
        contentPane.add(lblDeleteFromSuppliers);

        JLabel lblEnterTheSupplier = new JLabel(
                "Enter the shipper ID of the shipper you want to delete from the shipper list");
        lblEnterTheSupplier.setFont(new Font("Poppins", Font.BOLD, 12));
        lblEnterTheSupplier.setBounds(10, 44, 597, 14);
        contentPane.add(lblEnterTheSupplier);

        JLabel lblSupplierId = new JLabel("Shipper ID:");
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
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "Arsal";
                    String pwd = "Arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);
                    String sql = "DELETE FROM Shippers WHERE shipper_id='" + (sid.getText() + "';");
                    PreparedStatement pst = connection.prepareStatement(sql);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "ID: " + (sid.getText()) + " Deleted from the Shipper list!");
                    int choose = 0;
                    if (choose == JOptionPane.OK_OPTION) {
                        DeleteConfirm field = new DeleteConfirm();
                        field.setVisible(true);
                        setVisible(false);
                    }
                    connection.close();
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
