package domain.exception;

public class InvalidRobotSpecificationException extends RuntimeException {

    public InvalidRobotSpecificationException(String message) {
        super(message);
    }
}