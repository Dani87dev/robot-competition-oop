package domain;

import domain.exception.InvalidRobotSpecificationException;
import domain.value.FlightAutonomy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightAutonomyTest {

    @Test
    void shouldThrowExceptionWhenAutonomyIsNegative() {
        assertThrows(InvalidRobotSpecificationException.class,
                () -> new FlightAutonomy(-10));
    }

    @Test
    void shouldBeEligibleWhenAutonomyIs60OrMore() {
        FlightAutonomy autonomy = new FlightAutonomy(75);
        assertTrue(autonomy.isEligible());
    }

    @Test
    void shouldNotBeEligibleWhenAutonomyIsLessThan60() {
        FlightAutonomy autonomy = new FlightAutonomy(45);
        assertFalse(autonomy.isEligible());
    }
}