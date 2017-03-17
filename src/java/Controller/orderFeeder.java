/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BO.UserBO;
import Model.VO.TransactionsVO;
import Model.VO.UserVO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alexandre
 */
@ManagedBean(name="orderFeeder")
@RequestScoped
public class orderFeeder implements Serializable{
    private List<TransactionsVO> transactions;
    private String transaction_id;
    private double product_id;
    private String seller_username;
    private double tracking_number;
    
    public void setTransactionId(String transaction_id){
        this.transaction_id = transaction_id;
    }
    public String getTransactionId(){
        return transaction_id;
    }
    //
    public void setProductId(double product_id){
        this.product_id = product_id;
    }
    public double getProductId(){
        return product_id;
    }
    //
    public void setSellerUsername(String seller_username){
        this.seller_username = seller_username;
    }
    public String getSellerUsername(){
        return seller_username;
    }
    //
    public void setTrackingNumber(double tracking_number){
        this.tracking_number = tracking_number;
    }
    public double getTrackingNumber(){
        return tracking_number;
    }
    
    public List getOrders() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UserVO user = new UserVO();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        user = (UserVO) session.getAttribute("loggedUser");
        UserBO bo = new UserBO();
        return bo.getOrders(user);
    }
    
    public orderFeeder() {
    }
    
}
