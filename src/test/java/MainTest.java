import java.util.ArrayList;
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
    Library l;
    User dup_id;
    
    @Before
    public void setUp() 
    {
        person = new User("Mark", 1);
        fiction = new Genre("FICTION", "a fiction book");
        b = new Book("Book1","Author1",fiction,1995,1,1);
        l = new Library();
        dup_id = new User("John",1);
        
    }
    
    @After
    public void tearDown() 
    {
        b = null;
        person = null;
        fiction = null;
        l = null;
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
        assertEquals(false,b.isLoaned);
        assertEquals(null,b.loaned); 
    }
    
    @Test
    public void testGenreConstructor()
    {
        assertEquals("FICTION", fiction.name);
        assertEquals("a fiction book", fiction.desc);
    }
    
    @Test
    public void testUserConstructor()
    {
        assertEquals("Mark", person.name);
        assertEquals(1, person.id);
        assertEquals(null, person.list);
        assertEquals(null, person.dates);
    }
    
    @Test
    public void testLibraryConstructor()
    {
        assertEquals(new ArrayList<Book>(), l.books);
        assertEquals(new ArrayList<Genre>(), l.genres);
        assertEquals(new ArrayList<User>(), l.users);
    }
    
    @Test
    public void testCorrectUser()
    {
        l.addUser(person);
        ArrayList<User> users = new ArrayList<User>();
        users.add(person);
        
        assertEquals(users, l.users);
    }
}
