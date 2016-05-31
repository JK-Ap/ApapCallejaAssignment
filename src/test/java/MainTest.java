import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest
{
    
    public MainTest() 
    {
    }
    Book first_book;
    User first_person;
    Genre fiction;
    Library lib;
    Catalogue cat;
    
    @Before
    public void setUp() 
    {
        first_person = new User("Mark", 1);
        fiction = new Genre("FICTION", "a fiction book");
        first_book = new Book("Book1","Author1",fiction,1995,1,1);
        lib = new Library();
        cat = Catalogue.getCatalogueInstance();
        cat.setLibrary(lib);
    }
    
    @After
    public void tearDown()
    {
        first_book = null;
        first_person = null;
        fiction = null;
        lib = null;
    }
   
    @Test
    public void testBookConstructor()
    {
        assertEquals("Book1", first_book.title);
        assertEquals("Author1", first_book.author);
        assertEquals(fiction, first_book.genre);
        assertEquals(1995, first_book.year_of_pub);
        assertEquals(1,first_book.edition);
        assertEquals(1,first_book.id);
        assertEquals(false,first_book.isLoaned);
        assertEquals(null,first_book.loaned); 
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
        assertEquals("Mark", first_person.name);
        assertEquals(1, first_person.id);
        assertEquals(new ArrayList<Book>(), first_person.list);
        assertEquals(new ArrayList<Date>(),first_person.dates);
    }
    
    @Test
    public void testLibraryConstructor()
    {
        assertEquals(new ArrayList<Book>(), lib.books);
        assertEquals(new ArrayList<Genre>(), lib.genres);
        assertEquals(new ArrayList<User>(), lib.users);
    }
    
    @Test
    public void testCatalogueConstructor()
    {
        assertEquals(lib, cat.lib);
    }
    
    @Test
    /*
    Testing correct input for addUser() by checking the return type of addUser() is true
    */
    public void testCorrectUser()
    {
        assertEquals(true, lib.addUser(first_person));
    }
    
    @Test
    /**
     * Testing a duplicate id entry in addUser() by checking the return type of addUser() is false
     */
    public void testDuplicateUser()
    {
        User dup_id = new User("John",1);
        assertEquals(true, lib.addUser(first_person));
        assertEquals(false, lib.addUser(dup_id));
    }
    
    @Test
    /**
     * Testing deleting a user from the library by checking the return type is true
     */
    public void testValidDelete()
    {
        lib.addUser(first_person);   
        assertEquals(true, lib.removeUser(first_person));
    }
    
    @Test
    /**
     * testing deleting a user that does not exist by checking the return type is false
     */
    public void testInvalidDelete()
    {
        User otherUser = new User("John",1);
        lib.addUser(first_person);
        assertEquals(false, lib.removeUser(otherUser));
    }
    
    @Test
    /*
    Testing valid entry of a genre by checking that the return type is true
    */
    public void testCorrectGenre()
    {
        assertEquals(true, lib.addGenre(fiction));
    }
    
    @Test
    /**
     * Testing adding a genre with an entry in the list already having the same name
     * by checking that the return type is false
     */
    public void testDuplicateGenre()
    {
        Genre dup_genre = new Genre("FICTION","A fiction book as well");
        assertEquals(true, lib.addGenre(fiction));
        assertEquals(false, lib.addGenre(dup_genre));
    }
    
    @Test
    /*
    Testing valid entry of a book by checking the return type of the function
    */
    public void testCorrectBook()
    {
        assertEquals(true, lib.addBook(first_book));
    }
    
    @Test
    /**
     * Testing adding a book with duplicate id by checking that the return type is false
     */
    public void testDuplicateBook()
    {
        Book dup_book = new Book("Book2","Author1",fiction,2015,1,1);
        assertEquals(true, lib.addBook(first_book));
        assertEquals(false, lib.addBook(dup_book));
    }
    
    @Test
    /**
     * Testing Catalogue getAllBooks()
     */
    public void testGetBooks()
    {     
        assertEquals(cat.getAllBooks(), lib.books);
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
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        lib.addBook(book4);
        lib.addBook(book5);
        
        ArrayList<Book> testList = new ArrayList<Book>();
        testList.add(book1);
        testList.add(book2);
        testList.add(book4);
        
        assertEquals(cat.searchByTitle("dummy"), testList);
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
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        lib.addBook(book4);
        lib.addBook(book5);
        
        ArrayList<Book> testList = new ArrayList<Book>();
        testList.add(book2);
        testList.add(book4);
        
        assertEquals(cat.searchByGenre(nonfiction), testList);
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
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        lib.addBook(book4);
        lib.addBook(book5);
        
        ArrayList<Book> testList = new ArrayList<Book>();
        testList.add(book1);
        testList.add(book5);
        
        assertEquals(cat.searchByYearOfPublication(2016), testList);
    }
    
    @Test
    /**
     * Testing Library loanBookTo by checking its string return value
     */
    public void testCorrectLoan()
    {     
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,9,9);
        lib.addBook(book1);
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        String inputString1 = "21 04 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            assertEquals("book loaned", lib.loanBookTo(book1, user1, date1));
        }
        catch (ParseException e) 
        {
        } 
    }
    
    @Test
    /**
     * Testing Library loanBookTo for a book that is not in the library
     * this is done by checking the return value of the function
     */
    public void testLoanForInvalidBook()
    {     
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,9,9);
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        String inputString1 = "21 04 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            assertEquals("Book does not exist", lib.loanBookTo(book1, user1, date1));
        }
        catch (ParseException e) 
        {
        } 
    }
    
    
    @Test
    /**
     * Testing Library loanBookTo for a user that is not in the library
     * this is done by checking the return value of the function
     */
    public void testLoanForInvalidUser()
    {     
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,9,9);
        lib.addBook(book1);
        User user1 = new User("Matthew",5);
        
        String inputString1 = "21 04 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            assertEquals("User does not exist", lib.loanBookTo(book1, user1, date1));
        }
        catch (ParseException e) 
        {
        } 
    }
    
    @Test
    /**
     * Tests a loanBookTo() for a user that has already loaned 3 books
     * by checking the return value
     */
    public void testLoanForExceededMaxBooks()
    {     
        Book book1 = new Book("Title","Author1",fiction,2015,3,3);
        Book book2 = new Book("AdummyA","Author1",fiction,2015,4,4);
        Book book3 = new Book("DummmyTitle","Author1",fiction,2016,5,5);
        Book book4 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        lib.addBook(book4);
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        String inputString1 = "21 04 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            assertEquals("book loaned",lib.loanBookTo(book1, user1, date1));
            assertEquals("book loaned",lib.loanBookTo(book2, user1, date1));
            assertEquals("book loaned",lib.loanBookTo(book3, user1, date1));
            assertEquals("User has already loaned 3 books", lib.loanBookTo(book4, user1, date1));
        }
        catch (ParseException e) 
        {
        } 
    }
    
    @Test
    /**
     * Tests a loanBookTo() for a user that has an overdue book
     */
    public void testLoanForOverdueBooks()
    {     
        Book book1 = new Book("Title","Author1",fiction,2015,3,3);
        lib.addBook(book1);
        Book book2 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book2);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        String inputString1 = "22 03 2016";
        String inputString2 = "21 04 2016";
        
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            assertEquals("book loaned",lib.loanBookTo(book1, user1, date1));
            
            Date date2 = myFormat.parse(inputString2);
            assertEquals("Overdue", lib.loanBookTo(book2, user1, date2));
        }
        catch (ParseException e) 
        {
        }
    }
    
    /**
     * Tests loanBookto() for a book that is already loaned out
     */
    @Test
    public void testBookAlreadyLoaned()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        User user2 = new User("Carl",6);
        lib.addUser(user2);
        
        String inputString1 = "21 04 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            assertEquals("book loaned",lib.loanBookTo(book1, user1, date1));
            assertEquals("Book is already loaned", lib.loanBookTo(book1, user2, date1));
        }
        catch (ParseException e) 
        {
        }
    }
    
    /**
     * Tests a valid return of a book by checking that the book is no longer listed as loaned,
     * the user no longer has the book or its date listed in its ArrayLists and the 
     * function returned true
     */
    @Test
    public void testValidReturn()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        String inputString1 = "21 04 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            lib.loanBookTo(book1, user1, date1);
        }
        catch (ParseException e) 
        {
        }
        assertEquals(true,lib.returnBook(book1));
        //tests are checked on user 1
        assertEquals(0,user1.list.size());
        assertEquals(0,user1.dates.size());
        assertEquals(false,book1.isLoaned);
    }
    
    /**
     * Tests attempting to return a book is not added in the library lists
     */
    @Test
    public void testReturnOfANonAddedBook()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        String inputString1 = "21 04 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            assertEquals("Book does not exist",lib.loanBookTo(book1, user1, date1));
        }
        catch (ParseException e) 
        {
        }
        assertEquals(false,lib.returnBook(book1));
        assertEquals(false,book1.isLoaned);
    }
    
    /**
     * Tests attempting to return a book that is not loaned to anyone
     */
    @Test
    public void testReturnOfANonLoanedBook()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        assertEquals(false,lib.returnBook(book1));
    }
    
    /**
     * Tests attempting to register interest in a book correctly
     */
    @Test
    public void testCorrectRegister()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        User user2 = new User("John",2);
        lib.addUser(user2);
        
        String inputString1 = "21 04 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            lib.loanBookTo(book1, user2, date1);
        }
        catch (ParseException e) 
        {
        }
        
        assertEquals(true,book1.RegisterInterest(user1));
    }
    
    /**
     * Tests attempting to register interest in a book correctly
     */
    @Test
    public void testIncorrectRegisterNotLoaned()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        assertEquals(false,book1.RegisterInterest(user1));
    }
    
    /**
     * Tests attempting to register interest in a book correctly
     */
    @Test
    public void testincorrectRegisterAlreadyThreeBooks()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        String inputString1 = "21 04 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            lib.loanBookTo(book1, user1, date1);
        }
        catch (ParseException e) 
        {
        }
        
        assertEquals(false,book1.RegisterInterest(user1));
    }
    
    /**
     * Tests updating a user with a registered book given
     */
    @Test
    public void testCorrectUpdate()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        assertEquals(true,user1.Update(book1));
    }   
    
    /**
     * Tests updating a user with a registered book given but the user has
     * an overdue book
     */
    @Test
    public void testIncorrectUpdateOverdue()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        Book book2 = new Book("ADummyTitle","Author1",fiction,2016,2,2);
        lib.addBook(book2);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        String inputString1 = "21 05 2010";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date2 = myFormat.parse(inputString1);
            lib.loanBookTo(book1, user1, date2);
        }
        catch (ParseException e) 
        {
        }
        
        assertEquals(false,user1.Update(book1));
    } 
    
    /**
     * Tests updating a user with a registered book given but the user 
     * already has 3 books
     */
    @Test
    public void testIncorrectUpdateMaxBooksWithdrawn()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        Book book2 = new Book("ATitle","Author1",fiction,2016,2,2);
        lib.addBook(book2);
        Book book3 = new Book("AnotherDummy","Author1",fiction,2016,3,3);
        lib.addBook(book3);
        Book book4 = new Book("Dummy","Author1",fiction,2016,4,4);
        lib.addBook(book4);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        String inputString1 = "21 05 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            lib.loanBookTo(book1, user1, date1);
            lib.loanBookTo(book4, user1, date1);
            lib.loanBookTo(book3, user1, date1);
        }
        catch (ParseException e) 
        {
        }
        
        assertEquals(false,user1.Update(book4));
    } 

    /**
     * Tests NotifyQueue with valid case, the assert is done on the boolean isLoaned 
     * of the book as after being returned it should still be set as loaned
     */
    @Test
    public void testCorrectNotifyQueue()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        User user2 = new User("Wendy",2);
        lib.addUser(user2);
        
         String inputString1 = "21 05 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            lib.loanBookTo(book1, user2, date1);
        }
        catch (ParseException e) 
        {
        }
        
        assertEquals(true,book1.RegisterInterest(user1));
        assertEquals(true,lib.returnBook(book1));
        assertEquals(true,book1.isLoaned);
    }   
    
    /**
     * Tests NotifyQueue with invalid case as noone has registered interest
     */
    @Test
    public void testIncorrectNotifyQueueWithNoQueue()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        Book book2 = new Book("ADummyTitle","Author1",fiction,2016,2,2);
        lib.addBook(book2);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        User user2 = new User("Wendy",2);
        lib.addUser(user2);
        
        String inputString1 = "21 05 2016";
        String inputString2 = "21 05 2010";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            lib.loanBookTo(book1, user2, date1);
            //overdue
            Date date2 = myFormat.parse(inputString2);
            lib.loanBookTo(book2, user1, date2);
        }
        catch (ParseException e) 
        {
        }
        
        assertEquals(true,book1.RegisterInterest(user1));
        assertEquals(true,lib.returnBook(book1));
        assertEquals(false,book1.isLoaned);
    }   
    
    
    /**
     * Tests NotifyQueue with invalid case as noone has registered interest
     */
    @Test
    public void testIncorrectNotifyQueueWithOverdueUser()
    {
        Book book1 = new Book("ADummyTitle","Author1",fiction,2016,1,1);
        lib.addBook(book1);
        
        User user1 = new User("Matthew",5);
        lib.addUser(user1);
        
        User user2 = new User("Wendy",2);
        lib.addUser(user2);
        
         String inputString1 = "21 05 2016";
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        try 
        {
            Date date1 = myFormat.parse(inputString1);
            lib.loanBookTo(book1, user2, date1);
        }
        catch (ParseException e) 
        {
        }
        
        assertEquals(true,lib.returnBook(book1));
        assertEquals(false,book1.isLoaned);
    }
}


