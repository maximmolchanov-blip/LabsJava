package edu.ntudp.Molchanov.L2.controller;

import edu.ntudp.Molchanov.L2.model.Department;
import edu.ntudp.Molchanov.L2.model.Human;
import edu.ntudp.Molchanov.L2.model.Group;
import edu.ntudp.Molchanov.L2.model.Sex;

import java.util.Objects;

public class DepartmentCreator extends BaseCreator<Department> {
    private GroupCreator groupCreator;

    public DepartmentCreator() {
        this.groupCreator = new GroupCreator();
    }

    public Department createDepartment(String name, Human head, String[] groupNames, int studentsPerGroup) {
        Department department = new Department(name, head);

        for (String groupName : groupNames) {
            Group group = groupCreator.createGroup(groupName, studentsPerGroup);
            department.addGroup(group);
        }

        return department;
    }

    public Department createDepartment(String name, String[] groupNames, int studentsPerGroup) {
        Human head = new Human("Head", "Of Department", name, Sex.MALE);
        return createDepartment(name, head, groupNames, studentsPerGroup);
    }


    @Override
    public Department create() {
        Human head = new Human("Vasyl", "Vasyliev", "Vasylovych", Sex.MALE);
        return createDepartment("Department of Software Engineering", head, new String[]{"SE-01"}, 5);
    }
}