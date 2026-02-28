package domain;

import domain.exception.InvalidRobotSpecificationException;

public class GroundRobot extends Robot implements ResistanceEvaluable {

    public enum Traction {WHEELS, TRACKS}

    private final int maxSpeed;
    private final Traction tractionType;

    public GroundRobot(String name, String manufacturer, int manufacturingYear, int maxSpeed, Traction tractionType) {
        super(name, manufacturer, manufacturingYear);

        if (maxSpeed <= 0) {
            throw new InvalidRobotSpecificationException("Max speed must be greater than zero");
        }

        this.maxSpeed = maxSpeed;
        this.tractionType = tractionType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public Traction getTractionType() {
        return tractionType;
    }

    @Override
    public String getTechnicalDescription() {
        return getName() + " manufactured by " + getManufacturer() + " in " + getManufacturingYear() +
                ", uses " + tractionType + " traction and reaches up to " + maxSpeed + " km/h.";
    }

    @Override
    public String getResistanceReport() {
        String result = (tractionType == Traction.TRACKS) ? "Eligible for competition" : "Not eligible for competition";
        return getName() + ": traction " + tractionType + " confirmed. " + result;
    }
}