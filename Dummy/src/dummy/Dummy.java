package dummy;

public class Dummy {

    String name;
    int age;
    
    public Dummy() {
     
        name = "";
        age = 0;
    }
    
    public void dummySetter(String input) {
        
        name = input;
        
    }
    
    public String getName() {
        
        return this.name;
    }
    
}
