
import java.util.ArrayList;
import java.util.Date;

public class User 
{
    String name;
    //id must be unique
    int id;
    //stores a list of Books and a list of Dates
    //each Book has an associated date to be used when checking if a book
    //is overdue
    ArrayList<Book> list =null;
    ArrayList<Date> dates = null;
    
    /**
     * Constructor for User
     * @param n used for name
     * @param i used for id
     */
    public User(String n,int i)
    {
        name = n;
        id = i;
        list = new ArrayList<Book>();
        dates = new ArrayList<Date>();
    }
}
