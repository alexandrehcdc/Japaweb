/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;

import Model.DAO.ProductDAO;
import Model.VO.ProductVO;
import Model.VO.SellerVO;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre
 */
public class SellerBO extends UserBO {
    
    public boolean insertProduct(ProductVO product, SellerVO seller) {
        try {
            ProductDAO dao = new ProductDAO();
            return dao.insertProduct(product, seller);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SellerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean editProduct(ProductVO product, SellerVO seller){
        try {
            ProductDAO dao = new ProductDAO();
            return dao.editProduct(product, seller);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SellerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean deleteProduct(ProductVO product, SellerVO seller){
        try {
            ProductDAO dao = new ProductDAO();
            return dao.deleteProduct(product, seller);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SellerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List getAllProductsByBrand(ProductVO product, SellerVO seller){
        try {
            ProductDAO dao = new ProductDAO();
            return dao.getAllProductsByBrand(product, seller);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SellerBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   
}