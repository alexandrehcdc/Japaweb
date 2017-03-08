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
public class TransactionsVO {
    private int id;
    private int itemId;
    private String sellerUsername;
    private String userUsername;
    
    public TransactionsVO(int id, int itemId, String sellerUsername, String userUsername) {
        setId(id);
        setItemId(itemId);
        setSellerUsername(sellerUsername);
        setUserUsername(userUsername);
    }
    
    public TransactionsVO() {
    }
    
    //////////////////////////////////////
    //GET AND SET ID
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    /////////////////////////////////////
    //GET AND SET ITEM ID
    public int getItemId(){
        return itemId;
    }
    public void setItemId(int itemId){
        this.itemId = itemId;
    }
    /////////////////////////////////////
    //GET AND SET SELLER USERNAME
    public String getSellerUsername(){
        return sellerUsername;
    }    
    public void setSellerUsername(String sellerUsername){
        this.sellerUsername = sellerUsername;
    }   
    /////////////////////////////////////
    //GET AND SET USER USERNAME
    public String getUserUsername(){
        return userUsername;
    }    
    public void setUserUsername(String userUsername){
        this.userUsername = userUsername;
    }
}
