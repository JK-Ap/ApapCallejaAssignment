
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Library 
{
    ArrayList<User> users; 
    ArrayList<Book> books;
    ArrayList<Genre> genres;
    
    public Library()
    {
        users = new ArrayList<User>();
        books = new ArrayList<Book>();
        genres = new ArrayList<Genre>();
    }
    
    //adds a user to the users list 
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
    
    //removes a user from the users list (if present)
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
    
    //adds a genre to the genres list 
    public void addGenre(Genre newGenre)
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
    public void addBook(Book newBook)
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
    
    
    public String loanBookTo(Book book_loaned, User to_user, Date c)
    {
        //user and books must be in the library
        if(!users.contains(to_user))
            return("User does not exist");
        
        if(!books.contains(book_loaned))
            return ("Book does not exist");
        
        if(book_loaned.isLoaned)
            return ("Book is already loaned");
        
        //user must have not more than 3 books
        if(to_user.list.size()>2)
            return ("User has already loaned 3 books");

        //each date when compared to the current date must be <4weeks
        for(Date each_date: to_user.dates)
        {
            long diff = c.getTime() - each_date.getTime();
            if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)>28)
                return ("Overdue");             
        }
        
        //otherwise it is added to the user's ArrayLists
        to_user.list.add(book_loaned);
        to_user.dates.add(c);
        book_loaned.isLoaned = true;
        return "book loaned";
    }   

    public boolean returnBook(Book returned_book)
    {
        if (!returned_book.isLoaned)
            return false;
        else if (!books.contains(returned_book))
            return false;
        else
        {
            //checks each book for each user
            //if any of the books match, the book is removed along with its
            //respective time in the dates ArrayList
            for(User each_user: users)
            {
                for(int i =0; i<each_user.list.size();i++)
                {
                    if(each_user.list.get(i) == returned_book)
                    {
                        each_user.list.remove(i);
                        each_user.dates.remove(i);
                        break;
                    }
                }
            }
        }
        returned_book.isLoaned = false;
        return true;
    }
}
