
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
public class AuthorFilter implements Filter {
    
    public String author;
    
    public AuthorFilter(String a)
    {
        author = a;
    }
    
    @Override
    public ArrayList<Book> filter(ArrayList<Book> bookList) {
        
        if(!author.isEmpty())
        {
            //used to store the filtered list of books
            ArrayList<Book> filtered = new ArrayList<Book>();
            //checks the title of each Book in the Library
            for (Book book : bookList) {
                if (book.author.toLowerCase().contains(author.toLowerCase())) {
                    filtered.add(book);
                }
            }
            return filtered;
        }
        else
            return bookList;
    }
    
}
