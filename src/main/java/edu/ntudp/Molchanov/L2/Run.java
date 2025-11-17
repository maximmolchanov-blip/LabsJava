package edu.ntudp.Molchanov.L2;

import edu.ntudp.Molchanov.L2.controller.UniversityCreator;
import edu.ntudp.Molchanov.L2.model.University;
import edu.ntudp.Molchanov.L2.view.UniversityPrinter;


public class Run {
    public static void main(String[] args) {

        System.out.println("=== University Management System ===\n");

        UniversityCreator creator = new UniversityCreator();
        University university = creator.createTypicalUniversity();

        UniversityPrinter.printFullInfo(university);
        UniversityPrinter.printStatistics(university);
        UniversityPrinter. printAllStudentsCompact(university);
    }
}
