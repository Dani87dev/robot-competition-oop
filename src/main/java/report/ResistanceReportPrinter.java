package report;

import domain.ResistanceEvaluable;

import java.util.List;

public class ResistanceReportPrinter {

    public void printReport(List<ResistanceEvaluable> robots) {
        System.out.println("=== Resistance Competition Reports ===");

        for (ResistanceEvaluable robot : robots) {
            System.out.println(robot.getResistanceReport());
            System.out.println();
        }
    }
}