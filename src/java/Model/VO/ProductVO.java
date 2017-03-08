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
public class ProductVO {
    private int id;
    private String name,description,brand;
    private double price,weight;
    
    public ProductVO(int id, String name, String description, String brand, double price, double weight) {
        setId(id);
        setName(name);
        setDescription(description);
        setBrand(brand);
        setPrice(price);
        setWeight(weight);
    }
    
    public ProductVO() {
    }
    
    /////////////////////////////////////
    //GET AND SET Id
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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
    //GET AND SET DESCRIPTION
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    /////////////////////////////////////
    //GET AND SET BRAND
    public String getBrand() {
        return brand;
    }
    
    public void setBrand(String brand){
        this.brand = brand;
    }
    
    /////////////////////////////////////
    //GET AND SET PRICE
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    /////////////////////////////////////
    //GET AND SET WEIGHT
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight){
        this.weight = weight;
    }
}
