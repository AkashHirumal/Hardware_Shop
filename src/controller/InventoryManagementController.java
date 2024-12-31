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
import model.Item;

/**
 *
 * @author Akash
 */
public class InventoryManagementController {

    public static Item searchByName(String name) throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select * from items where name='" + name + "'");
        if (res.next()) {
            Item item = new Item(res.getInt("itemID"), res.getString("name"), res.getString("Description"), res.getInt("Quantity"), res.getDouble("price"));
            return item;
        }
        return null;
    }

    public static ArrayList<Item> getAllItems() throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select * from items");
        ArrayList<Item> itemsList = new ArrayList<>();
        while (res.next()) {
            Item item = new Item(res.getInt("itemID"), res.getString("name"), res.getString("Description"), res.getInt("Quantity"), res.getDouble("price"));
            itemsList.add(item);
        }
        return itemsList;
    }

    public static boolean insertItem(Item item) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO items(name, Description, Quantity, price) VALUES(?,?,?,?)");
        stm.setObject(1, item.getItemName());
        stm.setObject(2, item.getItemDesc());
        stm.setObject(3, item.getItemQty());
        stm.setObject(4, item.getItemPrice());
        return stm.executeUpdate() > 0;
    }

    public static boolean updateItem(Item item) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE items SET Description=?, Quantity=?, price=? WHERE name=?");
        stm.setObject(1, item.getItemDesc());
        stm.setObject(2, item.getItemQty());
        stm.setObject(3, item.getItemPrice());
        stm.setObject(4, item.getItemName());
        return stm.executeUpdate() > 0;
    }

    public static boolean deleteItem(String name) throws ClassNotFoundException, SQLException {
        int res = DBConnection.getInstance().getConnection().createStatement().executeUpdate("DELETE FROM items WHERE name='" + name + "'");
        return res > 0;
    }

    public static Double getUnitPriceById(int itemId) throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select price from items where itemID='" + itemId + "'");
        res.next();
        Double itemUnitPrice = res.getDouble("price");
        return itemUnitPrice;
    }

    public static String getNameById(int itemId) throws ClassNotFoundException, SQLException {
        ResultSet res = DBConnection.getInstance().getConnection().createStatement().executeQuery("select name from items where itemID='" + itemId + "'");
        res.next();
        String itemName = res.getString("name");
        return itemName;
    }

    static boolean updateInventory(int itemId, int qty) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("UPDATE items SET Quantity=Quantity-? WHERE itemId=?");
        stm.setObject(1, qty);
        stm.setObject(2, itemId);
        return stm.executeUpdate() > 0;
    }

}
