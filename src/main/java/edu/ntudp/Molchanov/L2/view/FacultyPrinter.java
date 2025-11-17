package edu.ntudp.Molchanov.L2.view;

import edu.ntudp.Molchanov.L2.model.Faculty;
import edu.ntudp.Molchanov.L2.model.Department;

public class FacultyPrinter {
    public static void print(Faculty faculty) {
        System.out.println(faculty.toString());
        System.out.println("Number of departments: " + faculty.getDepartments().size());
        for (Department dept : faculty.getDepartments()) {
            System.out.println("  - " + dept.getName());
        }
    }
}
