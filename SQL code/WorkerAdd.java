package com.company;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WorkerAdd extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WorkerAdd frame = new WorkerAdd();
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
    public WorkerAdd() {
        setTitle("ADD CONFIRMATION");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 310);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblAddConfirmation = new JLabel("ADD CONFIRMATION");
        lblAddConfirmation.setFont(new Font("Poppins", Font.BOLD, 18));
        lblAddConfirmation.setBounds(118, 17, 218, 16);
        contentPane.add(lblAddConfirmation);

        JButton btnWorkDetails = new JButton("Work Details");
        btnWorkDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkDetails field = new WorkDetails();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnWorkDetails.setBounds(152, 90, 129, 23);
        contentPane.add(btnWorkDetails);

        JButton btnCustomers = new JButton("Customers");
        btnCustomers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Customers field = new Customers();
                field.setVisible(true);
                setVisible(false);
            }
        });
        btnCustomers.setBounds(152, 150, 129, 23);
        contentPane.add(btnCustomers);

        JButton buttonBack  = new JButton("<Back");
        buttonBack .addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                WorkerMenu field = new WorkerMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        buttonBack.setBounds(323, 230, 89, 23);
        contentPane.add(buttonBack );
    }
}
