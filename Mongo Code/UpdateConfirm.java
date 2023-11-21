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

public class UpdateConfirm extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UpdateConfirm frame = new UpdateConfirm();
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
    public UpdateConfirm() {
        setTitle("UPDATE CONFIRM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 377, 275);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblSearchFrom = new JLabel("Update From:");
        lblSearchFrom.setFont(new Font("Poppins", Font.BOLD, 12));
        lblSearchFrom.setBounds(72, 83, 89, 14);
        contentPane.add(lblSearchFrom);

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
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Shippers", "Suppliers", "Products", "Workers"}));
        comboBox.setBounds(171, 80, 120, 20);
        contentPane.add(comboBox);



        JButton btnNewButton = new JButton("Continue");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String confirmation = comboBox.getSelectedItem().toString();
                if(confirmation.equals("Suppliers")) {
                    UpdateSuppliers field1 = new UpdateSuppliers();
                    field1.setVisible(true);
                    setVisible(false);
                }else if(confirmation.equals("Shippers")) {
                    UpdateShippers field2 = new UpdateShippers();
                    field2.setVisible(true);
                    setVisible(false);
                }else if (confirmation.equals("Workers")) {
                    UpdateWorkers field4 = new UpdateWorkers();
                    field4.setVisible(true);
                    setVisible(false);
                }else if (confirmation.equals("Products")) {
                    UpdateProducts field5 = new UpdateProducts();
                    field5.setVisible(true);
                    setVisible(false);
                }
            }
        });
        btnNewButton.setBounds(53, 202, 89, 23);
        contentPane.add(btnNewButton);
    }
}

