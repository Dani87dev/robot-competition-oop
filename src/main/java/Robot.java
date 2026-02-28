package domain;

import domain.exception.InvalidRobotSpecificationException;

import java.time.LocalDate;

public abstract class Robot {

    private final String name;
    private final String manufacturer;
    private final int manufacturingYear;
    private final LocalDate registrationDate;

    protected Robot(String name,
                    String manufacturer,
                    int manufacturingYear) {

        if (name == null || name.isBlank()) {
            throw new InvalidRobotSpecificationException(
                    "Robot name cannot be empty"
            );
        }

        if (manufacturer == null || manufacturer.isBlank()) {
            throw new InvalidRobotSpecificationException(
                    "Manufacturer cannot be empty"
            );
        }

        int currentYear = LocalDate.now().getYear();

        if (manufacturingYear < 1900 || manufacturingYear > currentYear) {
            throw new InvalidRobotSpecificationException(
                    "Invalid manufacturing year"
            );
        }

        this.name = name;
        this.manufacturer = manufacturer;
        this.manufacturingYear = manufacturingYear;
        this.registrationDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public abstract String getTechnicalDescription();
}