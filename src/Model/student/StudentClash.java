package Model.student;

import Model.Course;
import Model.semester.Section;

public class StudentClash {
    private Section section;
    private Course course;
    private Student student;
    private int clashes;

    public StudentClash(Section section, Course course, Student student, int clashes) {
        this.section = section;
        this.course = course;
        this.student = student;
        this.clashes = clashes;
    }

    public Section getSection() {
        return section;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public int getClashes() {
        return clashes;
    }
    
    
}
