package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroundRobotTest {

    @Test
    void shouldBeEligibleWhenUsingTracks() {

        GroundRobot robot = new GroundRobot(
                "TankBot",
                "RoboCorp",
                2022,
                40,
                GroundRobot.Traction.TRACKS
        );

        String report = robot.getResistanceReport();

        assertTrue(report.contains("Eligible"));
    }

    @Test
    void shouldNotBeEligibleWhenUsingWheels() {

        GroundRobot robot = new GroundRobot(
                "SpeedBot",
                "RoboCorp",
                2022,
                60,
                GroundRobot.Traction.WHEELS
        );

        String report = robot.getResistanceReport();

        assertTrue(report.contains("Not eligible"));
    }
}