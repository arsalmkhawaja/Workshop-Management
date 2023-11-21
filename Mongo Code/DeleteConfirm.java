package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteConfirm extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DeleteConfirm frame = new DeleteConfirm();
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
    public DeleteConfirm() {
        setTitle("DELETE CONFIRM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 377, 275);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblDeleteFrom = new JLabel("Delete From:");
        lblDeleteFrom.setFont(new Font("Poppins", Font.BOLD, 12));
        lblDeleteFrom.setBounds(72, 83, 89, 14);
        contentPane.add(lblDeleteFrom);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminMenu field = new AdminMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(233, 202, 89, 23);
        contentPane.add(button);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Shippers", "Suppliers", "Products", "Reservations", "Workers", "Branches"}));
        comboBox.setBounds(171, 80, 120, 20);
        contentPane.add(comboBox);



        JButton btnNewButton = new JButton("Continue");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String confirmation=comboBox.getSelectedItem().toString();
                if(confirmation.equals("Suppliers")) {
                    DeleteSuppliers field1 = new DeleteSuppliers();
                    field1.setVisible(true);
                    setVisible(false);
                }else if(confirmation.equals("Shippers")) {
                    DeleteShippers field2 = new DeleteShippers();
                    field2.setVisible(true);
                    setVisible(false);
                }else if (confirmation.equals("Branches")) {
                    DeleteBranches field3 = new DeleteBranches();
                    field3.setVisible(true);
                    setVisible(false);
                }else if (confirmation.equals("Workers")) {
                    DeleteWorkers field4 = new DeleteWorkers();
                    field4.setVisible(true);
                    setVisible(false);
                }else if (confirmation.equals("Products")) {
                    DeleteProducts field5 = new DeleteProducts();
                    field5.setVisible(true);
                    setVisible(false);
                }else if (confirmation.equals("Reservations")) {
                    DeleteReservations field6 = new DeleteReservations();
                    field6.setVisible(true);
                    setVisible(false);
                }
            }
        });
        btnNewButton.setBounds(53, 202, 89, 23);
        contentPane.add(btnNewButton);
    }
}

