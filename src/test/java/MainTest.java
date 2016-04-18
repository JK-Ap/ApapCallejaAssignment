import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest
{
    
    public MainTest() 
    {
    }
    Book b;
    User person;
    Genre fiction;
    
    @Before
    public void setUp() 
    {
        person = new User("Mark", 1);
        fiction = new Genre("FICTION", "a fiction book");
        b = new Book("Book1","Author1",fiction,1995,1,1);
    }
    
    @After
    public void tearDown() 
    {
        b = null;
        person = null;
        fiction = null;
    }
   
    @Test
    public void testBookConstructor()
    {
        assertEquals("Book1", b.title);
        assertEquals("Author1", b.author);
        assertEquals(fiction, b.genre);
        assertEquals(1995, b.year_of_pub);
        assertEquals(1,b.edition);
        assertEquals(1,b.id);
    }
    
    @Test
    public void testGenreConstructor()
    {
        assertEquals("FICTION", fiction.name);
        assertEquals("a fiction book", fiction.desc);
    }
}
