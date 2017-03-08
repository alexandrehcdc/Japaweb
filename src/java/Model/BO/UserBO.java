/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;

import Controller.Login;
import Model.DAO.UserDAO;
import Model.VO.UserVO;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexandre
 */
public class UserBO {
    
    public boolean userEdit(UserVO user) throws ClassNotFoundException, SQLException{
        try {
            UserDAO dao = new UserDAO();
            return dao.userEdit(user);
        }  catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex); 
        }
        return false;
    }
    
    public boolean registerUser(UserVO user){
        try {
            UserDAO dao = new UserDAO();
            return dao.insertUser(user);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    private boolean userDelete(String username, String password) throws SQLException{
        try{
            UserVO user = new UserVO(username,password);
            UserDAO dao = new UserDAO();
            UserVO userToDelete = dao.getUser(user);
            if(userToDelete.getUsername() == null){
                return false;
            } else {
                try{
                    return dao.deleteUser(userToDelete);
                } catch (Exception e){
                    out.println("Impossível deletar usuário");
                    return false;
                }
            }
        } catch (Exception e){
            out.println("Impossível deletar usuário");
            return false;
        }
    }
    
    public boolean addFunds(String username, String password, double value){
        try {
            UserVO user = new UserVO(username, password);
            UserDAO dao = new UserDAO();
            return dao.updateFunds(user, dao.getFunds(user) + value);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public double getFunds(String username, String password) {
        try {
            UserVO user = new UserVO(username, password);
            UserDAO dao = new UserDAO();
            return dao.getFunds(user);
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }  
    }
    
    public boolean getStatus(String username, String password, UserDAO dao) {
        UserVO user = new UserVO(username, password);
        return dao.getAccountStatus(user);
    }
    
    public boolean upgradeAccount(String username, String password, UserDAO dao) {
        UserVO user = new UserVO(username, password);
        if (dao.getFunds(user) < 10){
            return false;
        } else {
<<<<<<< HEAD
            return dao.updateAccount(user);
=======
            return dao.updateAccount(username);
>>>>>>> 343f7f14220d0c3e686eb2fc7d876531691932aa
        }
    }
    
    public UserVO userLogin(String username, String password) throws SQLException {
        try {
            UserVO user = new UserVO(username, password);
            UserDAO dao = new UserDAO();
            return dao.getUser(user);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}