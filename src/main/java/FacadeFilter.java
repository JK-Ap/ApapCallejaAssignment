
import java.util.ArrayList;

/**
 *Used to setup multiple sort conditioons for an arraylist of books to go through
 * using the Facade design pattern
 * @author User
 */
public class FacadeFilter {
    
    private Filter titleFilter;
    private Filter genreFilter;
    private Filter authorFilter;
    private Filter yearFilter;
    
    /**
     * Constructor of the Compound filter taking in each of the 4 possible conditions
     * @param t a string which the title may contain
     * @param g a book Genre
     * @param a the name of the author of a book
     * @param y the year the book was published
     */
    public FacadeFilter(String t, Genre g, String a, int y) {
        
        //assigns the Filter objects with their respective paramters 
        titleFilter = new TitleFilter(t);
        genreFilter = new GenreFilter(g);
        authorFilter = new AuthorFilter(a);
        yearFilter = new YearFilter(y);
    }
    
    /**
     * Filters the list by the title of the book
     * if the title passed in the object is "", the filter is not applied
     * @param bookList initial list passed
     * @return a new ArrayList
     */
    public ArrayList<Book> callTitleFilter(ArrayList<Book> bookList) {
        return titleFilter.filter(bookList);
    }
    
    /**
     * Filters the list by the name of the author of the book
     * if the author passed in the object is "", the filter is not applied
     * @param bookList initial list passed
     * @return a new ArrayList
     */
    public ArrayList<Book> callAuthorFilter(ArrayList<Book> bookList) {
        return authorFilter.filter(bookList);
    }
    
    /**
     * Filters the list by a specific Genre
     * if the Genre passed in the object is null, the filter is not applied
     * @param bookList initial list passed
     * @return a new ArrayList
     */
    public ArrayList<Book> callGenreFilter(ArrayList<Book> bookList) {
        return genreFilter.filter(bookList);
    }
    
    /**
     * Filters the list by a specific year of publication
     * if the year passed in the object is 0, the filter is not applied
     * @param bookList initial list passed
     * @return a new ArrayList
     */
    public ArrayList<Book> callYearFilter(ArrayList<Book> bookList) {
        return yearFilter.filter(bookList);
    }
}
