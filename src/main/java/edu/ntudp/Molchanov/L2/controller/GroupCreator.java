package edu.ntudp.Molchanov.L2.controller;

import edu.ntudp.Molchanov.L2.model.Group;
import edu.ntudp.Molchanov.L2.model.Human;
import edu.ntudp.Molchanov.L2.model.Student;
import edu.ntudp.Molchanov.L2.model.Sex;
import java.util.List;

public class GroupCreator extends BaseCreator<Group> {
    private StudentCreator studentCreator;

    public GroupCreator() {
        this.studentCreator = new StudentCreator();
    }

    public Group createGroup(String name, Human head, int studentCount) {
        Group group = new Group(name, head);
        List<Student> students = studentCreator.createMultipleStudents(studentCount);
        for (Student student : students) {
            group.addStudent(student);
        }
        return group;
    }

    public Group createGroup(String name, int studentCount) {
        Human head = new Human("Leader", "Of Group", name, Sex.MALE);
        return createGroup(name, head, studentCount);
    }

    @Override
    public Group create() {
        Human head = new Human("Taras", "Tarasenko", "Tarasovych", Sex.MALE);
        return createGroup("CS-01", head, 5);
    }
}
