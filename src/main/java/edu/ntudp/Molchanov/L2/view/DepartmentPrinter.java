package edu.ntudp.Molchanov.L2.view;

import edu.ntudp.Molchanov.L2.model.Department;
import edu.ntudp.Molchanov.L2.model.Group;

public class DepartmentPrinter {
    public static void print(Department department) {
        System.out.println(department.toString());
        System.out.println("Number of groups: " + department.getGroups().size());
        for (Group group : department.getGroups()) {
            System.out.println("  - " + group.getName());
        }
    }
}

