package clashe_resolving;
import static Model.Entities_Main_Arrays.professor_list;
import static scheduler.pkg0.Runner.semesters;
import Model.Professor;
import Model.Professor_Lecture_Clash;
import java.util.ArrayList;
public class ProfessorClashes {
    public static void resolvClashes() {
        for (Professor professor: professor_list) {
            // professor has no clashes
            if (professor.getClash_array().isEmpty()) {
                continue;
            }
            // professor has clashes
            ArrayList<Professor_Lecture_Clash> professorClashes = professor.getClash_array();
            for (Professor_Lecture_Clash clash: professorClashes) {
                int semester = clash.getSemester() ; 
                String section = clash.getSection(); 
               Section sec =  semesters.get(semester).getSections().get(section) ; 
             }
        }
    }
}
