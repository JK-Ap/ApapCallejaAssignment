public class Runner 
{
    public static void main(String args[])
    {
        Library l = new Library();
        Genre fiction = new Genre("FICTION","A fiction book");
        User u1 = new User("Mark",1);
        User u2 = new User("Tony",2);
        User u3 = new User("John",1);
        
        Book b = new Book("Book1","Author1",fiction,1995,1,1);
        
        l.addUser(u1);
        l.addUser(u2);
        l.addUser(u3);
        l.removeUser(u3);
        l.removeUser(u1);
        l.removeUser(u1);
    }
    
}
