package edu.ntudp.Molchanov.L2.model;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrganizationalUnit {
    private List<Group> groups;

    public Department(String name, Human head) {
        super(name, head);
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String getUnitType() {
        return "Department";
    }

}
