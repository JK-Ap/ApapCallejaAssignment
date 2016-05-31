
import java.util.ArrayList;

/**
 * Interface for the different filter types
 */
public interface Filter {
    public ArrayList<Book> filter(ArrayList<Book> bookList);
}
