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
    
    public boolean registerUser(UserVO user, UserDAO dao){
        try {
            return dao.insertUser(user);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    private boolean userDelete(String username, String password, UserDAO dao) throws SQLException{
        try{
            UserVO user = dao.getUser(username, password);
            if(user.getUsername() == null){
                return false;
            } else {
                try{
                    return dao.deleteUser(username);
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
    
    private boolean addFunds(String username, UserDAO dao, double value){
        try {
            return dao.updateFunds(username, dao.getFunds(username) + value);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    private double getFunds(String username, UserDAO dao) {
        try {
            return dao.getFunds(username);
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }  
    }
    
    private boolean getPrivilege(String username, UserDAO dao) {
        return dao.getAccountPrivilege(username);
    }
    
    private boolean upgradeAccount(String username, UserDAO dao) {
        if (dao.getFunds(username) < 10){
            return false;
        } else {
            return dao.updateAccount(username);
        }
    }

    public UserVO userLogin(String parameter, String parameter0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}