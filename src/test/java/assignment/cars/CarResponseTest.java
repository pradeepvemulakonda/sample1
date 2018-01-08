package assignment.cars;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarResponseTest {

    @Test
    public void testCarResponse() {
        Car car = new Car(1001, "Ford", "Falcon", 20000);
        CarResponse carResponse = new CarResponse(car);
        assertThat(carResponse.getId(), is(car.getId()));
        assertThat(carResponse.getMakeName(), is(car.getMakeName()));
        assertThat(carResponse.getModelName(), is(car.getModelName()));
        assertThat(carResponse.getRrp(), is(car.getRrp()));
    }
}
