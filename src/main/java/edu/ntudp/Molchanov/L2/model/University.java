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

    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String getUnitType() {
        return "University";
    }

    @Override
    public String toString() {
        return super.toString() + ", Faculties: " + faculties.size();
    }
}

