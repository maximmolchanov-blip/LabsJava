package edu.ntudp.Molchanov.L2.controller;

import edu.ntudp.Molchanov.L2.model.Faculty;
import edu.ntudp.Molchanov.L2.model.Human;
import edu.ntudp.Molchanov.L2.model.Department;
import java.util.List;

public class FacultyCreator implements Creator<Faculty> {
    private String name;
    private Human head;
    private List<DepartmentCreator> departmentCreators;

    public FacultyCreator(String name, Human head, List<DepartmentCreator> departmentCreators) {
        this.name = name;
        this.head = head;
        this.departmentCreators = departmentCreators;
    }

    @Override
    public Faculty create() {
        Faculty faculty = new Faculty(name, head);

        if (departmentCreators != null) {
            for (DepartmentCreator creator : departmentCreators) {
                Department department = creator.create();
                faculty.addDepartment(department);
            }
        }

        return faculty;
    }
}