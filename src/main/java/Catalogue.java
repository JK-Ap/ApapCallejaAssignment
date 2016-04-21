
import java.util.ArrayList;

public class Catalogue 
{
    Library lib;
    
    protected Catalogue(Library l)
    {
        lib = l;
    }
    
    /**
     * @return the books found in Library
     */
    protected ArrayList<Book> getAllBooks()
    {
        return lib.books;
    }
    
    /**
     * gets all the books in the library whose title contains a specific string
     * @param title string to be used to compare
     * @return the filtered list of books
     */
    protected ArrayList<Book> searchByTitle(String title)
    {
        ArrayList<Book> filtered = new ArrayList<Book>();
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
     * gets all the books in the library of a specific genre
     * @param g Genre object to be used
     * @return the filtered list of books
     */
    protected ArrayList<Book> searchByGenre(Genre g)
    {
        ArrayList<Book> filtered = new ArrayList<Book>();
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
    protected ArrayList<Book> searchByYearOfPublication(int year)
    {
        ArrayList<Book> filtered = new ArrayList<Book>();
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