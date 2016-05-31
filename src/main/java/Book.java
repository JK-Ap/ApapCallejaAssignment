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
}
