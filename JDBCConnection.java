/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class JDBCConnection {
    public static Connection getJDBCConnection() {
        try {
            Class.forName("com.mysql://localhost:3306/BAN_HANG");
            return DriverManager.getConnection("jdbc:jtds:sqlserver://DESKTOP-VGNG2FP:1433/BAN_HANG" , "sa" , "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}