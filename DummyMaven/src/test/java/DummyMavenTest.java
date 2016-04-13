import com.mycompany.dummymaven.MavenDummy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    
//    @Test
//    public void test_getNameFail() {
//        
//        md.setName("Joe");
//        assertEquals("Henry", md.getName());
//    }
    
    @Test
    public void test_getAge() {
        
        md.setAge(18);
        assertEquals(18, md.getAge());
    }
    
}
