package app;

import domain.*;
import service.RobotService;
import report.ResistanceReportPrinter;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        List<Robot> robots = List.of(
                new GroundRobot("TankBot", "RoboCorp", 2022, 40, GroundRobot.Traction.TRACKS),
                new AerialRobot("SkyX-1", "AeroDynamics", 2023, 3000, 75),
                new AquaticRobot("AquaRunner", "AquaTech", 2021, AquaticRobot.Propulsion.PROPELLER, 500)
        );

        RobotService service = new RobotService(robots);

        // 1️⃣ Technical descriptions
        service.getAllTechnicalDescriptions()
                .forEach(System.out::println);

        System.out.println();

        // 2️⃣ Resistance competition
        ResistanceReportPrinter printer = new ResistanceReportPrinter();
        printer.printReport(service.getResistanceCandidates());
    }
}