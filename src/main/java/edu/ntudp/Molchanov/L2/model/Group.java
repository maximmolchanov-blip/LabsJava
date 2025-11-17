package edu.ntudp.Molchanov.L2.model;

import java.util.ArrayList;
import java.util.List;

public class Group extends OrganizationalUnit {
    private List<Student> students;

    public Group(String name, Human head) {
        super(name, head);
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String getUnitType() {
        return "Group";
    }
}