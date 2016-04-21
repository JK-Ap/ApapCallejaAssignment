
import java.util.ArrayList;
import java.util.Date;

class User 
{
    String name;
    int id;
    ArrayList<Book> list =null;
    ArrayList<Date> dates = null;
    
    public User(String n,int i)
    {
        name = n;
        id = i;
        list = new ArrayList<Book>();
        dates = new ArrayList<Date>();
    }
}
