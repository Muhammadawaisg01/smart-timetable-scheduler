

package Controller;

import Model.Entities_Main_Arrays;
import Model.TestData;
import static Model.TestData.programs;
import static Model.TestData.rooms;

public class Test {
    public static void main(String[] args) {        

        Model.Entities_Main_Arrays.add_Data_to_Semester_List();
        System.out.println(Entities_Main_Arrays.semesters.size()+"\t\tsize");
        TestData data = new TestData();
        NewAlgorithm.algorithm_based_on_randomization()   ;
        System.out.println("hello world");
        System.out.println("Room size     "+programs.size());
        for(int p=0; p<programs.size(); p++){
            programs.get(p).getSemesters();
            
            System.out.println(programs.get(p).getSemesters().size()+" \t  size");  
        }
    }
}


