
import java.util.ArrayList;

public class Catalogue 
{
    Library lib;
    
    protected Catalogue(Library l)
    {
        lib = l;
    }
    
    protected ArrayList<Book> getAllBooks()
    {
        return lib.books;
    }
}
