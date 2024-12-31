/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import hardwareshop.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Customer;
import model.Item;

/**
 *
 * @author Akash
 */
public class CustomerManagementController {

    public static ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select * from customers");
        ArrayList<Customer> itemsList = new ArrayList<>();
        while (res.next()) {
            Customer customer = new Customer(res.getInt("customerID"), res.getString("name"), res.getString("contactInfo"));
            itemsList.add(customer);
        }
        return itemsList;
    }

    public static Customer searchByName(String name) throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select * from customers where name='" + name + "'");
        if (res.next()) {
            Customer customer = new Customer(res.getInt("customerID"), res.getString("name"), res.getString("contactInfo"));
            return customer;
        }
        return null;
    }

    public static boolean insertItem(Customer customer) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO customers(name, contactInfo) VALUES(?,?)");
        stm.setObject(1, customer.getName());
        stm.setObject(2, customer.getContactInfo());
        return stm.executeUpdate() > 0;
    }

    public static boolean updateItem(Customer customer) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE customers SET contactInfo=? WHERE name=?");
        stm.setObject(1, customer.getContactInfo());
        stm.setObject(2, customer.getName());
        return stm.executeUpdate() > 0;
    }

    public static boolean deleteItem(String name) throws ClassNotFoundException, SQLException {
        int res = DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM customers WHERE name='" + name + "'");
        return res > 0;
    }

    public static String getNameById(int id) throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select name from customers where customerID='" + id + "'");
        res.next();
        String customer = res.getString("name");
        return customer;
    }
}
