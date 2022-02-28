/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDao;

import User.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserDao {
    public List<User> getAllUser() throws SQLException{
        List<User> users = new ArrayList<>();
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql= "SELECT * FROM USER";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                User user = new User();
                
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("Name"));
                user.setPhone(rs.getString("Phone"));
                user.setUsername(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setAbout(rs.getString("About"));
                user.setFavourites(rs.getString("Favourites"));
                user.setRole(rs.getString("Role"));
                
                users.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }
    public void addUser(User user){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql="INSERT INTO USER(NAME,PHONE,USERNAME,PASSWORD,ABOUT,FAVOURITES,ROLE) VALUES (?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPhone());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getAbout());
            preparedStatement.setString(6,user.getFavourites());
            preparedStatement.setString(7,user.getRole());
            
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }        
    public void updateUser(User user){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql="UPDATE USER SET NAME = ?,PHONE = ?,USERNAME = ?,PASSWORD= ?,ABOUT = ?,FAVOURITES =?, ROLE = ? WHERE ID= ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPhone());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setString(5,user.getAbout());
            preparedStatement.setString(6,user.getFavourites());
            preparedStatement.setString(7,user.getRole());
            preparedStatement.setInt(8,user.getId());
            
            
            int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteUser(int id){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql="delete from User where id= ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1,id);
               int rs= preparedStatement.executeUpdate();
            System.out.println(rs);
            
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}