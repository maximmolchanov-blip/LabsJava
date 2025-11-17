package edu.ntudp.Molchanov.L2.model;

public class Student extends Human {
    private String studentId;

    public Student(String firstName, String lastName, String patronymic, Sex sex, String studentId) {
        super(firstName, lastName, patronymic, sex);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString() + ", ID: " + studentId;
    }
}