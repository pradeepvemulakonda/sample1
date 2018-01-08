package assignment.cars;

/**
 * Representation of a car with only summary fields.
 *
 * For detailed car description {@link CarDetails}
 *
 * @since 1.0
 *
 */
public class Car {

    private Integer id;
    private String makeName;
    private String modelName;
    private Integer rrp;

    public Car(Integer id, String makeName, String modelName, Integer rrp) {
        this.id = id;
        this.makeName = makeName;
        this.modelName = modelName;
        this.rrp = rrp;
    }

    /**
     * Returns the unique car identifier
     * @return the resource identifier
     */
    public Integer getId() {
        return id;
    }

    public Car setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Reurns the Make of the car, example: Toyota
     * @return the make of the car
     */
    public String getMakeName() {
        return makeName;
    }

    public Car setMakeName(String makeName) {
        this.makeName = makeName;
        return this;
    }

    /**
     * Returns the model of the car.
     * @return the model related to the make specified above.
     */
    public String getModelName() {
        return modelName;
    }

    public Car setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    /**
     * Return the RRP of the car.
     * TODO: Type should be {@link java.math.BigDecimal}
     * @return returned the retail price of the car
     */
    public Integer getRrp() {
        return rrp;
    }

    public Car setRrp(Integer rrp) {
        this.rrp = rrp;
        return this;
    }
}
