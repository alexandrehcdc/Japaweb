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
public class ProductVO {
    private int id;
    private String name,description,brand;
    private double price,weight;
    
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
    
    public void setDescription() {
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
    
    public void setPrice() {
        this.price = price;
    }
    
    /////////////////////////////////////
    //GET AND SET WEIGHT
    public double getWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setWeight(){
        this.weight = weight;
    }
}
