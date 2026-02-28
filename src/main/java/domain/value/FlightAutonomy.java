package domain.value;

import domain.exception.InvalidRobotSpecificationException;

public final class FlightAutonomy {

    private final int minutes;

    public FlightAutonomy(int minutes) {
        if (minutes <= 0) {
            throw new InvalidRobotSpecificationException(
                    "Autonomy must be greater than zero"
            );
        }
        this.minutes = minutes;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isEligible() {
        return minutes >= 60;
    }
}