package domain;

import domain.exception.InvalidRobotSpecificationException;

public class AquaticRobot extends Robot {

    public enum Propulsion {PROPELLER, JET}

    private final int maxDepth;
    private final Propulsion propulsion;

    public AquaticRobot(String name,
                        String manufacturer,
                        int manufacturingYear,
                        Propulsion propulsion,
                        int maxDepth) {

        super(name, manufacturer, manufacturingYear);

        if (maxDepth <= 0) {
            throw new InvalidRobotSpecificationException(
                    "Max depth must be greater than zero"
            );
        }

        if (propulsion == null) {
            throw new InvalidRobotSpecificationException(
                    "Propulsion type cannot be null"
            );
        }

        this.propulsion = propulsion;
        this.maxDepth = maxDepth;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public Propulsion getPropulsion() {
        return propulsion;
    }

    @Override
    public String getTechnicalDescription() {
        return getName() +
                " reaches a depth of " + maxDepth +
                " m using " + propulsion +
                " propulsion. Manufactured by " +
                getManufacturer() +
                " in " + getManufacturingYear() + ".";
    }
}