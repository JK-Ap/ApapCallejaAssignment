
import java.util.ArrayList;

public class Catalogue 
{
    //creates a catalogue used to search through books of a specific Library instance
    
    public Library lib;
    
    /**
     * Constructor for Catalogue which takes in an instance of a Library
     * @param l Library instance
     */
    public Catalogue(Library l)
    {
        lib = l;
    }
    
    /**
     * @return the books found in Library
     */
    public ArrayList<Book> getAllBooks()
    {
        return lib.books;
    }
    
    /**
     * gets all the books in the Library whose title contains a specific string
     * @param title string to be used to compare
     * @return the filtered ArrayList of books
     */
    public ArrayList<Book> searchByTitle(String title)
    {
        //used to store the filtered list of books
        ArrayList<Book> filtered = new ArrayList<Book>();
        //checks the title of each Book in the Library
        for(Book book: lib.books)
        {
            if(book.title.toLowerCase().contains(title.toLowerCase()))
            {
                filtered.add(book);
            }
        }
        return filtered;
    }
    
    /**
     * gets all the books in the library of a specific Genre
     * @param g Genre object to be used
     * @return the filtered list of books
     */
    public ArrayList<Book> searchByGenre(Genre g)
    {
        //used to store the filtered list of books
        ArrayList<Book> filtered = new ArrayList<Book>();
        //checks the Genre of each Book in the Library
        for(Book book: lib.books)
        {
            if(book.genre == g)
            {
                filtered.add(book);
            }
        }
        return filtered;
    }
    
    /**
     * gets all the books in the library of a specific year of publication
     * @param year used for filter
     * @return the filtered list of books
     */
    public ArrayList<Book> searchByYearOfPublication(int year)
    {
        //used to store the filtered list of books
        ArrayList<Book> filtered = new ArrayList<Book>();
        //checks the year_of_pub of each Book in the Library
        for(Book book: lib.books)
        {
            if(book.year_of_pub == year)
            {
                filtered.add(book);
            }
        }
        return filtered;
    }
    
    
}
