/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alexandre
 */
public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException {
     try {
         Class.forName("org.sqlite.JDBC");
         return DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Alex\\Desktop\\SQLiteStudio\\Japaweb","","");
     } catch (ClassNotFoundException e) {
         System.out.println("O driver especificado não foi encontrado.");
         return null;
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
    }
}