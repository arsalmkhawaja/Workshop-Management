package com.company;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class UpdateShippersForm extends JFrame {

    private JPanel contentPane;
    private JTextField name;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateShippersForm frame = new UpdateShippersForm();
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
    public UpdateShippersForm() {
        setTitle("SHIPPERS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 628, 280);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblShippers = new JLabel("UPDATE SHIPPERS");
        lblShippers.setFont(new Font("Poppins", Font.BOLD, 18));
        lblShippers.setBounds(250, 25, 110, 19);
        contentPane.add(lblShippers);

        JLabel lblAddTheDetails = new JLabel("Update the details of the shipper:");
        lblAddTheDetails.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheDetails.setBounds(56, 64, 224, 14);
        contentPane.add(lblAddTheDetails);

        JLabel lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(159, 110, 115, 14);
        contentPane.add(lblNewLabel_1);

        JButton btnAdd = new JButton("Update");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "arsal";
                    String pwd = "arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);

                    String query="UPDATE shippers SET name=? WHERE shipper_id='"+(UpdateShippers.p_id)+"';";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, name.getText());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Values updated successfully with ID");
                    int choose = 0;
                    if(choose==JOptionPane.OK_OPTION)
                    {
                        AdminMenu field = new AdminMenu();
                        field.setVisible(true);
                        setVisible(false);
                    }
                    connection.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnAdd.setBounds(56, 180, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name.setText("");
            }
        });
        btnReset.setBounds(251, 180, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminMenu field = new AdminMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(459, 180, 89, 23);
        contentPane.add(button);

        name = new JTextField();
        name.setBounds(332, 110, 103, 20);
        contentPane.add(name);
        name.setColumns(10);
    }

}
