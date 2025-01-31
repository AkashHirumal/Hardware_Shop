/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hardwareshop.db;

import java.sql.*;

/**
 *
 * @author Akash
 */
public class DBConnection {
    private static DBConnection dBconnection;
    private Connection connection;
    
    private DBConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/hardware_shop", "root", "12345678");   
        
    }
    
    public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
        if(dBconnection==null){
            dBconnection = new DBConnection();
        }
        return dBconnection;
    }
    
    public Connection getConnection(){
        return connection;
    }
}
