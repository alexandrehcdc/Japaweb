/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.VO;

/**
 *
 * @author Alexandre
 */
public class SellerVO extends UserVO{
    private String filiation;
    /////////////////////////////////////
    //GET AND SET NAME
    public String getFiliation(){
        return filiation;
    }
    public void setFiliation(String filiation){
        this.filiation = filiation;
    }    
}
