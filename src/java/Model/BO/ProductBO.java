/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;

import Model.DAO.ProductDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre
 */
public class ProductBO {
    public List getProducts () {
        try {
            ProductDAO dao = new ProductDAO();
            return dao.getAllProducts();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
