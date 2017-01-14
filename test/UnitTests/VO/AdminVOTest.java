/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTests.VO;

import Model.VO.AdminVO;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertEquals;

/**
 *
 * @author Alexandre
 */
public class AdminVOTest {
    
    public AdminVOTest() {
    }
    
    private AdminVO user;

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
        
  
    @Before
    public void setUp() throws Exception {
        
        user = new AdminVO();   
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testName() throws Exception{
        user.setName("joão");
        assertEquals("joão", user.getName());   
    }  
    
    @Test
    public void testEmail() throws Exception{
        user.setEmail("joaods@gmail.com");
        assertEquals("joaods@gmail.com", user.getEmail());   
    }   
    
    @Test
    public void testPassword() throws Exception{
        user.setPassword("12345hexa");
        assertEquals("12345hexa", user.getPassword());   
    } 
    
    @Test
    public void testPrivilege() throws Exception{
        user.setPrivilege(true);
        assertEquals(true, user.getPrivilege());
    }
    
    @Test
    public void testAge() throws Exception{
        user.setAge(34);
        assertEquals(34, user.getAge());
    }
}