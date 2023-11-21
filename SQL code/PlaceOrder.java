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

public class PlaceOrder extends JFrame {

    private JPanel contentPane;
    private JTextField quantity;
    private JTextField name;
    static String pQuantity;
    static String pPrice;
    static String customerId;
    static String date;
    static int id;
    static String pId;
    static int amount;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PlaceOrder frame = new PlaceOrder();
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
    public PlaceOrder() {
        setTitle("PLACE ORDER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 628, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblProducts = new JLabel("PLACE ORDER");
        lblProducts.setFont(new Font("Poppins", Font.BOLD, 18));
        lblProducts.setBounds(220, 25, 130, 17);
        contentPane.add(lblProducts);

        JLabel lblAddTheDetails = new JLabel("Add the details of the product:");
        lblAddTheDetails.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheDetails.setBounds(56, 64, 224, 14);
        contentPane.add(lblAddTheDetails);

        JLabel lblNewLabel_1 = new JLabel("Product ID:");
        lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(159, 105, 115, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Quantity:");
        lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(159, 162, 80, 17);
        contentPane.add(lblNewLabel_2);

        JButton btnAdd = new JButton("Place");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "Arsal";
                    String pwd = "Arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);

                    pId = (name.getText());
                    String query2 = "SELECT product_quantity, product_price FROM products WHERE product_id='"
                            + (name.getText()) + "';";
                    Statement statement2 = connection.createStatement();
                    ResultSet resultSet2 = statement2.executeQuery(query2);
                    while (resultSet2.next()) {
                        pQuantity = resultSet2.getString(1);
                        pPrice = resultSet2.getString(2);
                    }

                    int uQuantity = Integer.parseInt(quantity.getText());
                    int dbQuantity = Integer.parseInt(pQuantity);
                    int price = Integer.parseInt(pPrice);
                    amount = uQuantity * price;
                    if (uQuantity < dbQuantity) {
                        String query3 = "SELECT customer_id FROM customer WHERE username='" + (CustomerLogin.login)
                                + "';";
                        Statement statement3 = connection.createStatement();
                        ResultSet resultSet3 = statement3.executeQuery(query3);
                        while (resultSet3.next()) {
                            customerId = resultSet3.getString(1);
                        }

                        String query4 = "SELECT CURDATE();";
                        Statement statement4 = connection.createStatement();
                        ResultSet resultSet4 = statement4.executeQuery(query4);
                        while (resultSet4.next()) {
                            date = resultSet4.getString(1);
                        }

                        String query = "INSERT INTO orders(customer_id, order_date) VALUES (?, ?)";
                        PreparedStatement pst = connection.prepareStatement(query);
                        pst.setString(1, customerId);
                        pst.setString(2, date);
                        pst.executeUpdate();

                        String query1 = "SELECT LAST_INSERT_ID()";
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(query1);
                        id = 0;
                        while (resultSet.next()) {
                            id = resultSet.getInt(1);
                        }

                        String query5 = "INSERT INTO order_items(product_id, order_id, quantity) VALUES (?, ?, ?)";
                        PreparedStatement pst5 = connection.prepareStatement(query5);
                        pst5.setString(1, name.getText());
                        pst5.setString(2, String.valueOf(id));
                        pst5.setString(3, String.valueOf(uQuantity));
                        pst5.executeUpdate();

                        dbQuantity = dbQuantity - uQuantity;
                        String query6 = "UPDATE products SET product_quantity=? WHERE product_id ='" + (pId) + "';";
                        PreparedStatement pst6 = connection.prepareStatement(query6);
                        pst6.setString(1, String.valueOf(dbQuantity));
                        pst6.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Order Placed successfully");
                        int choose = 0;
                        if (choose == JOptionPane.OK_OPTION) {
                            Payment field = new Payment();
                            field.setVisible(true);
                            setVisible(false);
                        }
                        connection.close();
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2);
                }
            }
        });
        btnAdd.setBounds(56, 250, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                quantity.setText("");
            }
        });
        btnReset.setBounds(251, 250, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CustomerMenu field = new CustomerMenu();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(459, 250, 89, 23);
        contentPane.add(button);

        quantity = new JTextField();
        quantity.setBounds(332, 160, 103, 20);
        contentPane.add(quantity);
        quantity.setColumns(10);

        name = new JTextField();
        name.setBounds(332, 103, 103, 20);
        contentPane.add(name);
        name.setColumns(10);
    }

}
