/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests.VO;

import Model.VO.UserVO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author Alexandre
 */
public class UserVOTest {
    
    public UserVOTest() {
    }
    
    private UserVO user;

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
        
  
    @Before
    public void setUp() throws Exception {
        user = new UserVO();   
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testName() throws Exception{
        String name = "joao"; 
        user.setName(name);
        assertEquals(name, user.getName());   
    }  
    
    @Test
    public void testEmail() throws Exception{
        String email = "joaods@gmail.com"; 
        user.setEmail(email);
        assertEquals(email, user.getEmail());   
    }   
    
    @Test
    public void testPassword() throws Exception{
        String password = "12345hexa";
        user.setPassword(password);
        assertEquals(password, user.getPassword());   
    } 
    
    @Test
    public void testPrivilege() throws Exception{
        user.setPrivilege(true);
        assertEquals(true, user.getPrivilege());
    }
    
    @Test
    public void testAge() throws Exception{
        int age = 34;
        user.setAge(age);
        assertEquals(age, user.getAge());
    }
    
    @Test
    public void testFunds(){
        double value = 150.4;
        user.setFunds(value);
        assertEquals(value, user.getFunds());
    }
    
    @Test
    public void testAddress(){
        String avenida = "Avenida teste testando";
        user.setAddress(avenida);
        assertEquals(user.getAddress(), avenida);
    }
    
    @Test 
    public void testUsername(){
        String username = "usuarioteste";
        user.setUsername(username);
        assertEquals(user.getUsername(), username);
    }
}