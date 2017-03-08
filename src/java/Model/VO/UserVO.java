/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.VO;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author Alexandre
 */

@ManagedBean
public class UserVO {
    private String name, address, email, password, username;
    private int age;
    private boolean privilege = false;
    private double funds;

    public UserVO(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public UserVO() {
        
    }
    
    /////////////////////////////////////
    //GET AND SET NAME
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    /////////////////////////////////////
    //GET AND SET ADDRESS
    public String getAddress(){
        return address;
    }    
    public void setAddress(String address){
        this.address = address;
    }
    /////////////////////////////////////
    //GET AND SET EMAIL
    public String getEmail(){
        return email;
    }    
    public void setEmail(String email){
        this.email = email;
    }   
    /////////////////////////////////////
    //GET AND SET PASSWORD
    public String getPassword(){
        return password;
    }    
    public void setPassword(String password){
        this.password = password;
    }
    /////////////////////////////////////
    //GET AND SET PRIVILEGE
    public boolean getPrivilege(){
        return privilege;
    }
    public void setPrivilege(boolean privilege){
        this.privilege = privilege;
    }
    /////////////////////////////////////
    //GET AND SET AGE
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }  
    /////////////////////////////////////
    //GET AND SET USERNAME
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    /////////////////////////////////////
    //GET AND SET FUNDS
    public double getFunds(){
        return funds;
    }
    public void setFunds(double funds){
        this.funds = funds;
    }
}