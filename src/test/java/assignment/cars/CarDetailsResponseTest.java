package assignment.cars;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarDetailsResponseTest {

    @Test
    public void testCarResponse() {
        CarDetails carDetails = new CarDetails(10004,Collections.singletonList("COUPE"), Collections.singletonList("AUTO"),
                Collections.singletonList("PREMIUM UNLEADED PETROL"));
        CarDetailsResponse carDetailsResponse = new CarDetailsResponse(carDetails);
        assertThat(carDetailsResponse.getId(), is(carDetails.getId()));
        assertThat(carDetailsResponse.getBodyTypes().get(0), is(carDetails.getBodyTypes().get(0)));
        assertThat(carDetailsResponse.getTransmissionTypes().get(0), is(carDetails.getTransmissionTypes().get(0)));
        assertThat(carDetailsResponse.getFuelTypes().get(0), is(carDetails.getFuelTypes().get(0)));
    }
}
