package assignment.cars.exception;

/**
 * This exception is thrown when an invalid car id is used to get the car details.
 *
 * This is a compile time exception and needs to be explicitly handled by the caller.
 */
public class CarNotFoundException extends Exception {


    public CarNotFoundException(String message) {
        super(message);
    }
}
