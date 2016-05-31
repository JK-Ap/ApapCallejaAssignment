
import java.util.ArrayList;

public class Catalogue 
{
    //creates a catalogue used to search through books of a specific Library instance
    
    /**
     * Constructor for Catalogue private as it is a Singleton class
     */
    private Catalogue()
    {
    }
    
    //Stores the Catalogue instance
    private static Catalogue singInst = null;
    
    /**
     * static method to provide access to the Catalogue instance from other classes
     * @return singInst as the only instance of the catalogue
     */
    public static Catalogue getCatalogueInstance() {
        
        if (singInst == null) {
            singInst = new Catalogue();
        }
        return singInst;
    }
    
    //Library to be used
    Library lib;
    
    //Sets required Library
    public void setLibrary(Library l)
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
     * CompoundFilter is created with all the filter options that will be used 
     * for the compound filter (up to title,genre author and year of publication)
     * The entire list of books is passed through all 4 filters as their return types 
     * are new ArrayLists. Note that if a sort's parameter is not set.
     * @param cf
     * @return 
     */
    public ArrayList<Book> searchForBooks(FacadeFilter cf)
    {
        return cf.callAuthorFilter(cf.callGenreFilter(cf.callTitleFilter(cf.callYearFilter(lib.books))));
    }    
}
