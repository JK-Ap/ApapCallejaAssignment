public class Book 
{
    String title;
    String author;
    Genre genre;
    int year_of_pub;
    int edition;
    User loaned;
    int id;
    boolean isLoaned;
    
    protected Book(String t, String a, Genre g, int y, int e, int i)
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
}
