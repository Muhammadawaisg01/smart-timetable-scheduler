package clash_resolving;

import static Controller.Runner.semesters;
import Model.Course;
import Model.Section;
import Model.Section_Day;
import Model.Semester;
import java.util.ArrayList;
import java.util.Random;

public class Student {

    Section fittest;
    Section secondFittest;
    int generationCount = 0;
    int semesterNumber = 2;

    public static void printFittness() {
        for (Semester semester : semesters) {
            ArrayList<Section> sections = semester.getSections();
            for (Section section : sections) {
                System.out.println(section.getId() + "\t" + section.getFittness());
            }
        }
    }

    public void runGA() {
        Random rn = new Random();
        semesters.get(semesterNumber).calculateFitness(semesterNumber);
        System.out.println(semesters.get(semesterNumber).getFittest(semesterNumber).getFittness() + "\tFittness");
//        printFittness();
//        System.exit(0);
        while ((semesters.get(semesterNumber).getFittest(semesterNumber).getFittness()) != 0) {
            ++generationCount;
            //Do selection
            selection();
            //Do crossover
            crossover();
            //Do mutation under a random probability
            if (rn.nextInt() % 7 < 5) {
                mutation();
            }
            //Add fittest offspring to population
            addFittestOffspring();
            //Calculate new fitness value
            semesters.get(semesterNumber).calculateFitness(semesterNumber);
            System.out.println(semesters.get(semesterNumber).getFittest(semesterNumber).getFittness() + "\tFittness");
//            System.out.println("Generation: " + generationCount + " Fittest: " + semesters.get(semesterNumber).getFittest(semesterNumber));
        }
        System.out.println("\nSolution found in generation " + generationCount);
        System.out.println("Fitness: " + semesters.get(semesterNumber).getFittest(semesterNumber).getFittness());
        System.out.print("Genes: ");
        ArrayList<Section_Day> days = semesters.get(semesterNumber).getFittest(semesterNumber).getSchedule().getDays();
        for (int i = 0; i < days.size(); i++) {
            for (int j = 0; j < days.get(i).getTimeslots().size(); j++) {
                System.out.print("Course: " + days.get(i).getTimeslots().get(j).getCourse());
                System.out.print("\tLecture Number: " + days.get(i).getTimeslots().get(j).getLecture_no());
                System.out.print("\tRoom Number" + days.get(i).getTimeslots().get(j).getRoom());
                System.out.print("\tSlot Number: " + days.get(i).getTimeslots().get(j).getSlot_no());
                System.out.println("");
            }
            System.out.println("");
        }
    }

    void selection() {
        //Select the most fittest individual
        fittest = semesters.get(semesterNumber).getFittest(semesterNumber);
        //Select the second most fittest individual
        secondFittest = semesters.get(semesterNumber).getSecondFittest(semesterNumber);
    }

    //Crossover
    void crossover() {
        Random rn = new Random();
        //Select a random crossover point
        int crossOverPoint = rn.nextInt(semesters.get(semesterNumber).getSections().size());
        //Swap values among parents
        for (int i = 0; i < crossOverPoint; i++) {
            String temp = fittest.getSchedule().getDays().get(i).getTimeslots().get(i).getCourse();
            fittest.getSchedule().getDays().get(i).getTimeslots().get(i).setCourse(secondFittest.getSchedule().getDays().get(i).getTimeslots().get(i).getCourse());
            secondFittest.getSchedule().getDays().get(i).getTimeslots().get(i).setCourse(temp);
        }
    }

    //Mutation
    void mutation() {
        Random rn = new Random();
        //Select a random mutation point
        int mutationIndex1 = rn.nextInt(semesters.get(semesterNumber).getSections().size());
        int mutationIndex2 = rn.nextInt(semesters.get(semesterNumber).getSections().size());
        //Flip values at the mutation point
        String temp = fittest.getSchedule().getDays().get(mutationIndex1).getTimeslots().get(mutationIndex1).getCourse();
        fittest.getSchedule().getDays().get(mutationIndex1).getTimeslots().get(mutationIndex1).setCourse(fittest.getSchedule().getDays().get(mutationIndex2).getTimeslots().get(mutationIndex2).getCourse());
        fittest.getSchedule().getDays().get(mutationIndex2).getTimeslots().get(mutationIndex2).setCourse(temp);
        mutationIndex1 = rn.nextInt(semesters.get(semesterNumber).getSections().size());
        mutationIndex2 = rn.nextInt(semesters.get(semesterNumber).getSections().size());
        //Flip values at the mutation point
        temp = fittest.getSchedule().getDays().get(mutationIndex1).getTimeslots().get(mutationIndex1).getCourse();
        fittest.getSchedule().getDays().get(mutationIndex1).getTimeslots().get(mutationIndex1).setCourse(fittest.getSchedule().getDays().get(mutationIndex2).getTimeslots().get(mutationIndex2).getCourse());
        fittest.getSchedule().getDays().get(mutationIndex2).getTimeslots().get(mutationIndex2).setCourse(temp);

        // secong fittest two mutations
        mutationIndex1 = rn.nextInt(semesters.get(semesterNumber).getSections().size());
        mutationIndex2 = rn.nextInt(semesters.get(semesterNumber).getSections().size());
        // swaping courses at the mutation point
        temp = secondFittest.getSchedule().getDays().get(mutationIndex1).getTimeslots().get(mutationIndex1).getCourse();
        secondFittest.getSchedule().getDays().get(mutationIndex1).getTimeslots().get(mutationIndex1).setCourse(secondFittest.getSchedule().getDays().get(mutationIndex2).getTimeslots().get(mutationIndex2).getCourse());
        secondFittest.getSchedule().getDays().get(mutationIndex2).getTimeslots().get(mutationIndex2).setCourse(temp);
        mutationIndex1 = rn.nextInt(semesters.get(semesterNumber).getSections().size());
        mutationIndex2 = rn.nextInt(semesters.get(semesterNumber).getSections().size());
        //swaping courses at the mutation point
        temp = secondFittest.getSchedule().getDays().get(mutationIndex1).getTimeslots().get(mutationIndex1).getCourse();
        secondFittest.getSchedule().getDays().get(mutationIndex1).getTimeslots().get(mutationIndex1).setCourse(secondFittest.getSchedule().getDays().get(mutationIndex2).getTimeslots().get(mutationIndex2).getCourse());
        secondFittest.getSchedule().getDays().get(mutationIndex2).getTimeslots().get(mutationIndex2).setCourse(temp);
    }

    //Get fittest offspring
    Section getFittestOffspring() {
        if (fittest.getFittness() > secondFittest.getFittness()) {
            return fittest;
        }
        return secondFittest;
    }

    //Replace least fittest individual from most fittest offspring
    void addFittestOffspring() {

        //Update fitness values of offspring
        fittest.calFittness();
        secondFittest.calFittness();

        //Get index of least fit individual
        int leastFittestIndex = semesters.get(semesterNumber).getLeastFittestIndex(semesterNumber);
        //Replace least fittest individual from most fittest offspring
        semesters.get(semesterNumber).getSections().set(leastFittestIndex, getFittestOffspring());
    }
}
