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

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String getUnitType() {
        return "Group";
    }

    @Override
    public String toString() {
        return super.toString() + ", Students: " + students.size();
    }
}