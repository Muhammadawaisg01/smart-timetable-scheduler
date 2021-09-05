package Model ; 

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

    public int getNo() {
        return no;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
    
    
    
}

