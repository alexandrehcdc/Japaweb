/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model.DAO;

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
public class UserDAO {
    private final Connection connection;
    public UserDAO() throws ClassNotFoundException{
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public boolean insertUser(UserVO user) throws SQLException{
        try {
            String sql = "INSERT INTO users (username, password, email, age, address, privilege, name) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement prepState = connection.prepareStatement(sql);
            prepState.setString(1,user.getUsername());
            prepState.setString(2,user.getPassword());
            prepState.setString(3,user.getEmail());
            prepState.setInt(4, user.getAge());
            prepState.setString(5, user.getAddress());
            prepState.setBoolean(6, user.getPrivilege());
            prepState.setString(7, user.getName());
            prepState.execute();
            return true;
        }
        catch (SQLException sqle){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
            return false;
        }
    }
    
    public List getAllUsers() throws SQLException {
        String sql = "SELECT * FROM users ORDER BY name";
        PreparedStatement prepState;
        ResultSet resultSet;
        List<UserVO> userList = new ArrayList<UserVO>();
        try {
            prepState = connection.prepareStatement(sql);
            resultSet = prepState.executeQuery();
            while(resultSet.next()){
                UserVO nextUser = new UserVO();
                nextUser.setName(resultSet.getString("name"));               
                nextUser.setAddress(resultSet.getString("address"));
                nextUser.setEmail(resultSet.getString("email"));
                nextUser.setPassword(resultSet.getString("password"));
                nextUser.setUsername(resultSet.getString("username"));
                nextUser.setPrivilege(resultSet.getBoolean("privilege"));
                nextUser.setName(resultSet.getString("name"));
                nextUser.setAge(resultSet.getInt("age"));
                userList.add(nextUser);
            }
            return userList;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return null;
    }

    public UserVO getUser(UserVO user) throws SQLException {
        String sql = "SELECT * FROM users WHERE username=? AND password=? ORDER BY name";
        PreparedStatement prepState;
        ResultSet resultSet;
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, user.getUsername());
            prepState.setString(2, user.getUsername());
            resultSet = prepState.executeQuery();
            if(resultSet.next()){
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setAddress(resultSet.getString("address"));                
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setPrivilege(resultSet.getBoolean("privilege"));
                user.setName(resultSet.getString("name"));
                prepState.execute();
                return user;
            }
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return null;
    }

    
    public boolean userEdit(UserVO user) throws SQLException {
        String sql = "UPDATE users SET name=?, address=?, age=?, email=?, password=? WHERE username=?";
        PreparedStatement prepState;
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, user.getName());            
            prepState.setString(2, user.getAddress());
            prepState.setInt(3, user.getAge());
            prepState.setString(4, user.getEmail());
            prepState.setString(5, user.getPassword());            
            prepState.setString(6, user.getUsername());
            prepState.execute();
            return true;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
            return false;
        }
    }
    
    public boolean deleteUser(UserVO user){
        String sql = "DELETE from users WHERE username=? AND password=?";
        PreparedStatement prepState;
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, user.getUsername());
            prepState.setString(2, user.getPassword());
            return true;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return false;
    }
    
    public boolean updateFunds(UserVO user, double value){
        String sql = "UPDATE users SET" +
                "value=?" + "WHERE username=? AND password=?";
        PreparedStatement prepState;
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setDouble(1, value);
            prepState.setString(2, user.getUsername());
            prepState.setString(3, user.getPassword());
            return true;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return false;
    }
    
    public double getFunds(UserVO user){
        double funds = 0;
        String sql = "SELECT funds FROM users WHERE username=? and password=?";
        PreparedStatement prepState;
        ResultSet resultSet = null;
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, user.getUsername());
            funds = resultSet.getDouble("funds");
            return funds;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return funds;
    }
    
    public boolean getAccountStatus(UserVO user) {
        try {
            String sql = "SELECT privilege FROM user WHERE username=? AND password=?";
            PreparedStatement prepState = null;
            ResultSet resultSet = null;
            prepState.setString(1, user.getUsername());            
            prepState.setString(2, user.getPassword());
            return resultSet.getBoolean("privilege");
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);
        }
        return false;
    }
    
    public boolean updateAccount(String username){
        try {
            String sql = "UPDATE users SET privilege=true WHERE username=?";
            PreparedStatement prepState = null;
            ResultSet resultSet = null;           
            prepState.setString(1, username);
            return true;
        } catch (SQLException sqle) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, sqle);            
        }
        return false;
    }
}