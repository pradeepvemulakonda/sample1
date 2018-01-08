package assignment.cars;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * A wrapper around {@link CarDetails} for serialization into JSON.
 */
@JsonSerialize
public class CarDetailsResponse {
    private Integer id;
    private List<String> bodyTypes;
    private List<String> transmissionTypes;
    private List<String> fuelTypes;

    CarDetailsResponse(CarDetails carDetails) {
        this.id = carDetails.getId();
        this.bodyTypes = carDetails.getBodyTypes();
        this.transmissionTypes = carDetails.getTransmissionTypes();
        this.fuelTypes = carDetails.getFuelTypes();
    }

    public Integer getId() {
        return id;
    }

    public CarDetailsResponse setId(Integer id) {
        this.id = id;
        return this;
    }

    public List<String> getBodyTypes() {
        return bodyTypes;
    }

    public CarDetailsResponse setBodyTypes(List<String> bodyTypes) {
        this.bodyTypes = bodyTypes;
        return this;
    }

    public List<String> getTransmissionTypes() {
        return transmissionTypes;
    }

    public CarDetailsResponse setTransmissionTypes(List<String> transmissionTypes) {
        this.transmissionTypes = transmissionTypes;
        return this;
    }

    public List<String> getFuelTypes() {
        return fuelTypes;
    }

    public CarDetailsResponse setFuelTypes(List<String> fuelTypes) {
        this.fuelTypes = fuelTypes;
        return this;
    }
}
