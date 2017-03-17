/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.VO.ProductVO;
import Model.VO.SellerVO;
import Model.VO.TransactionsVO;
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
public class ProductDAO {
    private final Connection connection;
    
    public ProductDAO() throws ClassNotFoundException{
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public boolean insertProduct(ProductVO product, SellerVO seller) throws SQLException{
        try {
            String sql = "INSERT INTO products (id, name_product, seller_username) VALUES (?,?,?)";
            PreparedStatement prepState = connection.prepareStatement(sql);
            prepState.setInt(1,product.getId());
            prepState.setString(2,product.getName());
            prepState.setString(3,seller.getUsername());
            prepState.execute();
            return true;
        }
        catch (SQLException sqle){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return false;
    }
    
    public int getQuantityProducts() throws SQLException {
        try {
            String sql = "SELECT count(*) FROM products";
            ResultSet resultSet = null;
            return resultSet.getInt("count()");
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return 0;
    }
    
    public List getAllSellerProducts(SellerVO seller) throws SQLException {
        String sql = "SELECT * FROM products WHERE seller_username=? ORDER BY ROWID";
        PreparedStatement prepState = connection.prepareStatement(sql);
        ResultSet resultSet;
        prepState.setString(1, seller.getUsername());
        List<ProductVO> productList = new ArrayList<ProductVO>();
        try {
            prepState.setString(1, seller.getUsername());
            resultSet = prepState.executeQuery();
            while(resultSet.next()){
                ProductVO nextProduct = new ProductVO();
                nextProduct.setId(resultSet.getInt("id"));
                nextProduct.setName(resultSet.getString("name_product"));               
                nextProduct.setBrand(resultSet.getString("brand"));
                productList.add(nextProduct);
            }
            return productList;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return null;
    }
    
    public boolean editProduct(ProductVO product, SellerVO seller) throws SQLException {
        String sql = "UPDATE products SET" + 
                "name_product=?, seller_username=?, description=?, brand=?, price=?, weight=?" +
                "WHERE id=?";
        PreparedStatement prepState;
        ResultSet resultSet;
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, product.getName());
            prepState.setString(2, seller.getUsername());
            prepState.setString(3, product.getDescription());
            prepState.setString(4, product.getBrand());
            prepState.setDouble(5, product.getPrice());
            prepState.setDouble(6, product.getWeight());
            prepState.setInt(7, product.getId());
            resultSet = prepState.executeQuery();
            return true;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return false;
    }
        
    public boolean deleteProduct(ProductVO product, SellerVO seller){
        try {
            ResultSet resultSet;
            String sql = "DELETE FROM products WHERE id=? AND seller_username=?";
            PreparedStatement prepState;
            
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, product.getId());            
            prepState.setString(2, seller.getUsername());
            resultSet = prepState.executeQuery();
            return true;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return false;
    }    
    
    public List getAllProducts () {
        
        try {
            List<ProductVO> productList = new ArrayList<ProductVO>();
            ResultSet resultSet;
            String sql = "SELECT * from products ORDER BY name_product";
            PreparedStatement prepState;
            prepState = connection.prepareStatement(sql);
            resultSet = prepState.executeQuery();
            
            while(resultSet.next()){
                ProductVO nextProduct = new ProductVO();
                nextProduct.setPrice(resultSet.getDouble("price"));
                nextProduct.setName(resultSet.getString("name_product"));               
                nextProduct.setDescription(resultSet.getString("description"));
                nextProduct.setWeight(resultSet.getDouble("weight"));
                productList.add(nextProduct);
            }
            return productList;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return null;
    }
    
    public List getAllProductsByBrand(ProductVO product, SellerVO seller) throws SQLException {
        String sql = "SELECT * FROM products WHERE brand=? AND seller_ ORDER BY ROWID";
        PreparedStatement prepState;
        ResultSet resultSet;
        prepState = connection.prepareStatement(sql);
        resultSet = prepState.executeQuery();
        List<ProductVO> productList = new ArrayList<ProductVO>();
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, product.getBrand());            
            prepState.setString(2, seller.getFiliation());
            resultSet = prepState.executeQuery();
            while(resultSet.next()){
                ProductVO nextProduct = new ProductVO();
                nextProduct.setId(resultSet.getInt("id"));
                nextProduct.setName(resultSet.getString("name_product"));               
                nextProduct.setBrand(resultSet.getString("brand"));
                productList.add(nextProduct);
            }
            return productList;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return null;
    }
    
}
