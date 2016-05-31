
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class User {

    String name;
    //id must be unique
    int id;
    //stores a list of Books and a list of Dates
    //each Book has an associated date to be used when checking if a book
    //is overdue
    ArrayList<Book> list = null;
    ArrayList<Date> dates = null;

    /**
     * Constructor for User
     *
     * @param n used for name
     * @param i used for id
     */
    public User(String n, int i) {
        name = n;
        id = i;
        list = new ArrayList<Book>();
        dates = new ArrayList<Date>();
    }

    public boolean Update(Book b) {
        try {
            SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
            Date date1 = myFormat.parse(Calendar.getInstance().getTime().toString());

            for (Date each_date : this.dates) {
                long diff = date1.getTime() - each_date.getTime();
                if (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) > 28) {
                    return false;
                }
            }
            //user must have not more than 3 books
            if (this.list.size() > 2) {
                return false;
            }

            //each date when compared to the current date must be <4weeks
            //otherwise it is added to the user's ArrayLists
            this.list.add(b);
            this.dates.add(date1);
            //the book is set to loaned
            b.isLoaned = true;
            return true;
        } 
        catch (ParseException e) 
        {
        }
        return false;
    }
}
