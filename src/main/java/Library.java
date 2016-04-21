
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
            {
                System.out.println("Duplicate user");
                return;
            }
                
        }
        users.add(newUser);
        System.out.println("User Added");
        return;
    }
    
    public boolean removeUser(User toDelete)
    {
        if(users.contains(toDelete))
        {
            System.out.println(toDelete.name +" has been removed");
            users.remove(toDelete);
            return true;
        }
        else
        {
            System.out.println("User not found");
            return false;
        }
    }
}
