import java.util.ArrayList;
/**
 * Filter a book by a specific year of public
 * @author User
 */
public class YearFilter implements Filter{

    //filter condition
    public int year = 0;
    
    /**
     * Constructor
     * @param y filter condition
     */
    public YearFilter(int y)
    {
        year = y;
    }
    
    /**
     * Goes through each book in the passed parameter and adds it to a new ArrayList
     * if the book's year of publication matches the instance year
     * @param bookList to be filtered
     * @return the new filtered list
     */
    public ArrayList<Book> filter(ArrayList<Book> bookList) {
        
        //if the year is 0, booklist is returned
        if(year!=0)
        {
            //used to store the filtered list of books
            ArrayList<Book> filtered = new ArrayList<Book>();
            //checks the year_of_pub of each Book in the Library
            for (Book book : bookList) {
                if (book.year_of_pub == year) {
                    filtered.add(book);
                }
            }
            return filtered;
        }
        return bookList;
    }
}
