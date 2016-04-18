public class Book 
{
    String title;
    String author;
    Genre genre;
    int year_of_pub;
    int edition;
    User loaned;
    
    protected Book(String t, String a, Genre g, int y, int e)
    {
        title = t;
        author = a;
        genre = g;
        year_of_pub =y;
        edition = e;
    }
}
