package pl.tk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tk.model.Car;
import pl.tk.repository.CarRepository;

import java.util.List;

/**
 * Created by Tobiasz on 2017-05-22.
 */

@RestController
public class CarRestController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/cars/{id}")
    ResponseEntity<?> getCarById(@PathVariable("id") Long id){
        Car car = carRepository.findOne(id);
        if (car == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cars")
    public ResponseEntity<List<Car>> listAllCars(){
        List<Car> cars = carRepository.findAll();
        if(cars.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cars")
    public ResponseEntity<?> addCar(@RequestBody Car car){
        carRepository.save(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cars/{id}")
    public ResponseEntity<?> updateCar(@PathVariable("id") Long id, @RequestBody Car car){
        Car currentCar = carRepository.findOne(id);
        if(currentCar == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentCar.setBrand(car.getBrand());
        currentCar.setModel(car.getModel());
        currentCar.setSeats(car.getSeats());
        carRepository.save(currentCar);

        return new ResponseEntity<>(currentCar, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id){
        Car currentCar = carRepository.findOne(id);
        if(currentCar == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        carRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/cars")
    public ResponseEntity<?> deleteAllCars(){
        carRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
