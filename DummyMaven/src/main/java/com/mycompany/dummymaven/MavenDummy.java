package com.mycompany.dummymaven;

public class MavenDummy {
 
    String name;
    int age;
    
    public MavenDummy() {
     
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
