package edu.ntudp.Molchanov.L2.controller;


import edu.ntudp.Molchanov.L2.model.Department;
import edu.ntudp.Molchanov.L2.model.Human;
import edu.ntudp.Molchanov.L2.model.Group;
import java.util.List;

public class DepartmentCreator implements Creator<Department> {
    private String name;
    private Human head;
    private List<GroupCreator> groupCreators;

    public DepartmentCreator(String name, Human head, List<GroupCreator> groupCreators) {
        this.name = name;
        this.head = head;
        this.groupCreators = groupCreators;
    }

    @Override
    public Department create() {
        Department department = new Department(name, head);

        if (groupCreators != null) {
            for (GroupCreator creator : groupCreators) {
                Group group = creator.create();
                department.addGroup(group);
            }
        }

        return department;
    }
}


