package service;

import domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class RobotService {

    private final List<Robot> robots;

    public RobotService(List<Robot> robots) {
        this.robots = robots;
    }

    public List<String> getAllTechnicalDescriptions() {
        return robots.stream()
                .map(Robot::getTechnicalDescription)
                .toList();
    }

    public List<GroundRobot> filterGroundRobotsBySpeed(int minSpeed) {
        return robots.stream()
                .filter(r -> r instanceof GroundRobot)
                .map(r -> (GroundRobot) r)
                .filter(r -> r.getMaxSpeed() > minSpeed)
                .toList();
    }

    public List<Robot> findByManufacturer(String manufacturer) {
        return robots.stream()
                .filter(r -> r.getManufacturer().equalsIgnoreCase(manufacturer))
                .toList();
    }

    public List<ResistanceEvaluable> getResistanceCandidates() {
        return robots.stream()
                .filter(r -> r instanceof ResistanceEvaluable)
                .map(r -> (ResistanceEvaluable) r)
                .toList();
    }
}