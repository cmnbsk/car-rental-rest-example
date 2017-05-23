package pl.tk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.tk.model.Rent;
import pl.tk.repository.RentRepository;

import java.util.List;

/**
 * Created by Tobiasz on 2017-05-22.
 */

@RestController
public class RentRestController {

    @Autowired
    private RentRepository rentRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/rents/{id}")
    ResponseEntity<?> getRentById(@PathVariable("id") Long id){
        Rent rent = rentRepository.findOne(id);
        if (rent == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rent, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rents")
    public ResponseEntity<List<Rent>> listAllRents(){
        List<Rent> rents = rentRepository.findAll();
        if(rents.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rents, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rents")
    public ResponseEntity<?> addRent(@RequestBody Rent rent){
        rentRepository.save(rent);
        return new ResponseEntity<>(rent, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/rents/{id}")
    public ResponseEntity<?> updateRent(@PathVariable("id") Long id, @RequestBody Rent rent){
        Rent currentRent = rentRepository.findOne(id);
        if(currentRent == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentRent.setCar(rent.getCar());
        currentRent.setCustomer(rent.getCustomer());
        currentRent.setStartDate(rent.getStartDate());
        currentRent.setEndDate(rent.getEndDate());
        rentRepository.save(currentRent);

        return new ResponseEntity<>(currentRent, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rents/{id}")
    public ResponseEntity<?> deleteRent(@PathVariable("id") Long id){
        Rent currentRent = rentRepository.findOne(id);
        if(currentRent == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        rentRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/rents")
    public ResponseEntity<?> deleteAllRents(){
        rentRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
