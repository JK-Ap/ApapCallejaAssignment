
import java.util.ArrayList;
/**
 * Filter by author
 */
public class AuthorFilter implements Filter {
    
    //filter condition
    public String author;
    
    /**
     * Constructor
     * @param a filter condition
     */
    public AuthorFilter(String a)
    {
        author = a;
    }
    
    /**
     * Goes through each book in the passed parameter and adds it to a new ArrayList
     * if the book's author contains the author's title
     * @param bookList to be filtered
     * @return the new filtered list
     */
    @Override
    public ArrayList<Book> filter(ArrayList<Book> bookList) {
        
         //if there is no filter condition, booklist is returned
        if(!author.isEmpty())
        {
            //used to store the filtered list of books
            ArrayList<Book> filtered = new ArrayList<Book>();
            //checks the title of each Book in the Library
            for (Book book : bookList) {
                if (book.author.toLowerCase().contains(author.toLowerCase())) {
                    filtered.add(book);
                }
            }
            return filtered;
        }
        else
            return bookList;
    }
    
}
