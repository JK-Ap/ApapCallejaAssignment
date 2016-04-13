package dummy;

public class Dummy {

    String name;
    int age;
    
    public Dummy() {
     
        name = "";
        age = 0;
    }
    
    public void setName(String input) {
        
        name = input;   
    }
    
    public void setAge(int input) {
        
        age = input;
    }
    
    public String getName() {
        
        return this.name;
    }
    
    public int getAge() {
        
        return this.age;
    }
    
}
