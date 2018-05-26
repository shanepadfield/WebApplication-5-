/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shane
 */
public class UserDB {
    
//    User u1 = new User();
//    
//    ArrayList users = new ArrayList();
//    
//    public ArrayList<User> getUser(){
//        
//        u1.setUserID("0");
//        
//        u1.setfName("Georgio");
//        
//        u1.setlName("Georgeson");
//        
//        u1.setEmail("gg@gmail.com");
//        
//        u1.setAddress1("123 House Ave.");
//        
//        u1.setAddress2("");
//        
//        u1.setCity("Charlotte");
//        
//        u1.setState("NC");
//        
//        u1.setZip("28262");
//        
//        u1.setCountry("USA");
//        
//        users.add(u1);
//        
//        return users;
//    }
    
        public static int addUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO `User`(userID, lName, fName, email, address1, address2, city, state, zip, country, password)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getfName());
            ps.setString(3, user.getlName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getAddress1());
            ps.setString(6, user.getAddress2());
            ps.setString(7, user.getCity());
            ps.setString(8, user.getState());
            ps.setString(9, user.getZip());
            ps.setString(10, user.getCountry());
            ps.setString(11, user.getPassword());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int addUser(String userID,String lName,String fName,String email,String address1,String address2,String city,String state,String zip,String country,String password){
        User user = new User();
        user.setUserID(userID);
        user.setAddress1(address1);
        user.setAddress2(address2);
        user.setCity(city);
        user.setCountry(country);
        user.setEmail(email);
        user.setPassword(password);
        user.setState(state);
        user.setZip(zip);
        user.setfName(fName);
        user.setlName(lName);
        
        return addUser(user);
        
    }
    public static User getUser(String userID) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM User "
                + "WHERE userID = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setUserID(rs.getString("userID"));
                user.setAddress1(rs.getString("address1"));
                user.setAddress2(rs.getString("address2"));
                user.setCity(rs.getString("city"));
                user.setCountry(rs.getString("country"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setState(rs.getString("state"));
                user.setZip(rs.getString("zip"));
                user.setfName(rs.getString("fName"));
                user.setlName(rs.getString("lName"));               
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<User> getUsers() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM User";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<User> users = new ArrayList<User>();
            while (rs.next())
            {
                User user = new User();
                user.setUserID(rs.getString("userID"));
                user.setAddress1(rs.getString("address1"));
                user.setAddress2(rs.getString("address2"));
                user.setCity(rs.getString("city"));
                user.setCountry(rs.getString("country"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setState(rs.getString("state"));
                user.setZip(rs.getString("zip"));
                user.setfName(rs.getString("fName"));
                user.setlName(rs.getString("lName"));
                
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    
    
}
