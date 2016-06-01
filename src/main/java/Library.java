import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Library 
{
    //Library class used to store all data necessary for the system as well as 
    //add/remove new instances of objects
    
    //stores all Users
    ArrayList<User> users; 
    //stores all Books
    ArrayList<Book> books;
    //stores all Genres
    ArrayList<Genre> genres;
    
    /**
     * Constructor for the Library which initializes the ArrayLists 
     */
    public Library()
    {
        users = new ArrayList<User>();
        books = new ArrayList<Book>();
        genres = new ArrayList<Genre>();
    }
    
    /**
     * adds a user to the users list. The add us successful if the id is unique
     * @param newUser User to be added
     * @return true if the user was successfully added or false if it is a duplicate
     */
    public boolean addUser(User newUser)
    {
        //checks all existing User's id as there cannot be a duplicate id
        for(User u : this.users)
        {
            if(u.id == newUser.id)
            {
                //returns false if a duplicate is found
                System.out.println("Duplicate user");
                return false;
            }
                
        }
        //if it is not a duplicate it is added to the list
        this.users.add(newUser);
        System.out.println("User Added");
        return true;
    }
    
    /**
     * removes a user from the users list (if present)
     * @param toDelete User to be removed
     * @return true if the user was deleted, false if the user does not exist
     */
    public boolean removeUser(User toDelete)
    {
        //checks if the list of Users contains the User
        if(this.users.contains(toDelete))
        {
            //removes the User from users and returns true if it is found
            System.out.println(toDelete.name +" has been removed");
            this.users.remove(toDelete);
            return true;
        }
        else
        {
            //returns false otherwise
            System.out.println("User not found");
            return false;
        }
    }
    
    /**
     * adds a genre to the genres list if there isn't already a Genre with that name
     * @param newGenre Genre to be added
     * @return true if the Genre name is unique, false otherwise
     */ 
    public boolean addGenre(Genre newGenre)
    {
        //checks each Genre's name
        for(Genre g : genres)
        {
            if(g.name.equals(newGenre.name))
            {
                //returns false if the name isn't unique
                System.out.println("Duplicate genre");
                return false;
            }             
        }
        //returns true if the add was successfull
        this.genres.add(newGenre);
        System.out.println("Genre Added");
        return true;
    }
    
    /**
     * adds a Book to the books list. The add us successful if the id is unique
     * @param newBook Book to be added
     * @return true if the Book was successfully added or false if it is a duplicate
     */
    public boolean addBook(Book newBook)
    {
        //checks the id of each existing book
        for(Book b : books)
        {
            if(b.id == newBook.id)
            {
                //returns false if the id is a duplicate
                System.out.println("Duplicate book");
                return false;
            }
        }
        //otherwise adds the book and returns true
        this.books.add(newBook);
        System.out.println("Book Added");
        return true;
    }
    
    /**
     * Loans a specified Book to a Specified user
     * the Book is added to User's list of Books and the date of loan is stored in
     * the User's list of dates to keep track of a specific date for each Book
     * @param book_loaned Book to be loaned
     * @param to_user User
     * @param c date for each loan
     * @return a String message depending on if the loan was successful or not
     *          if it was not successful different messages inform the user why
     *          the loan was not successful
     */
    public String loanBookTo(Book book_loaned, User to_user, Date c)
    {
        //user and books must be in the library
        if(!users.contains(to_user))
            return("User does not exist");
        
        if(!books.contains(book_loaned))
            return ("Book does not exist");
        
        //the book has to not already be loaned
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
        //the book is set to loaned
        book_loaned.isLoaned = true;
        book_loaned.loaned = to_user;
        return "book loaned";
    }   

    /**
     * Returns a loaned book
     * @param returned_book Book instance
     * @return true if the return was successful, false otherwise
     */
    public boolean returnBook(Book returned_book)
    {
        //return false if the book is not loaned or if the Book is not in the 
        //Library's lit of book
        if (!returned_book.isLoaned)
        {
            System.out.println("Book is not loaned");
            return false;
        }
        else if (!this.books.contains(returned_book))
        {
            System.out.println("Book does not exist");
            return false;
        }
        else
        {
            //checks each book for each user
            //if any of the books match, the book is removed along with its
            //respective time in the dates ArrayList
            for(User each_user: this.users)
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
        returned_book.loaned = null;
        
        //book will attempt to be loaned to the next person in the queue
        if(returned_book.NotifyQueue())
            System.out.println("Book has been given to someone else");
        
        return true;
    }
}
