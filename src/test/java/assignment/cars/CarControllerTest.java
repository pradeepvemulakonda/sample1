package assignment.cars;

import assignment.cars.exception.CarNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class CarControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    public void testGetCarList() throws Exception {
        Car fordFalcon = new Car(10001, "Ford", "Falcon", 20000);
        Car ferrariFf = new Car(10002, "Ferrari", "FF", 100000);

        List<Car> cars = new ArrayList<>();
        cars.add(fordFalcon);
        cars.add(ferrariFf);

        when(carService.getCarList("f")).thenReturn(cars);

        MvcResult result = mockMvc.perform(get("/api/cars?query=f")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        verify(carService).getCarList("f");

        ObjectMapper objectMapper = new ObjectMapper();

        assertEquals(objectMapper.writeValueAsString(cars), result.getResponse().getContentAsString());
    }

    @Test
    public void testGetCarDetails() throws Exception {

        CarDetails ford = new CarDetails(
                10001,
                Arrays.asList("UTE", "SEDAN"),
                Arrays.asList("AUTO", "MANUAL"),
                Arrays.asList("UNLEADED PETROL", "LIQUID PETROLEUM GAS")
        );

        when(carService.getCarDetails(10001)).thenReturn(ford);

        MvcResult result = mockMvc.perform(get("/api/cars/10001")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        verify(carService).getCarDetails(10001);

        ObjectMapper objectMapper = new ObjectMapper();

        assertEquals(objectMapper.writeValueAsString(ford), result.getResponse().getContentAsString());
    }

    @Test
    public void testGetCarDetailsWithInvalidId() throws Exception {

        when(carService.getCarDetails(123)).thenThrow(new CarNotFoundException("Car not found"));

        MvcResult result = mockMvc.perform(get("/api/cars/123")
                .accept("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();

        verify(carService).getCarDetails(123);

        ObjectMapper objectMapper = new ObjectMapper();

        assertEquals("Car not found", result.getResponse().getContentAsString());
    }

}
