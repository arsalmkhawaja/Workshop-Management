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

public class UpdateSuppliersForm extends JFrame {

    private JPanel contentPane;
    private JTextField sid;
    private JTextField name;
    private JTextField phone;
    private JTextField city;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateSuppliersForm frame = new UpdateSuppliersForm();
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
    public UpdateSuppliersForm() {
        setTitle("SUPPLIERS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 625, 380);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblSuppliers = new JLabel("UPDATE SUPPLIERS");
        lblSuppliers.setFont(new Font("Poppins", Font.BOLD, 18));
        lblSuppliers.setBounds(250, 24, 189, 16);
        contentPane.add(lblSuppliers);

        JLabel lblAddTheSupplier = new JLabel("Update the details of the supplier:");
        lblAddTheSupplier.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheSupplier.setBounds(47, 54, 331, 16);
        contentPane.add(lblAddTheSupplier);

        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel.setBounds(157, 95, 98, 14);
        contentPane.add(lblNewLabel);

        JLabel lblPhoneNumber = new JLabel("Phone number:");
        lblPhoneNumber.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblPhoneNumber.setBounds(157, 155, 109, 14);
        contentPane.add(lblPhoneNumber);

        JLabel lblCity = new JLabel("City:");
        lblCity.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblCity.setBounds(157, 215, 84, 17);
        contentPane.add(lblCity);

        name = new JTextField();
        name.setBounds(335, 95, 109, 20);
        contentPane.add(name);
        name.setColumns(10);

        phone = new JTextField();
        phone.setBounds(335, 155, 109, 20);
        contentPane.add(phone);
        phone.setColumns(10);

        city = new JTextField();
        city.setBounds(335, 215, 109, 20);
        contentPane.add(city);
        city.setColumns(10);

        JButton btnAdd = new JButton("Update");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "arsal";
                    String pwd = "arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);

                    String query="UPDATE suppliers SET name=?, city=?, phone_number=? WHERE supplier_id='"+(UpdateSuppliers.p_id)+"';";

                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, name.getText());
                    pst.setString(2, phone.getText());
                    pst.setString(3, city.getText());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Values updated successfully!");
                    int choose=0;
                    if(choose==JOptionPane.OK_OPTION)
                    {
                        AdminMenu field = new AdminMenu();
                        field.setVisible(true);
                        setVisible(false);
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnAdd.setBounds(71, 290, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                name.setText("");
                phone.setText("");
                city.setText("");
            }
        });
        btnReset.setBounds(258, 290, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminMenu field = new AdminMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(452, 290, 89, 23);
        contentPane.add(button);
    }
}

