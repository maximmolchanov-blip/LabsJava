package edu.ntudp.Molchanov.L2.model;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends OrganizationalUnit {
    private List<Department> departments;

    public Faculty(String name, Human head) {
        super(name, head);
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    @Override
    public String getUnitType() {
        return "Faculty";
    }

}
