package assignment.cars;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarDetailsTest {

    @Test
    public void testCarDetails() {
      CarDetails carDetails = new CarDetails(10004, Collections.singletonList("COUPE"), Collections.singletonList("AUTO"),
              Collections.singletonList("PREMIUM UNLEADED PETROL"));
      assertThat(carDetails.getId(), is(carDetails.getId()));
      assertThat(carDetails.getBodyTypes().get(0), is("COUPE"));
      assertThat(carDetails.getTransmissionTypes().get(0), is("AUTO"));
      assertThat(carDetails.getFuelTypes().get(0), is("PREMIUM UNLEADED PETROL"));
    }
}
