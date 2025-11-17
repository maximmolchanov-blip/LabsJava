package edu.ntudp.Molchanov.L2.controller;
import edu.ntudp.Molchanov.L2.model.Student;
import edu.ntudp.Molchanov.L2.model.Sex;
import java.util.ArrayList;
import java.util.List;

public class StudentCreator extends BaseCreator<Student> {
    private static int studentCounter = 1;

    public Student createStudent(String firstName, String lastName, String patronymic, Sex sex) {
        String studentId = generateId("STD", studentCounter++);
        return new Student(firstName, lastName, patronymic, sex, studentId);
    }

    @Override
    public Student create() {
        return createStudent("John", "Doe", "Smith", Sex.MALE);
    }

    public List<Student> createMultipleStudents(int count) {
        List<Student> students = new ArrayList<>();
        String[][] names = {
                {"Alex", "Petrenko", "Volodymyrovych", "MALE"},
                {"Maria", "Kovalenko", "Petrivna", "FEMALE"},
                {"Andrew", "Sydorenko", "Olexandrovych", "MALE"},
                {"Elena", "Shevchenko", "Ivanivna", "FEMALE"},
                {"Dmytro", "Melnyk", "Serhiyovych", "MALE"},
                {"Anastasia", "Bondarenko", "Volodymyrivna", "FEMALE"},
                {"Maxim", "Tkachenko", "Andriyovych", "MALE"},
                {"Victoria", "Kravchenko", "Olexandrivna", "FEMALE"}
        };

        for (int i = 0; i < count; i++) {
            String[] nameData = names[i % names.length];
            Sex sex = nameData[3].equals("MALE") ? Sex.MALE : Sex.FEMALE;
            students.add(createStudent(nameData[0], nameData[1], nameData[2], sex));
        }
        return students;
    }
}
