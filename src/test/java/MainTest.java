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
    
    
    @Before
    public void setUp() 
    {
        person = new User("Mark", 1);
        fiction = new Genre("FICTION", "a fiction book");
        b = new Book("Book1","Author1",fiction,1995,1,1);
        l = new Library();          
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
    /*
    Testing correct input for allowUser()
    */
    public void testCorrectUser()
    {
        l.addUser(person);
        ArrayList<User> users = new ArrayList<User>();
        users.add(person);
        
        assertEquals(users, l.users);
    }
    
    @Test
    /**
     * Testing a duplicate id entry in addUser()
     */
    public void testDuplicateUser()
    {
        //this test will attempt to add 2 values to the list but only 1
        //will be added since it is a duplicate
        //Upon comparing the above with the below arraylist
        //The test will result in a success since both lists have a size of 1
        
        User dup_id = new User("John",1);
        l.addUser(person);
        l.addUser(dup_id);
        
        ArrayList<User> testList = new ArrayList<User>();
        testList.add(person);
        
        assertEquals(testList, l.users);
    }
    
    @Test
    /**
     * Testing deleting a user from the library
     */
    public void testValidDelete()
    {
        //this test compares an empty ArrayList with l.users after
        //the library has had only a single user entered and deleted from the library
        l.addUser(person);
        
        ArrayList<User> testList = new ArrayList<User>();
        l.removeUser(person);
        
        assertEquals(testList, l.users);
    }
    
    @Test
    /**
     * testing deleting a user that does not exist
     */
    public void testInvalidDelete()
    {
        User otherUser = new User("John",1);
        
        l.addUser(person);
        assertEquals(false, l.removeUser(otherUser));
    }
    
}
