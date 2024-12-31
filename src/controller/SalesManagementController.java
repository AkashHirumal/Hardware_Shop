/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import hardwareshop.db.DBConnection;
import java.net.IDN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Customer;
import model.Item;
import model.Sale;

/**
 *
 * @author Akash
 */
public class SalesManagementController {

    public static ArrayList<Sale> getAllSales() throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select * from sales");
        ArrayList<Sale> saleList = new ArrayList<>();
        while (res.next()) {
            Sale sale = new Sale(res.getInt("saleId"), res.getInt("itemID"), res.getInt("customerId"), res.getInt("quantity"), res.getDouble("totalPrice"));
            saleList.add(sale);
        }
        return saleList;
    }

    public static boolean insertItem(Sale sale) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement("INSERT INTO sales(itemId, customerId, quantity, totalPrice) VALUES(?,?,?,?)");
            stm.setObject(1, sale.getItemId());
            stm.setObject(2, sale.getCustomerId());
            stm.setObject(3, sale.getQty());
            stm.setObject(4, sale.getTotalPrice());
            boolean isAddedOrder = stm.executeUpdate() > 0;
            if (isAddedOrder) {
                boolean isUpdateItemQty = InventoryManagementController.updateInventory(sale.getItemId(), sale.getQty());
                if (isUpdateItemQty) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }

    }

    public static ArrayList<Double> getTotalByDates(String startDate, String endDate) throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("SELECT totalPrice FROM sales WHERE saleDate BETWEEN '"+startDate+" 00:00:00' AND '"+endDate+" 00:00:00';");
        ArrayList<Double> totalList = new ArrayList<>();
        while (res.next()) {
            totalList.add(res.getDouble("totalPrice"));
        }
        return totalList;
            
    }

}
