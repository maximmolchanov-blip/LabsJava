package edu.ntudp.Molchanov.L2.view;

import edu.ntudp.Molchanov.L2.model.Group;
import edu.ntudp.Molchanov.L2.model.Student;

public class GroupPrinter {
    public static void print(Group group) {
        System.out.println(group.toString());
        System.out.println("Number of students: " + group.getStudents().size());
        for (Student student : group.getStudents()) {
            System.out.println("  - " + student);
        }
    }
}
