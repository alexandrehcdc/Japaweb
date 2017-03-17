/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BO.ProductBO;
import Model.VO.ProductVO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Alexandre
 */
@ManagedBean(name="tableFeeder")
@RequestScoped
public class tableFeeder implements Serializable {
    private List<ProductVO> products;
    /**
     * Creates a new instance of tableFeeder
     */
    private String name;
    private double price;
    private String description;
    private double weight;
    private int id;
    private String url = "Cart.xhtml?id=";
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setUrl (String url){
        this.url = url;
    }
    
    public String getUrl() {
        return url;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    
    public List getProducts () {
        ProductBO bo = new ProductBO();
        return bo.getProducts();
    }
    
    public String getProductUrl() {
        System.out.println(url + String.valueOf(id));
        return url + String.valueOf(id);
    }
    
    public tableFeeder() {
    }
    
}
