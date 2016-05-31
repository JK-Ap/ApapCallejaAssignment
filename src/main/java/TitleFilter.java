
import java.util.ArrayList;
/**
 * Filter by title of book
 */
public class TitleFilter implements Filter{

    //filter condition
    public String title;
    
    /**
     * COnstructor
     * @param t title to be used for filter
     */
    public TitleFilter(String t)
    {
        title = t;
    }
    
    /**
     * Goes through each book in the passed parameter and adds it to a new ArrayList
     * if the book's title contains the instance's title
     * @param bookList to be filtered
     * @return the new filtered list
     */
    @Override
    public ArrayList<Book> filter(ArrayList<Book> bookList) {
        
        //if there is no filter condition, booklist is returned
        if(!title.isEmpty())
        {
            //used to store the filtered list of books
            ArrayList<Book> filtered = new ArrayList<Book>();
            //checks the title of each Book in the Library
            for (Book book : bookList) {
                if (book.title.toLowerCase().contains(title.toLowerCase())) {
                    filtered.add(book);
                }
            }
            return filtered;
        }
        else
            return bookList;
    }
    
}
