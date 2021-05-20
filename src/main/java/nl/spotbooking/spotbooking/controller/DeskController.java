package nl.spotbooking.spotbooking.controller;


import nl.spotbooking.spotbooking.exception.RecordNotFoundException;
import nl.spotbooking.spotbooking.model.Desk;
import nl.spotbooking.spotbooking.service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeskController {

    @Autowired
    private DeskService deskService;

    @CrossOrigin
    @GetMapping(value="/desk")
    public ResponseEntity<Object> getDesks() {
        List<Desk> desks = deskService.getAllDesk();
        return new ResponseEntity<>(desks, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value="/desk/{id}")
    public ResponseEntity<Object> getDesk(@PathVariable("id") long id){
        return new ResponseEntity<>(deskService.getDesk(id),HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(value="/desk")
    public ResponseEntity<Object> createDesk(@RequestBody Desk desk){
        deskService.save(desk);
        return new ResponseEntity<>("Desk Created",HttpStatus.CREATED);
    }
    @CrossOrigin
    @DeleteMapping (value="/desk/{id}")
    public ResponseEntity<Object> deleteDesk(@PathVariable("id") long id){
        deskService.deleteById(id);
        return new ResponseEntity<>("Desk deleted", HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping(value = "/desk/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable("id") long id, @RequestBody Desk desk) {
        deskService.updateDesk(id, desk);
        return new ResponseEntity<>("Desk updated", HttpStatus.OK);
    }

}
