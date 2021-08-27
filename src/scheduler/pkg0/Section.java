
package scheduler.pkg0 ;

public class Section {
    String no ; 

    public Section(String no) {
        this.no = no;
    }

    public Section() {
    }

    public String getNo() {
        return no;
    }

    
    @Override
    public String toString() {
        return "Section{" + "no=" + no + '}';
    }
    
}
