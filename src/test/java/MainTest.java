import java.util.ArrayList;
import java.util.Calendar;
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
    Catalogue c;
    
    
    @Before
    public void setUp() 
    {
        person = new User("Mark", 1);
        fiction = new Genre("FICTION", "a fiction book");
        b = new Book("Book1","Author1",fiction,1995,1,1);
        l = new Library();
        c = new Catalogue(l);
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
        assertEquals(new ArrayList<Book>(), person.list);
        assertEquals(new ArrayList<Calendar>(),person.dates);
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
        //The test will result in a success since both lists are equal
        
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
    
    @Test
    /*
    Testing valid entry of a genre by comparing the instance's arraylist
    to an arraylist with that genre added already
    */
    public void testCorrectGenre()
    {
        l.addGenre(fiction);
        ArrayList<Genre> genresTest = new ArrayList<Genre>();
        genresTest.add(fiction);
        
        assertEquals(genresTest, l.genres);
    }
    
    @Test
    /**
     * Testing adding a genre with an entry in the list already having the same name
     */
    public void testDuplicateGenre()
    {
        //this test will attempt to add 2 values to the list but only 1
        //will be added since it has a duplicate name
        //Upon comparing the above with the below arraylist
        //The test will result in a success since both lists are equal
        
        Genre dup_genre = new Genre("FICTION","A fiction book as well");
        l.addGenre(fiction);
        l.addGenre(dup_genre);
        
        ArrayList<Genre> testList = new ArrayList<Genre>();
        testList.add(fiction);
        
        assertEquals(testList, l.genres);
    }
    
    @Test
    /*
    Testing valid entry of a book by comparing the instance's arraylist
    to an arraylist with that book added already
    */
    public void testCorrectBook()
    {
        l.addBook(b);
        ArrayList<Book> booksTest = new ArrayList<Book>();
        booksTest.add(b);
        
        assertEquals(booksTest, l.books);
    }
    
    @Test
    /**
     * Testing adding a book with duplicate id
     */
    public void testDuplicateBook()
    {
        //this test will attempt to add 2 values to the list but only 1
        //will be added since it has a duplicate id
        //Upon comparing the above with the below arraylist
        //The test will result in a success since both lists are equal
        
        Book dup_book = new Book("Book2","Author1",fiction,2015,1,1);
        l.addBook(b);
        l.addBook(dup_book);
        
        ArrayList<Book> testList = new ArrayList<Book>();
        testList.add(b);
        
        assertEquals(testList, l.books);
    }
    
    @Test
    /**
     * Testing Catalogue getAllBooks()
     */
    public void testGetBooks()
    {     
        assertEquals(c.getAllBooks(), l.books);
    }
    
    @Test
    /**
     * Testing Catalogue searchByTitle()
     */
    public void testGetBooksByTitle()
    {     
        //only books 1 2 and 4 contain the word "dummy" in them so the function should
        //return an ArrayList containing those items
        Book book1 = new Book("ADummyTitle","Author1",fiction,2015,1,1);
        Book book2 = new Book("Dummy","Author1",fiction,2015,2,2);
        Book book3 = new Book("Title","Author1",fiction,2015,3,3);
        Book book4 = new Book("AdummyA","Author1",fiction,2015,4,4);
        Book book5 = new Book("DummmyTitle","Author1",fiction,2015,5,5);
        l.addBook(book1);
        l.addBook(book2);
        l.addBook(book3);
        l.addBook(book4);
        l.addBook(book5);
        
        ArrayList<Book> testList = new ArrayList<Book>();
        testList.add(book1);
        testList.add(book2);
        testList.add(book4);
        
        assertEquals(c.searchByTitle("dummy"), testList);
    }
    
    @Test
    /**
     * Testing Catalogue searchByGenre()
     */
    public void testGetBooksByGenre()
    {     
        //only books 2 and 4 are of the nonficiton genre so the function should
        //return an ArrayList containing those items
        Genre nonfiction = new Genre("NONFICTION","Non-fiction books");
        
        Book book1 = new Book("ADummyTitle","Author1",fiction,2015,1,1);
        Book book2 = new Book("Dummy","Author1",nonfiction,2015,2,2);
        Book book3 = new Book("Title","Author1",fiction,2015,3,3);
        Book book4 = new Book("AdummyA","Author1",nonfiction,2015,4,4);
        Book book5 = new Book("DummmyTitle","Author1",fiction,2015,5,5);
        l.addBook(book1);
        l.addBook(book2);
        l.addBook(book3);
        l.addBook(book4);
        l.addBook(book5);
        
        ArrayList<Book> testList = new ArrayList<Book>();
        testList.add(book2);
        testList.add(book4);
        
        assertEquals(c.searchByGenre(nonfiction), testList);
    }
    
    @Test
    /**
     * Testing Catalogue searchByYearOfPublication()
     */
    public void testGetBooksByYear()
    {     
        //only books 1 and 5 are of the nonficiton genre so the function should
        //return an ArrayList containing those items

        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        Book book2 = new Book("Dummy","Author1",fiction,2015,2,2);
        Book book3 = new Book("Title","Author1",fiction,2015,3,3);
        Book book4 = new Book("AdummyA","Author1",fiction,2015,4,4);
        Book book5 = new Book("DummmyTitle","Author1",fiction,2016,5,5);
        l.addBook(book1);
        l.addBook(book2);
        l.addBook(book3);
        l.addBook(book4);
        l.addBook(book5);
        
        ArrayList<Book> testList = new ArrayList<Book>();
        testList.add(book1);
        testList.add(book5);
        
        assertEquals(c.searchByYearOfPublication(2016), testList);
    }
    
}
