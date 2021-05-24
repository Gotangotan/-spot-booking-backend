package nl.spotbooking.spotbooking.controller;

import nl.spotbooking.spotbooking.model.Date;

import nl.spotbooking.spotbooking.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DateController {

    @Autowired
    private DateService dateService;

    @CrossOrigin
    @GetMapping(value = "/date")
    public ResponseEntity<Object> getDates() {
        List<Date> dates = dateService.getAllDates();
        return new ResponseEntity<>(dates, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/date/{id}")
    public ResponseEntity<Object> getDate(@PathVariable("id") long id) {
        return new ResponseEntity<>(dateService.getDate(id), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/date")
    public ResponseEntity<Object> createDate(@RequestBody Date date) {
        dateService.save(date);
        return new ResponseEntity<>("Date Created", HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/date/{id}")
    public ResponseEntity<Object> deleteDate(@PathVariable("id") long id) {
        dateService.deleteById(id);
        return new ResponseEntity<>("Date deleted", HttpStatus.OK);
    }

}
