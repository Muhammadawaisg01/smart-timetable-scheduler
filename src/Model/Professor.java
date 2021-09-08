

package Model ; 

import java.util.ArrayList ; 

public class Professor { 
    int id ;    
    String name ;   
    
    Professor_Schedule schedule ; 
    ArrayList<Professor_Lecture_Clash> clash_array =  new ArrayList<>();     
    
    
    public Professor( int id, String name ) { 
        this.id = id ; 
        this.name = name ; 
    }   
    
    public Professor() {
    }

    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", name=" + name + '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor_Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Professor_Schedule schedule) {
        this.schedule = schedule;
    }
    
    
    
}



