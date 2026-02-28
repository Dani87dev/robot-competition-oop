package domain;

import domain.value.FlightAutonomy;
import domain.exception.InvalidRobotSpecificationException;

public class RobotAereo extends Robot implements ResistanceEvaluable {

    private final int maxAltitude;
    private final FlightAutonomy autonomy;

    public RobotAereo(String name,
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

    @Override
    public String getTechnicalDescription() {
        return getName() +
                " flies up to " + maxAltitude +
                " m for " + autonomy.getMinutes() +
                " minutes. Manufactured in " +
                getManufacturingYear() +
                " by " + getManufacturer() + ".";
    }

    public FlightAutonomy getAutonomy() {
        return autonomy;
    }

    @Override
    public String getResistanceReport() {

        String status = autonomy.isEligible()
                ? "Eligible for competition"
                : "Not eligible for competition";

        return getName() +
                ": autonomy of " +
                autonomy.getMinutes() +
                " minutes. " + status;
    }
}