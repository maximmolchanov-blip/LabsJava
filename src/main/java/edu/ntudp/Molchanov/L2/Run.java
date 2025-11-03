package edu.ntudp.Molchanov.L2;

import edu.ntudp.Molchanov.L2.controller.*;
import edu.ntudp.Molchanov.L2.model.*;
import java.util.ArrayList;
import java.util.List;

public class Run {

    public static University createTypicalUniversity() {
        // Create university rector
        Human rector = new Human("Ivan", "Petrenko", "Mykhailovych", Sex.MALE);

        // Create faculty deans
        Human deanIT = new Human("Olena", "Kovalenko", "Petrivna", Sex.FEMALE);
        Human deanEcon = new Human("Mykhailo", "Sydorenko", "Ivanovych", Sex.MALE);

        // Create department heads
        Human headCS = new Human("Petro", "Ivanenko", "Oleksandrovych", Sex.MALE);
        Human headSE = new Human("Maria", "Bondarenko", "Vasylivna", Sex.FEMALE);
        Human headFin = new Human("Andrii", "Melnyk", "Petrovych", Sex.MALE);

        // Create group curators
        Human curatorCS1 = new Human("Viktor", "Shevchenko", "Mykolaiovych", Sex.MALE);
        Human curatorCS2 = new Human("Natalia", "Tkachenko", "Olehivna", Sex.FEMALE);
        Human curatorSE1 = new Human("Oleksii", "Kravchenko", "Vasylovych", Sex.MALE);
        Human curatorFin1 = new Human("Tetiana", "Morozova", "Andriivna", Sex.FEMALE);

        // Create students for group CS-101
        List<StudentCreator> studentsCS1 = new ArrayList<>();
        studentsCS1.add(new StudentCreator("Dmytro", "Lysenko", "Viktorovych", Sex.MALE, "CS101001"));
        studentsCS1.add(new StudentCreator("Anna", "Savchenko", "Serhiivna", Sex.FEMALE, "CS101002"));
        studentsCS1.add(new StudentCreator("Maksym", "Pavlenko", "Ihorovych", Sex.MALE, "CS101003"));

        // Create students for group CS-102
        List<StudentCreator> studentsCS2 = new ArrayList<>();
        studentsCS2.add(new StudentCreator("Kateryna", "Romanenko", "Oleksiivna", Sex.FEMALE, "CS102001"));
        studentsCS2.add(new StudentCreator("Serhii", "Honcharenko", "Vasylovych", Sex.MALE, "CS102002"));

        // Create students for group SE-101
        List<StudentCreator> studentsSE1 = new ArrayList<>();
        studentsSE1.add(new StudentCreator("Oleksandr", "Volkov", "Dmytrovych", Sex.MALE, "SE101001"));
        studentsSE1.add(new StudentCreator("Yulia", "Fedorova", "Mykolaivna", Sex.FEMALE, "SE101002"));
        studentsSE1.add(new StudentCreator("Ihor", "Danylov", "Petrovych", Sex.MALE, "SE101003"));
        studentsSE1.add(new StudentCreator("Viktoria", "Semenova", "Andriivna", Sex.FEMALE, "SE101004"));

        // Create students for group FIN-101
        List<StudentCreator> studentsFin1 = new ArrayList<>();
        studentsFin1.add(new StudentCreator("Roman", "Zakharov", "Olehovych", Sex.MALE, "FIN101001"));
        studentsFin1.add(new StudentCreator("Daryna", "Polishchuk", "Viktorivna", Sex.FEMALE, "FIN101002"));

        // Create groups
        GroupCreator groupCS1 = new GroupCreator("CS-101", curatorCS1, studentsCS1);
        GroupCreator groupCS2 = new GroupCreator("CS-102", curatorCS2, studentsCS2);
        GroupCreator groupSE1 = new GroupCreator("SE-101", curatorSE1, studentsSE1);
        GroupCreator groupFin1 = new GroupCreator("FIN-101", curatorFin1, studentsFin1);

        // Create departments
        List<GroupCreator> groupsCS = new ArrayList<>();
        groupsCS.add(groupCS1);
        groupsCS.add(groupCS2);
        DepartmentCreator deptCS = new DepartmentCreator("Computer Science Department", headCS, groupsCS);

        List<GroupCreator> groupsSE = new ArrayList<>();
        groupsSE.add(groupSE1);
        DepartmentCreator deptSE = new DepartmentCreator("Software Engineering Department", headSE, groupsSE);

        List<GroupCreator> groupsFin = new ArrayList<>();
        groupsFin.add(groupFin1);
        DepartmentCreator deptFin = new DepartmentCreator("Finance Department", headFin, groupsFin);

        // Create faculties
        List<DepartmentCreator> deptsIT = new ArrayList<>();
        deptsIT.add(deptCS);
        deptsIT.add(deptSE);
        FacultyCreator facultyIT = new FacultyCreator("Faculty of Information Technology", deanIT, deptsIT);

        List<DepartmentCreator> deptsEcon = new ArrayList<>();
        deptsEcon.add(deptFin);
        FacultyCreator facultyEcon = new FacultyCreator("Faculty of Economics", deanEcon, deptsEcon);

        // Create university
        List<FacultyCreator> faculties = new ArrayList<>();
        faculties.add(facultyIT);
        faculties.add(facultyEcon);

        UniversityCreator universityCreator = new UniversityCreator(
                "Dnipro National University",
                rector,
                faculties
        );

        return universityCreator.create();
    }

    public static void printUniversityStructure(University university) {
        System.out.println("\n=== UNIVERSITY STRUCTURE ===\n");
        System.out.println(university);
        System.out.println();

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("  " + faculty);

            for (Department department : faculty.getDepartments()) {
                System.out.println("    " + department);

                for (Group group : department.getGroups()) {
                    System.out.println("      " + group);

                    for (Student student : group.getStudents()) {
                        System.out.println("        " + student);
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Creating typical university...");

        University university = createTypicalUniversity();

        printUniversityStructure(university);

        System.out.println("\n=== STATISTICS ===");
        int totalFaculties = university.getFaculties().size();
        int totalDepartments = 0;
        int totalGroups = 0;
        int totalStudents = 0;

        for (Faculty faculty : university.getFaculties()) {
            totalDepartments += faculty.getDepartments().size();
            for (Department department : faculty.getDepartments()) {
                totalGroups += department.getGroups().size();
                for (Group group : department.getGroups()) {
                    totalStudents += group.getStudents().size();
                }
            }
        }

        System.out.println("Faculties: " + totalFaculties);
        System.out.println("Departments: " + totalDepartments);
        System.out.println("Groups: " + totalGroups);
        System.out.println("Students: " + totalStudents);
    }
}