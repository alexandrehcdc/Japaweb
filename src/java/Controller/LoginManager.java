/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BO.UserBO;
import Model.VO.UserVO;
import Controller.SessionContext;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.faces.context.ExternalContext;

/**
 *
 * @author Alexandre
 */
@ManagedBean
@SessionScoped
public class LoginManager implements Serializable {
    private String password;
    private String username;
    private String email;
    private int age;
    
    public int getAge(){
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String doLogin() {
        try {
            UserBO bo = new UserBO();
            UserVO user = bo.userLogin(username, password);
            if (user == null) {
                FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_WARN, "Dados incorretos.", "Reinsira os seus dados novamente ou tente mais tarde."));
                return "Login";
            } else {
                HttpSession session = SessionContext.getSession();
                session.setAttribute("loggedUser", user);
                return "Index";
            }
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().validationFailed();
            return "";
        }
    }
    
    public String doSignup() {
        try {
            UserBO bo = new UserBO();
            UserVO user = new UserVO();
            user.setUsername(username);            
            user.setPassword(password);
            user.setEmail(email);
            user.setAge(age);
            if(!bo.registerUser(user)) {
                FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_WARN, "Dados incorretos.", "Reinsira os seus dados novamente ou tente mais tarde."));
                return "Signup";
            } else {
                return "Login";
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().validationFailed();
            return "";
        }
    }
    
    public String goToSignup () {
        return "/Signup";
    }
    
    public void signOut () {
        try {
            ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();
            external.invalidateSession();
            external.redirect("Login.xhtml");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public LoginManager() {
    }
    
}
