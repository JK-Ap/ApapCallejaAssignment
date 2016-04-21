
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Runner 
{
    public static void main(String args[]) throws ParseException
    {
        Library l = new Library();
        Genre fiction = new Genre("FICTION","A fiction book");
        Genre fiction2 = new Genre("FICTION","A fiction book as well");
        User u1 = new User("Mark",1);
        User u2 = new User("Tony",2);
        User u3 = new User("John",1);
        
        Book b = new Book("Book1","Author1",fiction,1995,1,1);
        Book b2 = new Book("Book11","Author10",fiction,2016,1,1);
        
        l.addUser(u1);
        l.addUser(u2);
        l.addUser(u3);
        l.removeUser(u3);
        l.removeUser(u1);
        l.removeUser(u1);
        l.addGenre(fiction);
        l.addGenre(fiction2);
        l.addBook(b);
        l.addBook(b2);
            
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy"); 
        String inputString1 = "22 03 2016";
        String inputString2 = "21 04 2016";

        try 
        {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            System.out.println(l.loanBookTo(b, u2, date1));
            System.out.println(l.loanBookTo(b, u2, date2));
        }
        catch (ParseException e) 
        {
        }
    }
    
}
