
import java.util.ArrayList;
import java.util.Calendar;

class User 
{
    String name;
    int id;
    ArrayList<Book> list =null;
    ArrayList<Calendar> dates = null;
    
    protected User(String n,int i)
    {
        name = n;
        id = i;
        list = new ArrayList<Book>();
        dates = new ArrayList<Calendar>();
    }
}
