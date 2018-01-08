package assignment.cars;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarTest {

    @Test
    public void testCar() {
        Car car = new Car(10001, "Lamborghini", "Huracan", 20000);
        assertThat(car.getMakeName(), is("Lamborghini"));
        assertThat(car.getModelName(), is("Huracan"));
        assertThat(car.getRrp(), is(20000));
    }
}
