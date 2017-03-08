/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests.VO;

import Model.VO.ProductVO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alexandre
 */
public class ProductVOTest {
    
    public ProductVOTest() {
    }
    
    private ProductVO product;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        product = new ProductVO();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testName() throws Exception{
        String name = "joao"; 
        product.setName(name);
        assertEquals(name, product.getName());
    }  
    
    @Test
    public void testId() throws Exception {
        int Id = 230941;
        product.setId(Id);
        assertEquals(Id, product.getId());
    }
    
    @Test
    public void testDescription() throws Exception {
        String description = "Objeto feito com materiais biodegradáveis, artesanalmente.";
        product.setDescription(description);
        assertEquals(product, product.getDescription());
    }
    
    @Test
    public void testBrand() throws Exception {
        String brand = "Jarapinga Ltda.";
        product.setBrand(brand);
        assertEquals(brand, product.getBrand());
    }
    
    @Test
    public void testPrice() throws Exception {
        double price = 33.90;
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }
    
    @Test
    public void testWeight() throws Exception {
        double weight = 0.340;
        product.setWeight(weight);
        assertEquals(weight, product.getWeight());
    }
}
