package scheduler.pkg0 ; 

import java.util.ArrayList ; 

public class Semester { 
    int no ; 
    ArrayList<Section> sections ; 
    
    public Semester() {
    }
    
    public Semester(int no , ArrayList<Section> sections) {
        this.no = no ;
        this.sections = sections ;
    }

    @Override
    public String toString() {
        return "Semester{" + "no=" + no + ", sections=" + sections + '}';
    }
    
}

