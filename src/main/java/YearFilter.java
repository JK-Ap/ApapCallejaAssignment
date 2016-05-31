/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
/*
/**
 *
 * @author User
 */
public class YearFilter implements Filter{

    public int year = 0;
    
    public YearFilter(int y)
    {
        year = y;
    }
    
    public ArrayList<Book> filter(ArrayList<Book> bookList) {
        
        if(year!=0)
        {
            //used to store the filtered list of books
            ArrayList<Book> filtered = new ArrayList<Book>();
            //checks the year_of_pub of each Book in the Library
            for (Book book : bookList) {
                if (book.year_of_pub == year) {
                    filtered.add(book);
                }
            }
            return filtered;
        }
        return bookList;
    }
}
