

package View;

import javax.swing.JPanel;

public interface Panels_Management {
    
    public void add_all_panels_of_programs_to_list();
    public void add_all_panels_of_department_to_list();
    public void add_all_panels_of_students_to_list();
    public void add_all_panels_of_courses_to_list();
    public void add_all_panels_of_view_timetable_to_list();
    public void add_all_panels_of_schedule_generation_to_list();
    
    
    
    public void programs_panel_visibility(JPanel panel);
    public void department_panel_visibility(JPanel panel);
    public void students_panel_visibility(JPanel panel);
    public void courses_panel_visibility(JPanel panel);
    public void view_timetable_panel_visibility(JPanel panel);
    public void schedule_generation_panel_visibility(JPanel panel);

}
