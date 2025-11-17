package edu.ntudp.Molchanov.L2.controller;

import edu.ntudp.Molchanov.L2.model.University;
import edu.ntudp.Molchanov.L2.model.Faculty;
import edu.ntudp.Molchanov.L2.model.Human;
import edu.ntudp.Molchanov.L2.model.Sex;

public class UniversityCreator extends BaseCreator<University> {
    private FacultyCreator facultyCreator;

    public UniversityCreator() {
        this.facultyCreator = new FacultyCreator();
    }

    public University createTypicalUniversity() {
        // Create rector
        Human rector = new Human("Volodymyr", "Rektorenko", "Rektorovych", Sex.MALE);

        // Create university
        University university = new University(
                "Oles Honchar Dnipro National University",
                rector
        );

        // Create Faculty of Applied Mathematics
        Human deanMath = new Human("Alexander", "Mathematician", "Alexandrovych", Sex.MALE);
        String[][] mathDepartments = {
                {"Department of Software Engineering", "SE-21", "SE-22", "SE-23"},
                {"Department of Applied Mathematics", "AM-21", "AM-22"}
        };
        Faculty mathFaculty = facultyCreator.createFaculty(
                "Faculty of Applied Mathematics",
                deanMath,
                mathDepartments
        );
        university.addFaculty(mathFaculty);

        // Create Faculty of Physics
        Human deanPhys = new Human("Natalia", "Physicist", "Vasylivna", Sex.FEMALE);
        String[][] physDepartments = {
                {"Department of Theoretical Physics", "TP-21", "TP-22"},
                {"Department of Experimental Physics", "EP-21"}
        };
        Faculty physFaculty = facultyCreator.createFaculty(
                "Faculty of Physics",
                deanPhys,
                physDepartments
        );
        university.addFaculty(physFaculty);

        // Create Faculty of Economics
        Human deanEcon = new Human("Iryna", "Ekonomova", "Mykhailivna", Sex.FEMALE);
        String[][] econDepartments = {
                {"Department of Economic Theory", "EC-21", "EC-22"},
                {"Department of Finance", "FIN-21"}
        };
        Faculty econFaculty = facultyCreator.createFaculty(
                "Faculty of Economics",
                deanEcon,
                econDepartments
        );
        university.addFaculty(econFaculty);

        return university;
    }

    @Override
    public University create() {
        return createTypicalUniversity();
    }
}