package assignment.cars;

import assignment.cars.exception.CarNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Representation of a {@link Car} resource
 *
 * TODO: Ideally {@link CarDetails should be a sub-resource of {@link Car}}
 *
 *
 */
@RestController
@RequestMapping(value = "/api/cars", method = RequestMethod.GET)
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }


    /**
     * Return a list of Car resources.
     *
     * <p>
     * By default the car are sorted based on
     *     -> Make - lexicographically
     *     -> RRP  - asc
     * </p>
     * @param query partial or complete make/model query string
     * @return a list of {@link Car}
     * @throws Exception throws a 500 Server Error for an unexpected error.
     */
    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    public List<CarResponse> getCarList(@RequestParam String query) throws Exception {
        return carService.getCarList(query)
                .stream()
                .map(CarResponse::new)
                .collect(Collectors.toList());
    }

    /**
     * Retrun a specific car details resource based on the path param - ID.
     *
     * @param id the id of the car/car details resource
     * @return a {@link CarDetails} resource
     * @throws Exception throws a 500 Server Error for an unexpected error.
     * @throws CarNotFoundException when an invalid id is used to get car details
     */
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public CarDetailsResponse getCarDetails(@PathVariable Integer id) throws Exception {
        return new CarDetailsResponse(carService.getCarDetails(id));
    }

    /**
     * Handler to handle {@link CarNotFoundException}, this can be better written using @ControllerAdvice
     * @param carNotFoundException
     * @return HTTP status code 400 - BadRequest with error message.
     */
    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody String handleCarNotFoundException(CarNotFoundException carNotFoundException) {
        return "Car not found";
        //TODO: externalize strings to a properties file or service.
    }

}
