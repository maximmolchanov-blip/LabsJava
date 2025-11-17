package edu.ntudp.Molchanov.L2.view;

import edu.ntudp.Molchanov.L2.model.University;
import edu.ntudp.Molchanov.L2.model.Faculty;
import edu.ntudp.Molchanov.L2.model.Department;
import edu.ntudp.Molchanov.L2.model.Group;

public class UniversityPrinter {
    public static void printFullInfo(University university) {
        System.out.println("\n========================================");
        System.out.println(university.toString());
        System.out.println("========================================");

        System.out.println("Number of faculties: " + university.getFaculties().size());

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\n" + faculty);

            for (Department dept : faculty.getDepartments()) {
                System.out.println("  " + dept);

                for (Group group : dept.getGroups()) {
                    System.out.println("    " + group);
                }
            }
        }

        System.out.println("========================================\n");
    }

    public static void printStatistics(University university) {
        System.out.println("\n=== Statistics ===");

        int totalFaculties = university.getFaculties().size();
        int totalDepartments = 0;
        int totalGroups = 0;
        int totalStudents = 0;

        for (Faculty faculty : university.getFaculties()) {
            totalDepartments += faculty.getDepartments().size();

            for (Department dept : faculty.getDepartments()) {
                totalGroups += dept.getGroups().size();

                for (Group group : dept.getGroups()) {
                    totalStudents += group.getStudents().size();
                }
            }
        }

        System.out.println("Total faculties: " + totalFaculties);
        System.out.println("Total departments: " + totalDepartments);
        System.out.println("Total groups: " + totalGroups);
        System.out.println("Total students: " + totalStudents);
    }
}

