package domain;

import domain.value.FlightAutonomy;
import domain.exception.InvalidRobotSpecificationException;

public class AerialRobot extends Robot implements ResistanceEvaluable {

    private final int maxAltitude;
    private final FlightAutonomy autonomy;

    public AerialRobot(String name,
                       String manufacturer,
                       int manufacturingYear,
                       int maxAltitude,
                       int autonomyMinutes) {

        super(name, manufacturer, manufacturingYear);

        if (maxAltitude <= 0) {
            throw new InvalidRobotSpecificationException(
                    "Max altitude must be greater than zero"
            );
        }

        this.maxAltitude = maxAltitude;
        this.autonomy = new FlightAutonomy(autonomyMinutes);
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public FlightAutonomy getAutonomy() {
        return autonomy;
    }

    @Override
    public String getTechnicalDescription() {
        return getName() +
                " flies up to " + maxAltitude +
                " m for " + autonomy.getMinutes() +
                " minutes. Manufactured in " +
                getManufacturingYear() +
                " by " + getManufacturer() + ".";
    }

    @Override
    public String getResistanceReport() {

        String result = autonomy.isEligible()
                ? "Eligible for competition"
                : "Not eligible for competition";

        return getName() +
                ": autonomy of " +
                autonomy.getMinutes() +
                " minutes. " + result;
    }
}