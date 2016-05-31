
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author User
 */
public class GenreFilter implements Filter{

    Genre genre;
    
    public GenreFilter(Genre g)
    {
        genre = g;
    }
    
    public ArrayList<Book> filter(ArrayList<Book> bookList) {
        
        if (genre != null) {
            //used to store the filtered list of books
            ArrayList<Book> filtered = new ArrayList<Book>();
            //checks the Genre of each Book in the Library
            for (Book book : bookList) {
                if (book.genre == genre) {
                    filtered.add(book);
                }
            }
            return filtered;
        }
        return bookList;
    }
    
}
