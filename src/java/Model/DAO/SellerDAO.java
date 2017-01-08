/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.VO.ProductVO;
import Model.VO.SellerVO;
import Model.VO.UserVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre
 */
public class SellerDAO {
    
    private Connection connection;
    
    public SellerDAO() throws ClassNotFoundException{
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void insertSeller(SellerVO seller) throws SQLException{
        try {
            String sql = "INSERT INTO seller (username, password, email, age, address, privilege, name, filiation) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement prepState = connection.prepareStatement(sql);
            prepState.setString(1,seller.getUsername());
            prepState.setString(2,seller.getPassword());
            prepState.setString(3,seller.getEmail());
            prepState.setInt(4, seller.getAge());
            prepState.setString(5, seller.getAddress());
            prepState.setBoolean(6, seller.getPrivilege());
            prepState.setString(7, seller.getName());       
            prepState.setString(8, seller.getFiliation());
            prepState.execute();
        }
        catch (SQLException sqle){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }
    
    public List getAllEmployees() throws SQLException {
        String sql = "SELECT username, name FROM seller WHERE filiation =? ORDER BY name";
        PreparedStatement prepState;
        ResultSet resultSet;
        List<UserVO> sellerList = new ArrayList<UserVO>();
        try {
            prepState = connection.prepareStatement(sql);
            resultSet = prepState.executeQuery();
            while(resultSet.next()){
                SellerVO nextSeller = new SellerVO();
                nextSeller.setName(resultSet.getString("name"));               
                nextSeller.setAddress(resultSet.getString("address"));
                nextSeller.setEmail(resultSet.getString("email"));
                nextSeller.setPassword(resultSet.getString("password"));
                nextSeller.setUsername(resultSet.getString("username"));
                nextSeller.setPrivilege(resultSet.getBoolean("privilege"));
                nextSeller.setName(resultSet.getString("name"));
                nextSeller.setAge(resultSet.getInt("age"));
                nextSeller.setFiliation(resultSet.getString("filiation"));
                sellerList.add(nextSeller);
            }
            return sellerList;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return null;
    }
    
    public boolean userEdit(SellerVO seller) throws SQLException {
        String sql = "UPDATE seller SET" + 
                "name=?, privilege=?, address=?, age=?, email=?, password=?, filiation=?" +
                "WHERE username=?";
        PreparedStatement prepState;
        ResultSet resultSet;
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, seller.getName());            
            prepState.setBoolean(2, seller.getPrivilege());
            prepState.setString(3, seller.getAddress());
            prepState.setInt(4, seller.getAge());
            prepState.setString(5, seller.getEmail());
            prepState.setString(6, seller.getPassword());            
            prepState.setString(7, seller.getName());            
            prepState.setString(8, seller.getFiliation());
            return true;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return false;
    }
    
    public boolean deleteSeller(SellerVO seller){
        String sql = "DELETE from seller WHERE username=?";
        PreparedStatement prepState;
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, seller.getUsername());
            return true;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        } 
        return false;
    }
    
    public boolean insertProduct(ProductVO product, SellerVO seller) {
        try {
            String sql = "INSERT INTO products (id, name_product, seller_username, description, brand, price, weight) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement prepState = connection.prepareStatement(sql);
            //prepState.setString(1,seller.getUsername());
            prepState.setString(2,product.getName());
            prepState.setString(3,seller.getUsername());
            prepState.setString(4, product.getDescription());
            prepState.setString(5, product.getBrand());
            prepState.setDouble(6, product.getPrice());       
            prepState.setDouble(7, product.getWeight());
            prepState.execute();
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return false;
    }
}