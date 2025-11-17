package edu.ntudp.Molchanov.L2.model;

import java.util.ArrayList;
import java.util.List;

public class University extends OrganizationalUnit {
    private List<Faculty> faculties;

    public University(String name, Human head) {
        super(name, head);
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public String getUnitType() {
        return "University";
    }
}
