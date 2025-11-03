package edu.ntudp.Molchanov.L2.controller;

import edu.ntudp.Molchanov.L2.model.University;
import edu.ntudp.Molchanov.L2.model.Human;
import edu.ntudp.Molchanov.L2.model.Faculty;
import java.util.List;

public class UniversityCreator implements Creator<University> {
    private String name;
    private Human head;
    private List<FacultyCreator> facultyCreators;

    public UniversityCreator(String name, Human head, List<FacultyCreator> facultyCreators) {
        this.name = name;
        this.head = head;
        this.facultyCreators = facultyCreators;
    }

    @Override
    public University create() {
        University university = new University(name, head);

        if (facultyCreators != null) {
            for (FacultyCreator creator : facultyCreators) {
                Faculty faculty = creator.create();
                university.addFaculty(faculty);
            }
        }

        return university;
    }
}