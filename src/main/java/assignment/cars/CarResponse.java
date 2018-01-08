package assignment.cars;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A wrapper around {@link Car} for JSON serialization.
 */
@JsonSerialize
public class CarResponse {
    private Integer id;
    private String makeName;
    private String modelName;
    private Integer rrp;

    CarResponse(Car car) {
        this.id = car.getId();
        this.makeName = car.getMakeName();
        this.modelName = car.getModelName();
        this.rrp = car.getRrp();
    }

    public Integer getId() {
        return id;
    }

    public CarResponse setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getMakeName() {
        return makeName;
    }

    public CarResponse setMakeName(String makeName) {
        this.makeName = makeName;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public CarResponse setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Integer getRrp() {
        return rrp;
    }

    public CarResponse setRrp(Integer rrp) {
        this.rrp = rrp;
        return this;
    }
}
