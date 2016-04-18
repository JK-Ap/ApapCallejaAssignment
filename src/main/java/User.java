
import java.util.ArrayList;
import java.util.Date;

class User 
{
    String name;
    int id;
    ArrayList<Book> list = new ArrayList<Book>();
    ArrayList<Date> dates = new ArrayList<Date>();
    
    protected User(String n,int i)
    {
        name = n;
        id = i;
        list = null;
        dates = null;
    }
}
