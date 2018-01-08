package assignment.cars;

import java.util.List;

/**
 * Representation of Car Details.
 *
 * For a summary of car detail {@link Car}
 *
 * @since 1.0
 *
 */
public class CarDetails {
    private Integer id;
    private List<String> bodyTypes;
    private List<String> transmissionTypes;
    private List<String> fuelTypes;

    public CarDetails(Integer id, List<String> bodyTypes, List<String> transmissionTypes, List<String> fuelTypes) {
        this.id = id;
        this.bodyTypes = bodyTypes;
        this.transmissionTypes = transmissionTypes;
        this.fuelTypes = fuelTypes;
    }

    /**
     * Returns the unique car/car detail identifier
     * @return the resource identifier
     */
    public Integer getId() {
        return id;
    }

    public CarDetails setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the list of body types available for the car,
     * example: WAGON, COUPE
     * @return list of car body types
     */
    public List<String> getBodyTypes() {
        return bodyTypes;
    }

    public CarDetails setBodyTypes(List<String> bodyTypes) {
        this.bodyTypes = bodyTypes;
        return this;
    }

    /**
     * Reurns the list of transmission types available for the car,
     * example: AUTO, MANUAL, SPORTS AUTO
     * @return list of car transmission types
     */
    public List<String> getTransmissionTypes() {
        return transmissionTypes;
    }

    public CarDetails setTransmissionTypes(List<String> transmissionTypes) {
        this.transmissionTypes = transmissionTypes;
        return this;
    }

    /**
     * Reurns the list of fuel types available for the car,
     * example: UNLEADED PETROL, DIESEL
     * @return list of car fuel types
     */
    public List<String> getFuelTypes() {
        return fuelTypes;
    }

    public CarDetails setFuelTypes(List<String> fuelTypes) {
        this.fuelTypes = fuelTypes;
        return this;
    }
}
