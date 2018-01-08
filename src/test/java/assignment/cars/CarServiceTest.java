package assignment.cars;

import assignment.cars.exception.CarNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Before
    public void setup() {
        carService = new CarService();
    }

    @Test
    public void testGetCarListValidQuery() {
        List<Car> carList = carService.getCarList("f");

        assertThat(carList.get(0).getMakeName(), is("Ferrari"));
        assertThat(carList.get(0).getModelName(), is("FF"));
        assertThat(carList.get(0).getRrp(), is(624646));

        assertThat(carList.get(1).getMakeName(), is("Ford"));
        assertThat(carList.get(1).getModelName(), is("Fiesta"));
        assertThat(carList.get(1).getRrp(), is(15825));

        assertThat(carList.get(2).getMakeName(), is("Ford"));
        assertThat(carList.get(2).getModelName(), is("Focus"));
        assertThat(carList.get(2).getRrp(), is(23390));

        assertThat(carList.get(3).getMakeName(), is("Ford"));
        assertThat(carList.get(3).getModelName(), is("Falcon"));
        assertThat(carList.get(3).getRrp(), is(29890));
    }

    @Test
    public void testGetCarListInvalidQuery() {
        List<Car> carList = carService.getCarList("xyz");
        assertThat(carList.size(), is(0));
    }

    @Test
    public void testGetCarDetailsValidId() throws CarNotFoundException {
        CarDetails carDetails = carService.getCarDetails(10001);
        assertThat(carDetails.getId(), is(10001));
        assertThat(carDetails.getBodyTypes().get(0), is("UTE"));
        assertThat(carDetails.getBodyTypes().get(1), is("SEDAN"));
        assertThat(carDetails.getTransmissionTypes().get(0), is("AUTO"));
        assertThat(carDetails.getTransmissionTypes().get(1), is("MANUAL"));
        assertThat(carDetails.getFuelTypes().get(0), is("UNLEADED PETROL"));
        assertThat(carDetails.getFuelTypes().get(1), is("LIQUID PETROLEUM GAS"));
    }

    @Test(expected=CarNotFoundException.class)
    public void testGetCarDetailsInvalidId() throws CarNotFoundException {
        carService.getCarDetails(123);
        assertFalse(true);
    }

}