/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.dummymaven.MavenDummy;
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
public class DummyMavenTest {
    
    public DummyMavenTest() {
    }
    
    MavenDummy md;
    
    @Before
    public void setUp() {
        
        md = new MavenDummy();
    }
    
    @After
    public void tearDown() {
        
        md = null;
    }
    
    @Test
    public void test_getName() {
        
       md.setName("Joe");
       assertEquals("Joe", md.getName());
    }
    
}
