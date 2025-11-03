package edu.ntudp.Molchanov.L2.controller;

import edu.ntudp.Molchanov.L2.model.Group;
import edu.ntudp.Molchanov.L2.model.Human;
import edu.ntudp.Molchanov.L2.model.Student;
import java.util.List;

public class GroupCreator implements Creator<Group> {
    private String name;
    private Human head;
    private List<StudentCreator> studentCreators;

    public GroupCreator(String name, Human head, List<StudentCreator> studentCreators) {
        this.name = name;
        this.head = head;
        this.studentCreators = studentCreators;
    }

    @Override
    public Group create() {
        Group group = new Group(name, head);

        if (studentCreators != null) {
            for (StudentCreator creator : studentCreators) {
                Student student = creator.create();
                group.addStudent(student);
            }
        }

        return group;
    }
}