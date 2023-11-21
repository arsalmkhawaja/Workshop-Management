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

public class Products extends JFrame {

    private JPanel contentPane;
    private JTextField quantity;
    private JTextField price;
    private JTextField sid;
    private JTextField name;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Products frame = new Products();
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
    public Products() {
        setTitle("PRODUCTS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 628, 460);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setResizable(false);

        JLabel lblProducts = new JLabel("PRODUCTS");
        lblProducts.setFont(new Font("Poppins", Font.BOLD, 18));
        lblProducts.setBounds(250, 25, 110, 17);
        contentPane.add(lblProducts);

        JLabel lblAddTheDetails = new JLabel("Add the details of the product:");
        lblAddTheDetails.setFont(new Font("Poppins", Font.BOLD, 14));
        lblAddTheDetails.setBounds(56, 64, 224, 14);
        contentPane.add(lblAddTheDetails);

        JLabel lblNewLabel_1 = new JLabel("Product name:");
        lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(159, 105, 115, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Quantity:");
        lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(159, 162, 80, 17);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Price:");
        lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(159, 219, 46, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Supplier ID:");
        lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(159, 276, 80, 17);
        contentPane.add(lblNewLabel_4);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = "jdbc:mysql://localhost:3306/workshop";
                    String uname = "arsal";
                    String pwd = "arsal";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(url, uname, pwd);

                    String query="INSERT INTO Products(product_name, product_quantity, product_price, supplier_id) VALUES (?, ?, ?, ?)";
                    PreparedStatement pst=connection.prepareStatement(query);
                    pst.setString(1, name.getText());
                    pst.setString(2, quantity.getText());
                    pst.setString(3, price.getText());
                    pst.setString(4, sid.getText());
                    pst.executeUpdate();

                    String query1 = "SELECT LAST_INSERT_ID()";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query1);
                    int id = 0;
                    while (resultSet.next()){
                        id = resultSet.getInt(1);
                    }

                    JOptionPane.showMessageDialog(null, "Values inserted successfully with ID: " + id);
                    int choose=0;
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
        btnAdd.setBounds(56, 360, 89, 23);
        contentPane.add(btnAdd);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                quantity.setText("");
                price.setText("");
                sid.setText("");
            }
        });
        btnReset.setBounds(251, 360, 89, 23);
        contentPane.add(btnReset);

        JButton button = new JButton("<Back");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AdminAdd field = new AdminAdd();
                field.setVisible(true);
                setVisible(false);
            }
        });
        button.setBounds(459, 360, 89, 23);
        contentPane.add(button);

        quantity = new JTextField();
        quantity.setBounds(332, 160, 103, 20);
        contentPane.add(quantity);
        quantity.setColumns(10);

        price = new JTextField();
        price.setBounds(332, 215, 103, 20);
        contentPane.add(price);
        price.setColumns(10);

        sid = new JTextField();
        sid.setBounds(332, 271, 103, 20);
        contentPane.add(sid);
        sid.setColumns(10);

        name = new JTextField();
        name.setBounds(332, 103, 103, 20);
        contentPane.add(name);
        name.setColumns(10);
    }

}
