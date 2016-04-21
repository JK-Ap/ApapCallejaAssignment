
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
    
    //adds a user to the users list 
    protected void addUser(User newUser)
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
    
    //removes a user from the users list (if present)
    protected boolean removeUser(User toDelete)
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
    
    //adds a genre to the genres list 
    protected void addGenre(Genre newGenre)
    {
        for(Genre g : genres)
        {
            if(g.name.equals(newGenre.name))
            {
                System.out.println("Duplicate genre");
                return;
            }             
        }
        genres.add(newGenre);
        System.out.println("Genre Added");
        return;
    }
    
    //adds a book to the books list 
    protected void addBook(Book newBook)
    {
        for(Book b : books)
        {
            if(b.id == newBook.id)
            {
                System.out.println("Duplicate book");
                return;
            }
                
        }
        books.add(newBook);
        System.out.println("Book Added");
        return;
    }
    
}
