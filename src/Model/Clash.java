
package Model;

public class Clash {
    private Section section;
    private Course course;
    private Student student;

    public Clash(Section section, Course course, Student student) {
        this.section = section;
        this.course = course;
        this.student = student;
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
    
    @Override
    public String toString() {
        String str = "";
        str += "Course:" + this.course.getTitle() + " ";
        str += "Student: " + this.student.getName() + " ";
        str += "Section: " + this.section.getId();
        return str;
    }
    
}
