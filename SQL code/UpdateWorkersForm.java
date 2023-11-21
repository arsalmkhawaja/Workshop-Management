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

public class UpdateWorkersForm extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JTextField password;
    private JTextField firstName;
    private JTextField lastName;
    private JTextField phoneNumber;
    private JTextField address;
    private JTextField branchId;
    private JTextField salary;
    private JTextField workHours;
    private JTextField managerId;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateWorkersForm frame = new UpdateWorkersForm();
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
    public UpdateWorkersForm() {
        setTitle("UPDATE WORKERS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 460);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblWorkers = new JLabel("UPDATE WORKERS");
        lblWorkers.setFont(new Font("Poppins", Font.BOLD, 18));
        lblWorkers.setBounds(250, 25, 240, 17);
        contentPane.add(lblWorkers);

        JLabel lblAddTheDetails = new JLabel("Update the details of the workers:");
        lblAddTheDetails.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheDetails.setBounds(56, 64, 324, 14);
        contentPane.add(lblAddTheDetails);

        JLabel lblNewLabel_3 = new JLabel("First Name:");
        lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(79, 105, 96, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Last Name:");
        lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(79, 162, 96, 17);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Phone Number:");
        lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(79, 219, 146, 14);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Address:");
        lblNewLabel_6.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(79, 276, 96, 17);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Branch ID:");
        lblNewLabel_7.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_7.setBounds(375, 105, 115, 14);
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Salary:");
        lblNewLabel_8.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_8.setBounds(375, 162, 80, 17);
        contentPane.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Work Hours:");
        lblNewLabel_9.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_9.setBounds(375, 219, 146, 14);
        contentPane.add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("Manager ID:");
        lblNewLabel_10.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_10.setBounds(375, 276, 96, 17);
        contentPane.add(lblNewLabel_10);

        JButton btnAdd = new JButton("Update");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "Arsal";
                    String pwd = "Arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);

                    String query = "UPDATE worker SET first_name=?, last_name=?, phone_number=?, address=?, branch_id=?, salary=?, work_hours=?, manager_id=? WHERE worker_id='"
                            + (UpdateWorkers.p_id) + "';";
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, firstName.getText());
                    pst.setString(2, lastName.getText());
                    pst.setString(3, phoneNumber.getText());
                    pst.setString(4, address.getText());
                    pst.setString(5, branchId.getText());
                    pst.setString(6, salary.getText());
                    pst.setString(7, workHours.getText());
                    pst.setString(8, managerId.getText());
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Values updated successfully with ID!");
                    int choose = 0;
                    if (choose == JOptionPane.OK_OPTION) {
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
        btnAdd.setBounds(96, 350, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                password.setText("");
                firstName.setText("");
                lastName.setText("");
                phoneNumber.setText("");
                address.setText("");
                branchId.setText("");
                salary.setText("");
                workHours.setText("");
                managerId.setText("");
            }
        });
        btnReset.setBounds(291, 350, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminMenu field = new AdminMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(499, 350, 89, 23);
        contentPane.add(button);

        firstName = new JTextField();
        firstName.setBounds(219, 103, 103, 20);
        contentPane.add(firstName);
        firstName.setColumns(10);

        lastName = new JTextField();
        lastName.setBounds(219, 160, 103, 20);
        contentPane.add(lastName);
        lastName.setColumns(10);

        phoneNumber = new JTextField();
        phoneNumber.setBounds(219, 215, 103, 20);
        contentPane.add(phoneNumber);
        phoneNumber.setColumns(10);

        address = new JTextField();
        address.setBounds(219, 271, 103, 20);
        contentPane.add(address);
        address.setColumns(10);

        branchId = new JTextField();
        branchId.setBounds(499, 103, 103, 20);
        contentPane.add(branchId);
        branchId.setColumns(10);

        salary = new JTextField();
        salary.setBounds(499, 160, 103, 20);
        contentPane.add(salary);
        salary.setColumns(10);

        workHours = new JTextField();
        workHours.setBounds(499, 215, 103, 20);
        contentPane.add(workHours);
        workHours.setColumns(10);

        managerId = new JTextField();
        managerId.setBounds(499, 271, 103, 20);
        contentPane.add(managerId);
        managerId.setColumns(10);
    }

}
