package service;

import domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RobotServiceTest {

    @Test
    void shouldFindRobotsByManufacturerIgnoringCase() {

        Robot r1 = new GroundRobot(
                "TankBot",
                "RoboCorp",
                2022,
                40,
                GroundRobot.Traction.TRACKS
        );

        Robot r2 = new AerialRobot(
                "SkyX",
                "AeroDynamics",
                2023,
                3000,
                75
        );

        RobotService service = new RobotService(List.of(r1, r2));

        List<Robot> result = service.findByManufacturer("robocorp");

        assertEquals(1, result.size());
        assertEquals("TankBot", result.get(0).getName());
    }

    @Test
    void shouldFilterGroundRobotsBySpeed() {

        Robot slow = new GroundRobot(
                "SlowBot",
                "RoboCorp",
                2022,
                20,
                GroundRobot.Traction.TRACKS
        );

        Robot fast = new GroundRobot(
                "FastBot",
                "RoboCorp",
                2022,
                80,
                GroundRobot.Traction.TRACKS
        );

        RobotService service = new RobotService(List.of(slow, fast));

        List<GroundRobot> result = service.filterGroundRobotsBySpeed(50);

        assertEquals(1, result.size());
        assertEquals("FastBot", result.get(0).getName());
    }
}