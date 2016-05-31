
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
public class CompoundFilter {
    
    private Filter titleFilter;
    private Filter genreFilter;
    private Filter authorFilter;
    private Filter yearFilter;
    
    public CompoundFilter(String t, Genre g, String a, int y) {
        
        titleFilter = new TitleFilter(t);
        genreFilter = new GenreFilter(g);
        authorFilter = new AuthorFilter(a);
        yearFilter = new YearFilter(y);
    }
    
    public ArrayList<Book> callNameFilter(ArrayList<Book> bookList) {
        return titleFilter.filter(bookList);
    }
    
    public ArrayList<Book> callAuthorFilter(ArrayList<Book> bookList) {
        return authorFilter.filter(bookList);
    }
    
    public ArrayList<Book> callGenreFilter(ArrayList<Book> bookList) {
        return genreFilter.filter(bookList);
    }
    
    public ArrayList<Book> callYearFilter(ArrayList<Book> bookList) {
        return yearFilter.filter(bookList);
    }
}
