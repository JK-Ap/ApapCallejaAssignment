
import java.util.ArrayList;

public class Library 
{
    ArrayList<User> users; 
    ArrayList<Book> books;
    ArrayList<Genre> genres;
    
    protected Library()
    {
        users = new ArrayList<User>();
        books = new ArrayList<Book>();
        genres = new ArrayList<Genre>();
    }
    
    public void addUser(User newUser)
    {
        for(User u : users)
        {
            if(u.id == newUser.id)
                return;
        }
        users.add(newUser);
    }
}
