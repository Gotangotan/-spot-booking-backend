package nl.spotbooking.spotbooking.controller.archive;

import nl.spotbooking.spotbooking.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BooksController {

    Map<Long, String> data = new HashMap<>();

    // constructor
    BooksController() {
        this.data.put(1L, "Boek1");
        this.data.put(2L, "Boek2");
        this.data.put(3L, "Boek3");
    }

    @GetMapping(value = "/books")
    public ResponseEntity<Object> getBooks() {
        return new ResponseEntity<Object>(this.data.values(), HttpStatus.OK);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable("id") Long id) {
        if (!this.data.keySet().contains(id)) {
            throw new RecordNotFoundException();
        }
        return new ResponseEntity<Object>(this.data.get(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") Long id) {
        if (!this.data.keySet().contains(id)) {
            throw new RecordNotFoundException();
        } else {
            return new ResponseEntity<Object>("Record not found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Object> addBook(@RequestBody String clientName) {
        long maxID = this.data.keySet().stream().max(Comparator.comparing(Long::valueOf)).get();
        this.data.put(maxID + 1, clientName);
        return new ResponseEntity<Object>("Record created", HttpStatus.OK);
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable("id") Long id, @RequestBody String clientName) {
        if (!this.data.keySet().contains(id)) {
            throw new RecordNotFoundException();
        }
        this.data.put(id, clientName);
        return new ResponseEntity<Object>("Record updated", HttpStatus.OK);
    }

}
