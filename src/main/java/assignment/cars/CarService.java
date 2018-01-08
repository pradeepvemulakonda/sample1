package assignment.cars;

import assignment.cars.exception.CarNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * This service provides following functionality:
 *    <ol>
 *        <li>Search for a list of cards based on make or model(including partial query strings)</li>
 *        <li>For a specific car, fetch additional details based on car identifier</li>
 *    </ol>
 *
 *    The service method {@link CarService#getCarDetails(Integer)} throws a {@link CarNotFoundException} is the
 *    Car ID is not in the persistent store.
 *
 */
@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();
    private List<CarDetails> carDetails = new ArrayList<>();

    public CarService() {
        cars.add(new Car(10001, "Ford", "Falcon", 29890));
        cars.add(new Car(10002, "Ford", "Fiesta", 15825));
        cars.add(new Car(10003, "Ford", "Focus", 23390));
        cars.add(new Car(10004, "Ferrari", "FF", 624646));

        carDetails.add(new CarDetails(
                10001,
                Arrays.asList("UTE", "SEDAN"),
                Arrays.asList("AUTO", "MANUAL"),
                Arrays.asList("UNLEADED PETROL", "LIQUID PETROLEUM GAS")
        ));

        carDetails.add(new CarDetails(
                10002,
                Collections.singletonList("HATCH"),
                Arrays.asList("AUTO", "MANUAL"),
                Collections.singletonList("UNLEADED PETROL")
        ));

        carDetails.add(new CarDetails(
                10003,
                Arrays.asList("HATCH", "SEDAN"),
                Arrays.asList("AUTO", "MANUAL"),
                Arrays.asList("UNLEADED PETROL", "PREMIUM UNLEADED PETROL")
        ));

        carDetails.add(new CarDetails(
                10004,
                Arrays.asList("COUPE"),
                Arrays.asList("AUTO"),
                Arrays.asList("PREMIUM UNLEADED PETROL")
        ));
    }

    /**
     * Return a list of cars based on partial/full Model/Make query.
     *
     * @param query Make or Model string full or partial.
     * @return a List of {@link Car}
     */
    List<Car> getCarList(String query) {

        // HINT: Task 1

        return cars.stream()
                .filter((car) -> car.getMakeName().toLowerCase().contains(query.toLowerCase()) ||
                        car.getModelName().toLowerCase().contains(query.toLowerCase()))
                .sorted(Comparator.comparing(Car::getMakeName,
                     String.CASE_INSENSITIVE_ORDER)
                     .thenComparingInt(Car::getRrp))
                .collect(Collectors.toList());
    }


    /**
     * Return a detailed Car view based car ID provided.
     *
     * @param id the Car ID.
     * @return {@link CarDetails}
     * @throws CarNotFoundException when the supplied id is not found in the persistent store.
     */
    CarDetails getCarDetails(Integer id) throws CarNotFoundException {

        // HINT: Task 2
        // We have a unique identifier and a list of carDetails
        return carDetails.stream()
             .filter(carDetail -> carDetail.getId().equals(id))
             .findFirst()
                .orElseThrow(()->new CarNotFoundException("Car not found"));
    }
}
