/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dummy.Dummy;
import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ze_Ge_000
 */
public class DummyTest {
    
    public DummyTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
    
//    @AfterClass
//    public static void tearDownClass() {
//    }
    
    Dummy d;
    
    @Before
    public void setUp() {
        
        d = new Dummy();
    }
    
    @After
    public void tearDown() {
        
        d = null;
    }
    
    @Test
    public void test_getName() {
        
        d.dummySetter("Joe");
        assertEquals("Joe", d.getName());
    }
    
    @Test
    public void test_getNameFail() {
        
        d.dummySetter("Joe");
        assertEquals("Henry", d.getName());
    }
    
}
