package nl.spotbooking.spotbooking.controller;

import nl.spotbooking.spotbooking.model.Desk;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {

    @CrossOrigin
    @GetMapping(value="/admin")
    public ResponseEntity<Object> getAdmin() {
        return new ResponseEntity<>("SECURED REST endpoint: /admin", HttpStatus.OK);
    }
}
