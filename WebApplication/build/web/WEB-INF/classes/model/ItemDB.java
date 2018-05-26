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

/**
 *
 * @author Shane
 */
public class ItemDB {

//    Item r1 = new Item();
//    Item r2 = new Item();
//    Item r3 = new Item();
//    Item r4 = new Item();
//    Item r5 = new Item();
//    Item r6 = new Item();
//
//    ArrayList anReviews = new ArrayList();
//
//    public ArrayList<Item> getItem() {
//
//        r1.setItemCode("0");//Dokken, Tooth and Nail
//        r2.setItemCode("1");//Of Mice and Men, Defy
//        r3.setItemCode("2");//Protest the Hero, Pacific Myth
//        r4.setItemCode("3");//Black Flag, Damaged
//        r5.setItemCode("4");//Carly Rae Jepsen, Emotion
//        r6.setItemCode("5");//Stone Temple Pilots, Stone Temple Pilots (2018)
//
//        r1.setCategory("Metal");//dokken
//        r2.setCategory("Metal");//om&m
//        r3.setCategory("Metal");//pth
//        r4.setCategory("Rock/Pop");//bf
//        r5.setCategory("Rock/Pop");//crj
//        r6.setCategory("Rock/Pop");//stp
//
//        r1.setItemName("Dokken, Tooth and Nail");
//        r2.setItemName("Of Mice and Men, Defy");
//        r3.setItemName("Protest the Hero, Pacific Myth");
//        r4.setItemName("Black Flag, Damaged");
//        r5.setItemName("Carly Rae Jepsen, Emotion");
//        r6.setItemName("Stone Temple Pilots, Stone Temple Pilots (2018)");
//
//        r1.setDescription("Classic Dokken, Classic Songs, Classic Album.");
//        r2.setDescription("New singer, same sound, banger.");
//        r3.setDescription("Flew in under the radar, good one but not as good as Volition.");
//        r4.setDescription("One of the all time greatest punk albums.");
//        r5.setDescription("How can you not love this.");
//        r6.setDescription("New singer here too, Jeff Gut, he good, album good.");
//
//        r1.setScore("5");
//        r2.setScore("5");
//        r3.setScore("4");
//        r4.setScore("5");
//        r5.setScore("5");
//        r6.setScore("4");
//
//        anReviews.add(r1);
//        anReviews.add(r2);
//        anReviews.add(r3);
//        anReviews.add(r4);
//        anReviews.add(r5);
//        anReviews.add(r6);
//        
//        return anReviews;
//    }

    public static int addItem(Item item) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO `Item`(itemCode, itemName, category, descritption, score)"
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, item.getItemCode());
            ps.setString(2, item.getItemName());
            ps.setString(3, item.getCategory());
            ps.setString(4, item.getDescription());
            ps.setString(5, item.getScore());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int addItem(String itemCode,String itemName,String category,String description,String score){
        Item item = new Item();
        item.setCategory(category);
        item.setDescription(description);
        item.setItemCode(itemCode);
        item.setItemName(itemName);
        item.setScore(score);
        
        return addItem(item);
        
    }
    public static Item getItem(String itemCode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Item "
                + "WHERE itemCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, itemCode);
            rs = ps.executeQuery();
            Item item = null;
            if (rs.next()) {
                item = new Item();
                item.setItemCode(rs.getString("itemCode"));
                item.setCategory(rs.getString("category"));
                item.setDescription(rs.getString("description"));
                item.setItemName(rs.getString("itemName"));
                item.setScore(rs.getString("score"));
                
            }
            return item;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<Item> getItems() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Item";
        ArrayList<Item> anReviews = new ArrayList<Item>();
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next())
            {
                Item item = new Item();
                item.setItemCode(rs.getString("itemCode"));
                item.setCategory(rs.getString("category"));
                item.setDescription(rs.getString("description"));
                item.setItemName(rs.getString("itemName"));
                item.setScore(rs.getString("score"));
                
                
                anReviews.add(item);
            }
            return anReviews;
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
