
import java.util.ArrayList;
/**
 * Filter by a specific Genre
 * @author User
 */
public class GenreFilter implements Filter{

    //Genre used for filter
    Genre genre;
    
    /**
     * Constructor
     * @param g filtr condition
     */
    public GenreFilter(Genre g)
    {
        genre = g;
    }
    
    /**
     * Goes through each book in the passed parameter and adds it to a new ArrayList
     * if the book's Genre contains the instance's Genre
     * @param bookList to be filtered
     * @return the new filtered list
     */
    public ArrayList<Book> filter(ArrayList<Book> bookList) {
        
        //does not filter if the genre is null
        if (genre != null) {
            //used to store the filtered list of books
            ArrayList<Book> filtered = new ArrayList<Book>();
            //checks the Genre of each Book in the Library
            for (Book book : bookList) {
                if (book.genre == genre) {
                    filtered.add(book);
                }
            }
            return filtered;
        }
        return bookList;
    }
}
