package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AerialRobotTest {

    @Test
    void aerialRobotShouldBeEligibleWhenAutonomyIsAbove60() {

        AerialRobot robot = new AerialRobot(
                "SkyX",
                "AeroDynamics",
                2023,
                3000,
                75
        );

        assertTrue(robot.getResistanceReport().contains("Eligible"));
    }

    @Test
    void aerialRobotShouldNotBeEligibleWhenAutonomyIsBelow60() {

        AerialRobot robot = new AerialRobot(
                "SkyX",
                "AeroDynamics",
                2023,
                3000,
                45
        );

        assertTrue(robot.getResistanceReport().contains("Not eligible"));
    }
}