
import java.util.ArrayList;

public class Book 
{
    String title;
    String author;
    Genre genre;
    int year_of_pub;
    int edition;
    User loaned;
    //id is unique for each book
    int id;
    boolean isLoaned;
    ArrayList<User> queueOfUsers = new ArrayList<User>();
    
    /**
     * Constructor for Book while filling in all its necessary properties 
     * isLoaned is initially set to false
     * @param t used for title
     * @param a used for author
     * @param g instance of Genre used for genre
     * @param y used for year_of_pub
     * @param e used for edition
     * @param i used for id
     */
    public Book(String t, String a, Genre g, int y, int e, int i)
    {
        title = t;
        author = a;
        genre = g;
        year_of_pub =y;
        edition = e;
        id = i;
        loaned = null;
        isLoaned = false;
    }
    
    /**
     * Adds a user to the queue of users to receive the book after immediately
     * after it is returned
     * @param u User to be registered
     * @return false if the book is is already loaned out to the user or 
     *            not loaned out to anyone
     *          true if the Register is successful
     */
    public boolean RegisterInterest(User u)
    {
        if(u.list.contains(this))
            return false;
        if(!this.isLoaned)
            return false;
        this.queueOfUsers.add(u);
        return true;
    }
    
    /**
     * Updates the queue and whoever the book is loaned to when a book is transferred
     * to someone who was registered for it. Uses Update() to see if the new user 
     * is allowed to withdraw the book
     * @return false if the queue is empty or the new user cannot withdraw the book
     *          true otherwise
     */
    public boolean NotifyQueue()
    {
        if(queueOfUsers.isEmpty())
            return false;
        if(queueOfUsers.get(0).Update(this))
        {
            loaned = queueOfUsers.get(0);
            queueOfUsers.remove(queueOfUsers.get(0));
            return true;
        }
        else
            return false;
    }
}
