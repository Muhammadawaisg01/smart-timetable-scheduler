package clash_resolving;

import static Model.Entities_Main_Arrays.professor_list;
import static Model.Entities_Main_Arrays.semesters;
import Model.professor.Professor;
import Model.professor.Professor_Day;
import Model.semester.Section;
import Model.professor.Professor_Lecture_Clash;
import Model.professor.Professor_Timeslot;
import Model.room.Room;
import Model.semester.Section_Day;
import Model.semester.Section_Timeslot;
import java.util.ArrayList;
import static Model.Entities_Main_Arrays.rooms;

public class ProfessorClashes {

    public static int clashesResolved = 0;

    public static void resolveClashes() {
        for (Professor professor : professor_list) {
            // professor has no clashes
            if (professor.getClash_array().isEmpty()) {
                continue;
            }
            // professor has clashes
            ArrayList<Professor_Lecture_Clash> professorClashes = professor.getClash_array();
            Section section_obj = null; // This section has clash
            int semester_no = 0;
            for (Professor_Lecture_Clash clash : professorClashes) {
                boolean resolved = false;
                semester_no = clash.getSemester() - 1;
                String section_no = clash.getSection();
                ArrayList<Section> sections = semesters.get(semester_no).getSections();
                // Finding section having clash
                for (Section section : sections) {
                    // section has clashes
                    if (section.getId().equalsIgnoreCase(section_no)) {
                        section_obj = section;
                        break;
                    }
                }
                // Loop on Days of section having clash
                ArrayList<Section_Day> days = section_obj.getSchedule().getDays();
                for (Section_Day day : days) {
                    // Loop on time slots of each day
                    ArrayList<Section_Timeslot> section_Timeslots = day.getTimeslots();
                    for (Section_Timeslot section_Timeslot : section_Timeslots) {
                        // Find empty slot
                        if (!section_Timeslot.isCheck()) { // slot is empty     
                            // search that slot in professor time slot schedule
                            int emptySlotNo = section_Timeslot.getSlot_no();  // empty section slot
                            ArrayList<Professor_Day> professor_Days = professor.getSchedule().getDays();
                            for (Professor_Day professor_Day : professor_Days) {
                                ArrayList<Professor_Timeslot> professor_Timeslots = professor_Day.getTimeslots();
                                for (Professor_Timeslot professor_Timeslot : professor_Timeslots) {
                                    if (professor_Timeslot.getCheck()==false) {      // slot is empty
                                        int emptyProfSlot = professor_Timeslot.getSlot_No(); // prof empty slot
                                        // finding room in that particular empty slot where section and professor are free
                                        int day_no = professor_Day.getNo();
                                        int slot_no = emptyProfSlot;
                                        Room rm = find_Empty_Slot_In_Room(day_no, slot_no);                 
                                        if (rm != null) {
                                            rm.getDays().get(day_no).getTimeslots().get(slot_no).setCheck(true);
                                            clash.setIsresolved(true);
//                                            Professor_Timeslot prof_timeslot = professor.getSchedule().getDays().get(day_no).getTimeslots().get(slot_no);
                                            Professor_Timeslot prof_timeslot = professor_Timeslot;
                                            prof_timeslot.setCheck(true);
                                            prof_timeslot.setRoom(rm.getName());
                                            prof_timeslot.setSlot_No(slot_no);
                                            prof_timeslot.setCourse_code(clash.getCourse());
                                            prof_timeslot.setSemester(clash.getSemester());
                                            prof_timeslot.setSection(clash.getSection());
                                            
                                            System.out.println("I am spotted");
                                            System.out.println(prof_timeslot.getCheck());
                                            System.out.println(prof_timeslot.getCourse_code());
                                            System.out.println(prof_timeslot.getRoom());
                                            System.out.println(prof_timeslot.getSection());
                                            System.out.println(prof_timeslot.getSemester());
                                            System.out.println(prof_timeslot.getSlot_No());
                                            System.out.println("I am ending");

                                            Section_Timeslot sec_timeslot = section_obj.getSchedule().
                                                    getDays().get(day_no).getTimeslots().get(slot_no);

                                            sec_timeslot.setCheck(true);
                                            sec_timeslot.setCourse_code(clash.getCourse());
                                            sec_timeslot.setRoom(rm.getName());
                                            sec_timeslot.setSlot_no(slot_no);
                                            sec_timeslot.setLecture_no(0);
                                            resolved = true;
                                            clashesResolved++;
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                if (resolved) {
                                    break;
                                }
                            }
                        }
                        if (resolved) {
                            break;
                        }
                    }
                    if (resolved) {
                        break;
                    }
                }
            }
        }
    }

    private static Room find_Empty_Slot_In_Room(int day, int slot_no) {
        for (Room rm : rooms) {
            if (!rm.getDays().get(day).getTimeslots().get(slot_no).isCheck()) {
                return rm;
            }
        }
        return null;
    }

}
